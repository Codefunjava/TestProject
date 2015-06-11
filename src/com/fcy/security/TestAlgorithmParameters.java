package com.fcy.security;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Signature;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Enumeration;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

import org.bouncycastle.util.encoders.Base64;
import org.junit.Test;

public class TestAlgorithmParameters {
	
	@Test
	public void testAPGenerator() throws Exception{
		AlgorithmParameterGenerator apg = AlgorithmParameterGenerator.getInstance("DSA");
		apg.init(512);
		AlgorithmParameters ap = apg.generateParameters();
		byte[] b = ap.getEncoded();
		System.out.println(new BigInteger(b).toString());
	}
	
	@Test
	public void testDES() throws Exception{
		AlgorithmParameters ap = AlgorithmParameters.getInstance("DES");
		ap.init(new BigInteger("3944142987328026549711977707912422130783024000487813131182748169658481077298279640108834997312863238302681277913499801313324719383629045579708524861013784775774157338857588067815937091742506413821806762159993015203770089011341790034854690367000666801973675239618431963541483963285749599967216190126369348620842840591868904840591069063408513112643361346330303439076919993680693937334787").toByteArray());
		byte[] b = ap.getEncoded();
		System.out.println(new BigInteger(b).toString());
	}
	
	@Test
	public void testSecureRandom() throws Exception{
		SecureRandom secureRandom = new SecureRandom();
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		kg.init(secureRandom);
		SecretKey secretKey = kg.generateKey();
		byte[] b = secretKey.getEncoded();
		System.out.println(Arrays.toString(b));
		
	}
	
	@Test
	public void testSignature() throws Exception{
		byte[] data = "Data Signature".getBytes();
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
		KeyPair keyPair = keyPairGen.generateKeyPair();
		Signature signature = Signature.getInstance(keyPairGen.getAlgorithm());
		signature.initSign(keyPair.getPrivate());
		signature.update(data);
		byte[] sign = signature.sign();
		signature.initVerify(keyPair.getPublic());
		signature.update(data);
		boolean status = signature.verify(sign);
		System.out.println(status);
		long time = System.currentTimeMillis();
		Timestamp t1 = new Timestamp(time);
		System.out.println("t1: " + t1);
		java.security.Timestamp t2 = new java.security.Timestamp(t1, null);
		System.out.println("t2: " + t2);
				
	}
	
	@Test
	public void testHmacMD5() throws Exception{
		byte[] input = "abc".getBytes();
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		SecretKey secretKey = keyGenerator.generateKey();
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		byte[] output = mac.doFinal(input);
		StringBuilder result= new StringBuilder();
		for(int i=0;i<output.length;i++){
			result.append(Integer.toHexString((0x000000ff & output[i]) | 0xffffff00).substring(6));
		}
		System.out.println(result.toString());
				
	}
	
	@Test
	public void testMacAddr() throws Exception{
		 Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
	        while (networkInterfaces.hasMoreElements()) {
	            NetworkInterface ni = networkInterfaces.nextElement();
	            Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
	            while (inetAddresses.hasMoreElements()) {
	                InetAddress inetAddress = inetAddresses.nextElement();
	                System.out.println(inetAddress.getHostAddress());
	            }
	        }
	}
	
	@Test
	public void testBase64(){
		String str = "base64  编码";
		System.err.println("原文：\t" + str);
		byte[] input = str.getBytes();
		byte[] data = Base64.encode(input);
		System.err.println("编码后：\t" + new String(data));
		byte[] output = Base64.decode(data);
		System.err.println("解码后：\t" + new String(output));
		String code = "QUFodHRwOi8vMzMubXVraXNzLm5ldC/Q1LCuucrKwiAozrSEaJxwsOYpIFvW0M7E19bEu10ubXA0Wlo=";
		byte[] sour = Base64.decode(code.getBytes());
		System.out.println(new String(sour));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
