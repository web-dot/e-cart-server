package com.app.springservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.springservice.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {    
        UserDetails userDetails = User.withUsername(userRepository.findByEmail(email).getEmail()).password(userRepository.findByEmail(email).getPassword()).passwordEncoder(encoder::encode).roles("USER").build();
        return userDetails;
	}
}
