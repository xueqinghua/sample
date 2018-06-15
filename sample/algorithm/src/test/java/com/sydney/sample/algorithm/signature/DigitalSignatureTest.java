package com.sydney.sample.algorithm.signature;

import static org.junit.Assert.*;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.junit.Test;

public class DigitalSignatureTest {

	@Test
	public void testDSA() throws Exception {
		
		String plainText = "The earth moves around the sun";
		
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
		
		keyPairGenerator.initialize(1024);
		
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		
		
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyPair.getPrivate().getEncoded());
		
		KeyFactory privatekeyFactory = KeyFactory.getInstance(keyPair.getPrivate().getAlgorithm());
		

		PrivateKey privateKey = privatekeyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Signature signature = Signature.getInstance("SHA1withDSA");
		
		signature.initSign(privateKey);
		signature.update(plainText.getBytes("utf-8"));
		
		byte[] signedBytes = signature.sign();
		
		String signedText = Base64.getEncoder().encodeToString(signedBytes);
		
		
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyPair.getPublic().getEncoded());
		
		
		KeyFactory publicKeyFactory = KeyFactory.getInstance(keyPair.getPublic().getAlgorithm());
		
		PublicKey publicKey = publicKeyFactory.generatePublic(x509EncodedKeySpec);
		
		Signature verifySignature = Signature.getInstance("SHA1withDSA");
		
		verifySignature.initVerify(publicKey);
		
		verifySignature.update(plainText.getBytes("utf-8"));
		
		boolean verify = verifySignature.verify(signedBytes);
		
		System.out.println(verify);
		
		
	}
	
	@Test
	public void testPrivateKey() throws Exception {
		
		String plainText = "The earth moves around the sun";
		
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
		
		keyPairGenerator.initialize(1024);
		
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		
		
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyPair.getPrivate().getEncoded());
		
		KeyFactory privatekeyFactory = KeyFactory.getInstance(keyPair.getPrivate().getAlgorithm());
		
		System.out.println("algorithm:"+keyPair.getPrivate().getAlgorithm());
		
		PrivateKey privateKey = privatekeyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Signature signature = Signature.getInstance("SHA1withDSA");
		
		signature.initSign(privateKey);
		signature.update(plainText.getBytes("utf-8"));
		
		byte[] signedBytes = signature.sign();
		
		String signedText = Base64.getEncoder().encodeToString(signedBytes);
		
		System.out.println("signedText :"+signedText);
		
		System.out.println("public key :"+Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
		
		
		
		
		
	}
	
	
	@Test
	public void testPublicKey() throws Exception {
		
		String plainText = "The earth moves around the sun";
		
		String base64EncodedPrivateKey = "MIIBuDCCASwGByqGSM44BAEwggEfAoGBAP1/U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq/xfW6MPbLm1Vs14E7gB00b/JmYLdrmVClpJ+f6AR7ECLCT7up1/63xhv4O1fnxqimFQ8E+4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHHAhUAl2BQjxUjC8yykrmCouuEC/BYHPUCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoDgYUAAoGBAJMTTdMd2JEGRXUfhlSUTSExsbRgXLtZvxoQTIXG0XwMd4H3UCSFK6oDCbHAH5G9FgX3MypjsJUQ2mq0lJrEDfin1QDpap/FEARq99RpVeKssX4Jg7/AROGmu5yBz+iTHaT9KBv2vRm1ndL7HOPYAKy3FWam4qzyF1YFIXO2ZWl0";
		
		String base64EncodedSignedText = "MCwCFC/fs42NlFayS0ISEh0S3mlGYo6kAhR260ZCiOsCnWGXQO2F1HB+rtBP/A==";
		
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64EncodedPrivateKey));
		
		KeyFactory publicKeyFactory = KeyFactory.getInstance("DSA");
		
		PublicKey publicKey = publicKeyFactory.generatePublic(x509EncodedKeySpec);
		
		
		Signature verifySignature = Signature.getInstance("SHA1withDSA");
		verifySignature.initVerify(publicKey);
		
		verifySignature.update(plainText.getBytes("utf-8"));
		
		
		boolean verify = verifySignature.verify(Base64.getDecoder().decode(base64EncodedSignedText));
		
		System.out.println(verify);
		
	}
	
}
