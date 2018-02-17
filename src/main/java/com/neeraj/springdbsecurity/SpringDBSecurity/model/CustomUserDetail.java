package com.neeraj.springdbsecurity.SpringDBSecurity.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetail extends User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return getRoles().stream().map(role->new SimpleGrantedAuthority("ROLE_"+role.getName()))
				.collect(Collectors.toList());
	}
	
	

	public CustomUserDetail(User user) {
		super(user);
		
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getFname();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
