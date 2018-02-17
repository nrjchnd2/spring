package com.neeraj.springdbsecurity.SpringDBSecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/all")
	public String showAll() {
		return "Welcome All";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/all/secured")
	public String showSecured() {
		return "Welcome.....you area authenticated";
	}
	

}
