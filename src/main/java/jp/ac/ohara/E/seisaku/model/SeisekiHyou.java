package jp.ac.ohara.E.seisaku.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="seisekihyou")
public class SeisekiHyou {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column(length = 64, nullable = false)
	private String studentnumber;
	
	@Column(length = 64, nullable = true)
	private String japanese;
	
	@Column(length = 64, nullable = true)
	private String math;
	
	@Column(length = 64, nullable = true)
	private String science;
	
	@Column(length = 64, nullable = true)
	private String society;
	
	@Column(length = 64, nullable = true)
	private String english;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getstudentnumber() {
		return studentnumber;
	}
	
	public void setstudentnumber(String studentnumber) {
		this.studentnumber = studentnumber;
	}
	
	public String getjapanese() {
		return japanese;
	}
	
	public void setjapanese(String japanese) {
		this.japanese = japanese;
	}
	
	public String getmath() {
		return math;
	}
	
	public void setmath(String math) {
		this.math = math;
	}
	
	public String getscience() {
		return science;
	}
	
	public void setscience(String science) {
		this.science = science;
	}
	
	public String getsociety() {
		return society;
	}
	
	public void setsociety(String society) {
		this.society = society;
	}
	
	public String getenglish() {
		return english;
	}
	public void setenglish(String english) {
		this.english = english;
	}
}
