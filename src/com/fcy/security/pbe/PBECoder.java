package com.fcy.security.pbe;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class PBECoder {
	
	/**
	 * Java 支持以下任意一种算法
	 * PBEWithMD5AndDES 
	 * PBEWithMD5AndTripleDES 
	 * PBEWithSHA1AndDESede
	 * PBEWithSHA1AndRC2_40
	 */
	
	public static final String ALGORITHM = "PBEWITHMD5andDES";
	public static final int ITERATION_COUNT = 100;
	
	/**
	 * 初始化盐
	 * 盐为8位
	 */
	public static byte[] initSalt() throws Exception {
		SecureRandom random = new SecureRandom();
		return random.generateSeed(8);
	}
	
	/**
	 * 将口令转化为密钥 
	 * @param password：口令
	 * @return 转化后的密钥
	 */
	private static Key toKey(String password) throws Exception {
		PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
		return secretKey;
	}
	
	/**
	 * 加密 
	 * data：待加密的数据
	 * password：口令
	 * salt：本次消息中的“盐”
	 */
	public static byte[] encrypt(byte[] data, String password, byte[] salt) throws Exception{
		Key key = toKey(password);
		PBEParameterSpec paramSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
		return cipher.doFinal(data);
	}
	
	/**
	 * 解密
	 * data：待加密的数据
	 * password：口令
	 * salt：本次消息中的“盐”
	 */
	public static byte[] decrypt(byte[] data, String password, byte[] salt) throws Exception {
		Key key = toKey(password);
		PBEParameterSpec paramSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
		return cipher.doFinal(data);
	}
	
}
