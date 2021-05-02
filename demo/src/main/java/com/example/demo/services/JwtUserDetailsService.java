package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	String ROLE_PREFIX = "ROLE_";


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("admin".equals(username)) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        	authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + "ADMIN"));
			return new User("admin", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
			authorities);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}