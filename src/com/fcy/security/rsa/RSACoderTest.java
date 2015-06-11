package com.fcy.security.rsa;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class RSACoderTest {

	@Test
	public void test() throws Exception{
		Map<String, Object> keyMap = RSACoder.initKey();
		byte[] publicKey = RSACoder.getPublicKey(keyMap);
		byte[] privateKey = RSACoder.getPrivateKey(keyMap);
		System.out.println("公钥：\t" + Base64.encodeBase64String(publicKey));
		System.out.println("私钥：\t" + Base64.encodeBase64String(privateKey));
		
		System.out.println("\n=======私钥加密====公钥解密=========");
		String inputStr1 = "RSA加密算法";
		byte[] data1 = inputStr1.getBytes();
		System.out.println("原文：\t" + inputStr1);
		byte[] encodedData1 = RSACoder.encryptByPrivateKey(data1, privateKey);
		System.out.println("加密后：\t" + Base64.encodeBase64String(encodedData1));
		byte[] decodedData1 = RSACoder.decryptByPublicKey(encodedData1, publicKey);
		String outputStr1 = new String(decodedData1);
		System.out.println("解密后：\t" + outputStr1);
		
		System.out.println("\n=======公钥加密====私钥解密=========");
		String inputStr2 = "RSA Encypt Algorithm";
		byte[] data2 = inputStr2.getBytes();
		System.out.println("原文：\t" + inputStr2);
		byte[] encodedData2 = RSACoder.encryptByPublicKey(data2, publicKey);
		System.out.println("加密后：\t" + Base64.encodeBase64String(encodedData2));
		byte[] decodedData2 = RSACoder.decryptByPrivateKey(encodedData2, privateKey);
		String outputStr2 = new String(decodedData2);
		System.out.println("解密后：\t" + outputStr2);
		
		
	}
	
	
	
	
	
	
	
}













