/**
 * 2009-8-20
 */
package com.fcy.security.base64.bouncyCastle;

import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.UrlBase64;
import org.junit.Test;

/**
 * Base64编码与解码测试类
 * 使用bouncycastle 提供的 Base64 API
 */
public class Base64CoderTest {

	/**
	 * 演示
	 * 
	 * @throws Exception
	 */
	@Test
	public final void demo() throws Exception {
		String str = "Base64 编码";
		System.err.println("原文:\t" + str);
		byte[] input = str.getBytes();

		// Base64编码
		byte[] data = Base64.encode(input);
		System.err.println("编码后:\t" + new String(data));

		// Base64解码
		byte[] output = Base64.decode(data);
		System.err.println("解码后:\t" + new String(output));

	}

	/**
	 * 演示
	 * 
	 * @throws Exception
	 */
	@Test
	public final void demo2() throws Exception {
		String str = "Base64 编码";
		System.err.println("原文:\t" + str);
		byte[] input = str.getBytes();

		// Url Base64编码
		byte[] data = UrlBase64.encode(input);
		System.err.println("编码后:\t" + new String(data));

		// Url Base64解码
		byte[] output = UrlBase64.decode(data);
		System.err.println("解码后:\t" + new String(output));
	}
}
