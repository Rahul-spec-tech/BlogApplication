package com.example.BlogApplication.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.BlogApplication.model.User;
import com.example.BlogApplication.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepo;
	
	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user=userRepo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), (Collection<? extends GrantedAuthority>) user.getRoles());
	}
}
