package com.sydney.sample.algorithm.reflection;


import java.lang.reflect.Field;
import java.util.Arrays;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.junit.Test;

import com.sydney.sample.algorithm.customer.entity.Customer;

public class ReflectionTest {

	@Test
	public void testField() throws Exception {
		Customer customer = new Customer();
		customer.setId("123");
		customer.setMobile("2001");
		customer.setName("香港中环店");
		customer.setAge(1000);
		
		
		Field[] fields = customer.getClass().getDeclaredFields();
		
		StringBuilder plainTextStringBuilder = new StringBuilder();
		
		plainTextStringBuilder.append("20161021180115");
		
		Object fieldValue = null;
		
		for(Field field:fields) {
			
			System.out.println(field.getName());
			
			field.setAccessible(true);
			
			fieldValue = field.get(customer);
			
			if (fieldValue instanceof String) {
				plainTextStringBuilder.append(fieldValue);
			}

		}
		
		String plainText = plainTextStringBuilder.toString();
		
		char[] chars = plainText.toCharArray();
		
		
		Arrays.sort(chars);
		
		plainText = new String(chars);
		
		
		String secret = "ANCnCEeOQWFQ";
		SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes("utf-8"),HmacAlgorithms.HMAC_SHA_256.getName());
		
		
		Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
		
		mac.init(secretKeySpec);
		
		byte[]  macEncodedBytes = mac.doFinal(plainText.getBytes("utf-8"));
		
		
		String signature = Base64.encodeBase64URLSafeString(macEncodedBytes);
		
		System.out.println(signature);
		
	}

}
