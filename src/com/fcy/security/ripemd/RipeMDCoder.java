package com.fcy.security.ripemd;

import java.security.MessageDigest;
import java.security.Security;
import java.util.Arrays;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

public class RipeMDCoder {
	public static String encodeRipeMD128(byte[] data) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("RipeMD128");
		byte[] byteArr = md.digest(data);
		System.out.println(Arrays.toString(byteArr));
		return new String(Hex.encode(byteArr));
	}
	
	public static void main(String[] args) throws Exception {
		String str = "ripeMd128";
		System.out.println(encodeRipeMD128(str.getBytes()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}









