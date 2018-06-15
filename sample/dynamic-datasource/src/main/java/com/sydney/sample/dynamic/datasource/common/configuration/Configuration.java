package com.sydney.sample.dynamic.datasource.common.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean(name="db_1")
	@ConfigurationProperties(prefix="spring.datasource.db_1")
	public DataSource dataSourceYcloudReadOnly() {
		
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}
	
	@Bean(name="db_2")
	@ConfigurationProperties(prefix="spring.datasource.db_2")
	public DataSource dataSourceYcloudReadWrite() {
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}
	
	@Bean(name="db_3")
	@ConfigurationProperties(prefix="spring.datasource.db_3")
	public DataSource DataSourceYoaReadOnly() {
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}
	
	@Bean
	@Primary
	public DataSource  dataSource(@Qualifier("db_1")DataSource dataSourceYcloudReadOnly,@Qualifier("db_2")DataSource dataSourceYcloudReadWrite,@Qualifier("db_3")DataSource dataSourceYoaReadOnly) {

		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		
		dynamicDataSource.setDefaultTargetDataSource(dataSourceYcloudReadOnly);
		
		Map<Object,Object> targetDataSources = new HashMap<>();
		targetDataSources.put("db_1",dataSourceYcloudReadOnly);
		targetDataSources.put("db_2",dataSourceYcloudReadWrite);
		targetDataSources.put("db_3",dataSourceYoaReadOnly);
		
		dynamicDataSource.setTargetDataSources(targetDataSources);
		
		
		return dynamicDataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setTypeAliasesPackage("com.sydney.sample.dynamic.datasource");
		
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources =resolver.getResources("mappings/com/sydney/sample/dynamic/datasource/**/*Dao.xml");
		factoryBean.setMapperLocations(resources);
		
		return factoryBean;
	}

}
