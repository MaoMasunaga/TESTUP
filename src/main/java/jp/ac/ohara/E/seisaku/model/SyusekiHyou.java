package jp.ac.ohara.E.seisaku.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 

@Entity
@Table(name="syusekihyou")
public class SyusekiHyou {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column(length = 64, nullable = false)
	private String studentnumber;
	
	@Column(length = 8, nullable = false)
	private String syuketu;
	
	@Column(nullable = false)
	private LocalDateTime syuseki;
	
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
	
	public String getsyuketu() {
		return syuketu;
	}
	
	public void setsyuketu(String syuketu) {
		this.syuketu = syuketu;
	}
	
	public LocalDateTime getsyuseki() {
		return syuseki;
	}
	
	public void setsyuseki(LocalDateTime syuseki) {
		this.syuseki = syuseki;
	}

}
