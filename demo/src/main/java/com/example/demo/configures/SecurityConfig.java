package com.example.demo.configures;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	public void configure(WebSecurity web) {
		//web.ignoring().antMatchers("/**");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/**").authenticated()
			.and()
			.formLogin().loginPage("/login").loginProcessingUrl("/loginProc").defaultSuccessUrl("/main")
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
	}
}
