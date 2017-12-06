package com.sydney.sample.dynamic.datasource.common.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	
	@Bean
	public DataSource dataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		
		DruidDataSource druidDataSourceA = new DruidDataSource();
		druidDataSourceA.setUrl("jdbc:mysql://192.168.10.217:3306/ycloud?useUnicode=true&characterEncoding=utf-8");
		druidDataSourceA.setUsername("root");
		druidDataSourceA.setPassword("rootwywk123");
		druidDataSourceA.setDriverClassName("com.mysql.jdbc.Driver");
		druidDataSourceA.setInitialSize(10);
		druidDataSourceA.setMaxActive(100);
		druidDataSourceA.setTimeBetweenEvictionRunsMillis(60000);
		druidDataSourceA.setMinIdle(10);
		
		DruidDataSource druidDataSourceB = new DruidDataSource();
		druidDataSourceB.setUrl("jdbc:mysql://192.168.10.125:3306/ycloud-pro-20170414?useUnicode=true&characterEncoding=utf-8");
		druidDataSourceB.setUsername("root");
		druidDataSourceB.setPassword("rootwywk123");
		druidDataSourceB.setDriverClassName("com.mysql.jdbc.Driver");
		druidDataSourceB.setInitialSize(10);
		druidDataSourceB.setMaxActive(100);
		druidDataSourceB.setTimeBetweenEvictionRunsMillis(60000);
		druidDataSourceB.setMinIdle(10);
		
		dynamicDataSource.setDefaultTargetDataSource(druidDataSourceA);
		
		Map<Object,Object> targetDataSources = new HashMap<>();
		targetDataSources.put("ycloud",druidDataSourceA);
		targetDataSources.put("yoa",druidDataSourceB);
		
		dynamicDataSource.setTargetDataSources(targetDataSources);
		
		
		return dynamicDataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean( DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setTypeAliasesPackage("com.sydney.sample.dynamic.datasource.user");
		
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources =resolver.getResources("mappings/com/sydney/sample/dynamic/datasource/**/UserDao.xml");
		factoryBean.setMapperLocations(resources);
		
		return factoryBean;
	}

}
