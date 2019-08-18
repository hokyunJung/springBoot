package com.example.demo.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class DetailsUser extends org.springframework.security.core.userdetails.User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DetailsUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}

}
