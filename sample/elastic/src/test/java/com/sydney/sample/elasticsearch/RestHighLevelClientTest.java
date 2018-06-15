package com.sydney.sample.elasticsearch;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpHost;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsAction;
import org.elasticsearch.action.admin.indices.settings.put.UpdateSettingsRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.VersionType;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.junit.Test;

public class RestHighLevelClientTest {
	
	private RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

	@Test
	public void testAdd() {
		
		
		
		CreateIndexRequest request = new CreateIndexRequest("customer");
		
		request.settings(Settings.builder() 
			    .put("index.number_of_shards", 1)
			    .put("index.number_of_replicas", 1)
			);
		request.alias(
			    new Alias("twitter_alias")  
			);
		
		try {
			CreateIndexResponse createIndexResponse = client.indices().create(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testUpdate() {
		
		Random random = new Random();
		
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("postDate", new Date());
		jsonMap.put("mobile", "mobile_"+random.nextInt(100000));
		UpdateRequest updateRequest = new UpdateRequest("posts", "doc", "1")
		        .doc(jsonMap);
		
		
		ActionListener<UpdateResponse> actionListener = new ActionListener<UpdateResponse>() {

			@Override
			public void onResponse(UpdateResponse response) {
				System.out.println(response);
				
			}

			@Override
			public void onFailure(Exception e) {
				System.out.println(e);
				
			}
		};
		
		client.updateAsync(updateRequest, actionListener);
		
		
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	@Test
	public void testDelete() {
		DeleteRequest request = new DeleteRequest("posts","doc", "1");
		request.timeout(TimeValue.timeValueMinutes(2)); 
		request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
		
		ActionListener<DeleteResponse> actionListener = new ActionListener<DeleteResponse>() {

			@Override
			public void onResponse(DeleteResponse response) {
				System.out.println(response.toString());
				
			}

			@Override
			public void onFailure(Exception e) {
				
				System.out.println(e);
				// TODO Auto-generated method stub
				
			}
		};
		
		
		try {
			client.deleteAsync(request, actionListener);
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("client.deleteAsync");
				}
			}));
			
			Thread.currentThread().sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	public void index() {
		
		
		Random random = new Random();

		try {
			
			for(int i=0;i<10000;i++) {
				
				Map<String, Object> jsonMap = new HashMap<>();
				jsonMap.put("user","user_"+random.nextInt(10000));
				jsonMap.put("email","email_"+random.nextInt(100000000));
				jsonMap.put("mobile","mobile_"+random.nextInt(100000000));
				jsonMap.put("email","email_"+random.nextInt(100000000));
				jsonMap.put("degree","degree");
				jsonMap.put("age",random.nextInt(100000000));
				jsonMap.put("postDate", new Date());
				jsonMap.put("message", "message_"+random.nextInt(100000000));

				
				IndexRequest indexRequest = new IndexRequest("posts", "doc").source(jsonMap);	
				
				client.index(indexRequest);
				
			}
			
			client.close();
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
