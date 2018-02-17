package com.neeraj.springdbsecurity.SpringDBSecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neeraj.springdbsecurity.SpringDBSecurity.model.CustomUserDetail;
import com.neeraj.springdbsecurity.SpringDBSecurity.model.User;
import com.neeraj.springdbsecurity.SpringDBSecurity.repository.UserRepository;
@Service
public class CustomUserDetialsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<User> optional=userRepo.findByName(userName);
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException("the mentioned userName doesn't exist");
		}
		return new CustomUserDetail(optional.get());
	}

}
