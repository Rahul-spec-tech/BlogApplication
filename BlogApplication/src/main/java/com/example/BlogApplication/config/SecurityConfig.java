package com.example.BlogApplication.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.BlogApplication.service.CustomUserDetailsService;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration{
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	@SuppressWarnings({ "removal" })
	protected void configure(HttpSecurity http) throws Exception{
		http.
			authorizeHttpRequests() 
				.requestMatchers("signup","/login").permitAll()
				.requestMatchers("/private/**").authenticated()
				.anyRequest().permitAll()
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/posts", true)
				.permitAll()
				.and()
			.logout()
				.permitAll();			
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
