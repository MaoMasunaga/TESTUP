package jp.ac.ohara.E.seisaku.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jp.ac.ohara.E.seisaku.model.GakuseiHyou;
import jp.ac.ohara.E.seisaku.service.StudentDetailsServiceImplt;

@Configuration //設定用のクラスであることをSpringに伝える
@EnableWebSecurity //Spring Securityを使うための設定
public class SecurityConfig {
	@Autowired
	private DataSource dataSource;

	@Autowired
	private StudentDetailsServiceImplt userService;

    @Bean
    UserDetailsManager userDetailsManager() {
		JdbcUserDetailsManager jdbcManager = new JdbcUserDetailsManager(this.dataSource);
		return jdbcManager;
	}
    
    private GakuseiHyou makeUser(String studentnumber, String name, String age, String mail, String phone, String password) {
        GakuseiHyou record = new GakuseiHyou();
        record.setStudentnumber(studentnumber);
        record.setName(name);
        record.setAge(age);
        record.setMail(mail);
        record.setPhone(phone);
        record.setPassword(this.passwordEncoder().encode(password));
        return record;
    }
    

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.httpBasic(
						(basic) -> basic.disable())
				.authorizeHttpRequests(request -> {
					request
							.requestMatchers("/login/").permitAll()     // ログインページは全許可
							.requestMatchers("/register/").permitAll()  // 新規登録ページは全許可
							.requestMatchers("/webjars/**").permitAll() // webjarsのパスは全許可
							.requestMatchers("/js/**").permitAll()      // JSのstaticファイル
							.requestMatchers("/css/**").permitAll()     // CSSのstaticファイル
							.requestMatchers("/images/**").permitAll()  // 画像のstaticファイル
							.anyRequest().authenticated();              // それ以外は認証必須
				})
				.formLogin(form -> {
					form
							.loginPage("/login/")             // ログインページのURI
							.loginProcessingUrl("/login/")    // ログインを実施するページのURI
							.defaultSuccessUrl("/")           // ログイン完了後の遷移先
							.failureUrl("/login/?error=true") // ログインエラーページのURI
							.usernameParameter("studentnumber") // ログインユーザのname属性
							.passwordParameter("password");   // ログインパスワードのname属性
				})
				.userDetailsService(this.userService)
				.logout(logout -> {
					logout
							.logoutUrl("/logout/")
							.logoutSuccessUrl("/login/")
							.deleteCookies("JSESSIONID")
							.invalidateHttpSession(true);
				});
		return http.build();
	}
	
}


