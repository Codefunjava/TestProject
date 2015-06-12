package com.fcy.security.desede;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class DESedeTest {
	
	@Test
	public void test() throws Exception {
		String inputStr = "DESede";
		byte[] inputData = inputStr.getBytes();
		System.out.println("原文：\t" + inputStr);
		byte[] key = DESedeCoder.initKey();
		System.out.println("密钥：\t" + Base64.encodeBase64String(inputData));
		inputData = DESedeCoder.encrypt(inputData, key);
		System.out.println("加密后：\t" + Base64.encodeBase64String(inputData));
		byte[] outputData = DESedeCoder.decrypt(inputData, key);
		String outputStr = new String(outputData);
		System.out.println("解密后：\t" + outputStr);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
