package com.handson.springsecurity.authentication.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// use NoOp PasswordEncoder for inMemoryAuthentication
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin123").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().antMatchers("/").hasRole("USER").and().httpBasic();
	}

}
