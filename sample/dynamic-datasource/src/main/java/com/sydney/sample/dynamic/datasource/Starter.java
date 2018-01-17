package com.sydney.sample.dynamic.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication(scanBasePackages="com.sydney.sample.dynamic.datasource")
//@EnableTransactionManagement
@MapperScan(basePackages="com.sydney.sample.dynamic.datasource",annotationClass = Repository.class)

public class Starter {
	
	public static void main(String[] args){
		new SpringApplicationBuilder(Starter.class).web(true).run(args);
		
	}

}
