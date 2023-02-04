package com.app.springservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.springservice.dto.AuthenticationRequest;
import com.app.springservice.dto.AuthenticationResponse;
import com.app.springservice.repository.UserRepository;
import com.app.springservice.service.MyUserDetailsService;
import com.app.springservice.util.JwtUtil;


@CrossOrigin("*")
@RestController
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtUtil jwtTokenUtil;
	
	@RequestMapping({"/hello"})
	public String hello() {
		return "hello world";
	}
	
	@GetMapping("/helloaws")
	public String awsHello() {
		return "Hi AWS";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
					);
			System.err.println(authenticationRequest.getUsername());
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Incorrect username or password");
		}
		
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody com.app.springservice.model.User user){
		com.app.springservice.model.User userExists = userRepository.findByEmail(user.getEmail());
		System.out.println(userExists);
		if(userExists!=null) {
			throw new BadCredentialsException("User with username " + user.getEmail() + " already exists");
		}
		userRepository.save(user);
		return ResponseEntity.ok().body("User Registered Successfully");
	}
	
	
	
	
}
