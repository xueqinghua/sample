package com.sydney.sample.auth.common.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.antMatcher("/**")
		.authorizeRequests()
		.antMatchers("/","/index","/login**","/webjars/**")
		.permitAll()
		.anyRequest().authenticated().and().logout().logoutSuccessUrl("/").permitAll();
	}

	

}