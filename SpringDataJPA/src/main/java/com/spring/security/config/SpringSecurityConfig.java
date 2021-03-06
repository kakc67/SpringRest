package com.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	//Create two user's for Demo
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("user").password("{noop}pwd").roles("USER")
		.and()
		.withUser("admin").password("{noop}admin").roles("ADMIN");
		
	}
	
	//Secure the endpoints with HTTP BASIC Authentication
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET,"/books/**").hasRole("USER")
		.antMatchers(HttpMethod.POST,"/books").hasRole("USER")
		.antMatchers(HttpMethod.PUT,"/books/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.PATCH,"/books/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/books/**").hasRole("ADMIN")
		.and()
		.csrf().disable()
		.formLogin().disable()
		.headers().frameOptions().disable();
		
	}

		
	

}
