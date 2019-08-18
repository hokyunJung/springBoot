package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entitiys.AdsUser;
import com.example.demo.models.DetailsUser;

@Service
public class LoginUserDetailsService implements UserDetailsService {
	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		AdsUser user = userService.getUserById(id);
		if (user == null) {
			throw new UsernameNotFoundException("login fail");
		}
		
		return new DetailsUser(user.getId(), user.getPw(), getAuthorities(user.getId()));
	}
	
    public Collection<GrantedAuthority> getAuthorities(String id) {
        List<String> string_authorities = userService.readAuthority(id);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String authority : string_authorities) {
        	//System.out.println(authority);
             authorities.add(new SimpleGrantedAuthority(authority));
        }
       // System.out.println(authorities);
        return authorities;
   }
}
