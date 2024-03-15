package jp.ac.ohara.E.seisaku.model.form;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class LoginForm {
	
	@Column(length = 64, nullable = false)
	private String studentnumber;
	
	@Column(length = 64, nullable = false)
	private String password;
	
	
	
	

}
