package com.neeraj.springdbsecurity.SpringDBSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import com.neeraj.springdbsecurity.SpringDBSecurity.repository.UserRepository;
import com.neeraj.springdbsecurity.SpringDBSecurity.service.CustomUserDetialsService;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableJpaRepositories(basePackageClasses=UserRepository.class)
@EnableWebSecurity
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	@Autowired
	CustomUserDetialsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(new org.springframework.security.crypto.password.PasswordEncoder() {
				
				@Override
				public boolean matches(CharSequence arg0, String arg1) {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public String encode(CharSequence arg0) {
					// TODO Auto-generated method stub
					return arg0.toString();
				}
			});
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("**/secured/**").authenticated()
			.anyRequest().permitAll()
			.and()
			.formLogin().permitAll();
			
	}
	
	
	

}
