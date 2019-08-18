package com.example.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SignInSuccess implements ApplicationListener<AuthenticationSuccessEvent>
{
	Logger logger = LoggerFactory.getLogger(SignInSuccess.class);
	
	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event)
	{
		String account = ((UserDetails)(event.getAuthentication().getPrincipal())).getUsername();
		logger.info("임시 : 접속성공 : " + account);
		// 마지막 접속날짜라던지 여러가지.. 입력
	}
}