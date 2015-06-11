package com.fcy.security.dsa;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

public class DSASignTest {
	
	@Test
	public void test() throws Exception{
		Map<String, Object> keyMap = DSACoder.initKey();
		byte[] publicKey = DSACoder.getPublicKey(keyMap);
		byte[] privateKey = DSACoder.getPrivateKey(keyMap);
		System.out.println("公钥：\t" + Base64.encodeBase64String(publicKey));
		System.out.println("私钥：\t" + Base64.encodeBase64String(privateKey));
		
		String inputStr = "RSA数字签名";
		byte[] data = inputStr.getBytes();
		byte[] sign = DSACoder.sign(data, privateKey);
		System.out.println("签名：\t" + Hex.encodeHexString(sign));
		boolean status = DSACoder.verify(data, publicKey, sign);
		System.out.println("状态：\t" + status);
	}
	
}






















