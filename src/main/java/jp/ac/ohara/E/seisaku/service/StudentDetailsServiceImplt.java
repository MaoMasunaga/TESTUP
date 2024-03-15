package jp.ac.ohara.E.seisaku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.ac.ohara.E.seisaku.model.GakuseiHyou;
import jp.ac.ohara.E.seisaku.repository.GakuseiRepository;

@Service
public class StudentDetailsServiceImplt implements UserDetailsService {

	@Autowired
	private GakuseiRepository userRepository; // ユーザモデルのRepository

	/**
	 * ユーザの検索を行う
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("serach studentnumber : " + username);
		GakuseiHyou user = this.userRepository.findByStudentnumberEquals(username); // emailで検索するので「EmailEquals」としている
		System.out.println(user.toString());
		return user;
	}
}