package com.mb.EmpMangApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mb.EmpMangApp.filter.SecurityFilter;
import com.mb.EmpMangApp.service.ManagerServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ManagerServiceImpl service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private InvalidUserAuthEntryPoint authEntryPoint;
	
	@Autowired
	private SecurityFilter filter;
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(service)
	.passwordEncoder(encoder);
}

@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/manager/employee/save").authenticated()
		.antMatchers("/manager/employee/update").authenticated()
		.antMatchers("/manager/employee/delete").authenticated()
		.antMatchers("/manager/employee/findAllEmp").authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(authEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
		;
	}

@Override
@Bean
public AuthenticationManager authenticationManager() throws Exception {
	return super.authenticationManager();
}
}
