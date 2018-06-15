package com.sydney.sample.elasticsearch;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.ElasticSearchDruidDataSourceFactory;

public class JdbcTest {

	@Test
	public void test() {
        try {
			Properties properties = new Properties();
			properties.put("url", "jdbc:elasticsearch://127.0.0.1:9300/" +"posts");
			DruidDataSource druidDataSource = (DruidDataSource) ElasticSearchDruidDataSourceFactory.createDataSource(properties);
			Connection connection = druidDataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from  posts limit 100000");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			int count = 0;
			
			while (resultSet.next()) {
				  count++;
				  
			      System.out.println(resultSet.getString("user") + "," + resultSet.getString("email") + "," + resultSet.getString("mobile"));
			}
			
			System.out.println(count);
			
			preparedStatement.close();
			connection.close();
			druidDataSource.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
