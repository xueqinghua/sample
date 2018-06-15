package com.sydney.sample.feature.customer.entity;

import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpUtils {
	
	
	public Object get(String url,Map<String,Object> parameter) {
		
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		
		HttpPost httpPost = new HttpPost(url);
		

		
		return null;
	}

}
