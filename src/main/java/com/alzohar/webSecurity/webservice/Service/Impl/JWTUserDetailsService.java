package com.alzohar.webSecurity.webservice.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alzohar.webSecurity.webservice.Entity.User;
import com.alzohar.webSecurity.webservice.Repository.UserRepository;
import com.alzohar.webSecurity.webservice.Service.MyUserDetails;

@Service
public class JWTUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found !");
		}
		return new MyUserDetails(user);
	}
}
