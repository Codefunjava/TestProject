package com.fcy.security.dh;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

public class DHCoderTest {

	private byte[] publicKey1;
	private byte[] privateKey1;
	private byte[] key1;
	
	private byte[] publicKey2;
	private byte[] privateKey2;
	private byte[] key2;
	
	@Before
	public final void initKey() throws Exception {
		Map<String, Object> keyMap1 = DHCoder.initKey();
		publicKey1 = DHCoder.getPublicKey(keyMap1);
		privateKey1 = DHCoder.getPrivateKey(keyMap1);
		System.out.println("甲方公钥：\t" + Base64.encodeBase64String(publicKey1));
		System.out.println("甲方公钥：\t" + Arrays.toString(publicKey1));
		System.out.println("甲方私钥：\t" + Base64.encodeBase64String(privateKey1));
		Map<String, Object> keyMap2 = DHCoder.initKey(publicKey1);
		publicKey2 = DHCoder.getPublicKey(keyMap2);
		privateKey2 = DHCoder.getPrivateKey(keyMap2);
		System.out.println("乙方公钥：\t" + Base64.encodeBase64String(publicKey2));
		System.out.println("乙方私钥：\t" + Base64.encodeBase64String(privateKey2));
		key1 = DHCoder.getSecretKey(publicKey2, privateKey1);
		System.out.println("二进制本地密钥：\t" + Arrays.toString(key1));
		System.out.println("甲方本地密钥：\t" + Base64.encodeBase64String(key1));
		key2 = DHCoder.getSecretKey(publicKey1, privateKey2);
		System.out.println("乙方本地密钥：\t" + Base64.encodeBase64String(key2));
		
	}
	
	
	@Test
	public void test() throws Exception {
		System.out.println("\n=================甲方向乙方发送加密数据=============");
		String input1 = "密码交换算法";
		System.out.println("原文：\t" + input1);
		System.out.println("======使用甲方本地密钥对数据进行加密========");
		byte[] code1 = DHCoder.encrypt(input1.getBytes(), key1);
		System.out.println("二进制密文：\t" + Arrays.toString(code1));
		System.out.println("加密：\t" + Base64.encodeBase64String(code1));
		byte[] decode1 = DHCoder.decrypt(code1, key2);
		String output1 = new String(decode1);
		System.out.println("解密：\t" + output1);
		System.out.println("\n=========乙方向甲方发送加密数据===========");
		String input2 = "DH";
		System.out.println("原文：\t" + input2);
		System.out.println("===========使用乙方本地密钥对数据加密============");
		byte[] code2 = DHCoder.encrypt(input2.getBytes(), key2);
		System.out.println("加密：\t" + Base64.encodeBase64String(code2));
		System.out.println("===========使用甲方本地密钥对数据解密============");
		byte[] decode2 = DHCoder.decrypt(code2, key1);
		String output2 = new String(decode2);
		System.out.println("解密：\t" + output2);
	}

}






























