package com.fcy.security.ecdsa;

import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class ECDSACoder {
	
	public static final String KEY_ALGORITHM = "ECDSA";
	
	private static final String SIGNATURE_ALGORITHM = "SHA512withECDSA";
	private static final String PUBLIC_KEY = "ECDSAPublicKey";
	private static final String PRIVATE_KEY = "ECDSAPrivateKey";
	
	/**
	 * 签名
	 */
	public static byte[] sign(byte[] data, byte[] privateKey) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(priKey);
		signature.update(data);
		return signature.sign();
	}
	
	public static boolean verify(byte[] data, byte[] publicKey, byte[] sign) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(pubKey);
		signature.update(data);
		return signature.verify(sign);
	}
	
	/**
	 * 取得私钥
	 */
	public static byte[] getPrivateKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return key.getEncoded();
	}
	
	/**
	 * 取得公钥
	 */
	public static byte[] getPublicKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PUBLIC_KEY);
		return key.getEncoded();
	}
	
	/**
	 * 初始化密钥
	 */
	public static Map<String, Object> initKey() throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		BigInteger p = new BigInteger("8834235");
		ECFieldFp ecFieldFp = new ECFieldFp(p);
		BigInteger a = new BigInteger("7ffffff", 16);
		BigInteger b = new BigInteger("33", 16);
		EllipticCurve ellipticCurve = new EllipticCurve(ecFieldFp, a, b);
		BigInteger x = new BigInteger("22");
		BigInteger y = new BigInteger("44");
		ECPoint g = new ECPoint(x, y);
		BigInteger n = new BigInteger("55");
		ECParameterSpec ecParameterSpec = new ECParameterSpec(ellipticCurve, g, n, 1);
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGenerator.initialize(ecParameterSpec, new SecureRandom());
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		ECPublicKey publicKey = (ECPublicKey) keyPair.getPublic();
		ECPrivateKey privateKey = (ECPrivateKey) keyPair.getPrivate();
		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;
	}
	
	
	
	
}
