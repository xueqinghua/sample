package com.sydney.sample.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sydney.sample.security")
public class Starter {
	
	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}

}
