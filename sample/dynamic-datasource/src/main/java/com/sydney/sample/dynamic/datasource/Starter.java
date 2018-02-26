package com.sydney.sample.dynamic.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.stereotype.Repository;



@SpringBootApplication(scanBasePackages="com.sydney.sample.dynamic.datasource",exclude=DataSourceAutoConfiguration.class)
//@EnableTransactionManagement
@MapperScan(basePackages="com.sydney.sample.dynamic.datasource",annotationClass = Repository.class)

public class Starter {
	
	public static void main(String[] args){
		new SpringApplicationBuilder(Starter.class).web(true).run(args);
		
	}

}
