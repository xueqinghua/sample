package com.sydney.sample.algorithm.digest;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.junit.Test;

public class MessageDigestTest {
	

	@Test
	public void testMD5() throws Exception {
		
		String plainText = "The earth moves around the sun";
		
		
		
		MessageDigest md5MessageDigest = MessageDigest.getInstance("MD5");
		
		md5MessageDigest.update(plainText.getBytes(Charset.forName("utf-8")));
		
		byte[] md5EncodedBytes = md5MessageDigest.digest();
		
		
		
		MessageDigest shaMessageDigest = MessageDigest.getInstance("sha-1");
		
		
		shaMessageDigest.update(plainText.getBytes(Charset.forName("utf-8")));
		
		
		byte[] shaEncodedBytes = shaMessageDigest.digest();

		System.out.println(Base64.getEncoder().encodeToString(md5EncodedBytes));
		
		System.out.println(DigestUtils.md5Hex(plainText));
		System.out.println(Base64.getEncoder().encodeToString(shaEncodedBytes));
	}
	
	
	@Test
	public void testSHA() throws Exception {
		
		String plainText = "The earth moves around the sun";
		
		MessageDigest shaMessageDigest = MessageDigest.getInstance("sha-1");
		
		
		shaMessageDigest.update(plainText.getBytes(Charset.forName("utf-8")));
		
		byte[] shaEncodedBytes = shaMessageDigest.digest();

		System.out.println(Base64.getEncoder().encodeToString(shaEncodedBytes));
	}
	
	@Test
	public void testMAC() throws Exception {
		
		String plainText = "The earth moves around the sun";
		
		String secret = "123456";
		SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes("utf-8"),HmacAlgorithms.HMAC_SHA_256.getName());
		
		
		Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
		
		mac.init(secretKeySpec);
		
		byte[]  macEncodedBytes = mac.doFinal(plainText.getBytes("utf-8"));
		
		System.out.println(Base64.getEncoder().encodeToString(macEncodedBytes));
		
		
	}
	
	@Test
	public void testDigestUtils() {
		
		long milliseconds = System.currentTimeMillis();
		
		System.out.println(milliseconds);
		
		System.out.println(DigestUtils.md5Hex(milliseconds+"ANCnCEeOQWFQ"));
		
		System.out.println(DigestUtils.md5Hex("123456"));
		//e10adc3949ba59abbe56e057f20f883e
		
	}

}
