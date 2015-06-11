package com.fcy.security.pbe;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class PBETest {
	
	@Test
	public void test() throws Exception {
		String inputStr = "PBE";
		System.out.println("原文：\t" + inputStr);
		byte[] input = inputStr.getBytes();
		String pwd = "snowolf@zlex.org";
		System.out.println("密码：\t" + pwd);
		byte[] salt = PBECoder.initSalt();
		System.out.println("盐：\t" + Base64.encodeBase64String(salt));
		byte[] data = PBECoder.encrypt(input, pwd, salt);
		System.out.println("加密后：\t" + Base64.encodeBase64String(data));
		byte[] output = PBECoder.decrypt(data, pwd, salt);
		String outputStr = new String(output);
		System.out.println("解密后：\t" + outputStr);
		
		
		
	}
	
}
