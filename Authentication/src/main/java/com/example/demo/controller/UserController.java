package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.JwtRequest;
import com.example.demo.entity.JwtResponse;
import com.example.demo.entity.User;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private JwtService jwtService;

	@PostMapping({ "/registerNewUser" })
	public User registerNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);
	}

	@PostMapping({ "/authenticate" })
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		return jwtService.createJwtToken(jwtRequest);
	}
	
	@GetMapping({ "/forAdmin" })
	@PreAuthorize("hasRole('Admin')")
	public String forInstructor() {
	return "This URL is only accessible for Admin";
	}

	@GetMapping({ "/forOwner" })
	@PreAuthorize("hasRole('Owner')")
	public String forUser() {
	return "This URL is only accessible for Owner";
	}
}
