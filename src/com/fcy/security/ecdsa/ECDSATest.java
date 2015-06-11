package com.fcy.security.ecdsa;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

public class ECDSATest {
	
	@Test
	public void test() throws Exception{
		Map<String, Object> keyMap = ECDSACoder.initKey();
		byte[] publicKey = ECDSACoder.getPublicKey(keyMap);
		byte[] privateKey = ECDSACoder.getPrivateKey(keyMap);
		System.out.println("公钥：\t" + Base64.encodeBase64String(publicKey));
		System.out.println("私钥：\t" + Base64.encodeBase64String(privateKey));
		
		String inputStr = "RSA数字签名";
		byte[] data = inputStr.getBytes();
		byte[] sign = ECDSACoder.sign(data, privateKey);
		System.out.println("签名：\t" + Hex.encodeHexString(sign));
		boolean status = ECDSACoder.verify(data, publicKey, sign);
		System.out.println("状态：\t" + status);
	}
}
