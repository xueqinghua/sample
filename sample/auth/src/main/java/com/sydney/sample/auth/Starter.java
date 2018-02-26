package com.sydney.sample.auth;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableOAuth2Sso
//@EnableWebSecurity
//@EnableOAuth2Client  // 启用 OAuth 2.0 客户端 
//@EnableGlobalMethodSecurity(prePostEnabled = true) // 启用方法安全设置
public class Starter {
	
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(Starter.class).web(true).run(args);
	}

}
