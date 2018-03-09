package com.sydney.sample.security.common.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.sydney.sample.security.common.authentication.CustomUserDetailsService;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	UserDetailsService customUserDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
        http
        .authorizeRequests()
        .antMatchers("/login/**").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login").successForwardUrl("/user/list")
            .permitAll()
            .and()
        .logout()
            .permitAll();
	}
	
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder,UserDetailsService userDetailsService) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService);
    }

}
