package com.example.demo.configures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.services.LoginUserDetailsService;

@Configuration
public class AuthenticationConfigure extends GlobalAuthenticationConfigurerAdapter {
	@Autowired
	LoginUserDetailsService userDetailsService;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new MyPasswordEncoder();
	}
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}
