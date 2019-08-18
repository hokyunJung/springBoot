package com.example.demo.configures;

import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.utils.WebUtils;

@Component
public class MyPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		String encrytedPass = null;
		try {
			encrytedPass = WebUtils.sha256(rawPassword.toString());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encrytedPass;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		System.out.println(encodedPassword);
		System.out.println(encode(rawPassword));
		return encodedPassword.equals(encode(rawPassword));
	}
	
}
