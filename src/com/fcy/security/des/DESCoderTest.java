package com.fcy.security.des;

import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class DESCoderTest {
	/**
	 * 运行后，得到的解密结果为空字符串
	 * 不明原因
	 * 
	 * @throws Exception
	 */
	@Test
	public final void test() throws Exception {
		String inputStr = "DES";
		byte[] inputData = inputStr.getBytes();
		System.out.println("原文：\t" + Arrays.toString(inputData));
		System.out.println("原文：\t" + inputStr);
		
		byte[] key = DESCoder.initKey();
		System.out.println("密钥：\t" + Arrays.toString(key));
		System.out.println("密钥：\t" + Base64.encodeBase64String(key));
		inputData = DESCoder.encrypt(inputData, key);
		System.out.println("加密后：\t" + Arrays.toString(inputData));
		byte[] outputData = DESCoder.decrypt(inputData, key);
		System.out.println("解密后：\t" + Arrays.toString(outputData));
		String outputStr = new String(outputData);
		System.out.println("解密后：\t" + outputStr);
		
		
	}
}












