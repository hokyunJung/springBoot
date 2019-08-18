package com.example.demo.entitiys;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

@Entity
@Table(name="user")
public class AdsUser {
	private String id;
	 private String pw;
	 @Id
	 private String obid;
	 private String role;
	 //private List<GrantedAuthority> authoritys;
	
	
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getObid() {
		return obid;
	}
	public void setObid(String obid) {
		this.obid = obid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
	


}
