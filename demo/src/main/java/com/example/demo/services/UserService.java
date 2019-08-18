package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import com.example.demo.configures.MyPasswordEncoder;
import com.example.demo.dao.AuthoritysDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entitiys.AdsUser;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AuthoritysDao authoritysDao;
	
	@Autowired
	private MyPasswordEncoder myPasswordEncoder;
	
	public AdsUser getUserById(String id) {
		return userDao.findOneById(id);
	}
	
	@Transactional
	public void createProcessing(String id , String pw) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		AdsUser user = new AdsUser();
		user.setId(id);
		user.setPw(myPasswordEncoder.encode(pw));
		user.setObid(UUID.randomUUID().toString());
		userDao.save(user);
	}
	
	public List<String> readAuthority(String id) {
		return authoritysDao.findListsById(id);
	}
}
