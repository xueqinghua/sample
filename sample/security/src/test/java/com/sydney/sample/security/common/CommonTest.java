package com.sydney.sample.security.common;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.util.DigestUtils;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sydney.sample.security.user.entity.User;

public class CommonTest {
	
	static long a;

	@Test
	public void test() throws Exception {
		
		String[] mac = "00-A0-D1-EA-77-A1,00-A0-D3-EA-77-A0,00-A0-D2-EA-77-A0".split(",");
		
		Arrays.sort(mac);
		
	}
	
	@Test
	public void testLong() {
		System.out.println(a);
	}

}
