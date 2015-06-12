/**
 * 2009-8-20
 */
package com.fcy.security.base64.java6;

import org.junit.Test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Base64编码与解码测试类
 * 
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("restriction")
public class Base64CoderTest {

	/**
	 * Base64编码与解码测试类
	 * 使用jdk 自带的 Base64 API
	 * 
	 */
	@Test
	public final void demo() throws Exception {
		String str = "Java加密与解密的艺术";
		System.err.println("原文:\n\t" + str);
		byte[] input = str.getBytes();

		// Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		String data = encoder.encodeBuffer(input);
		System.err.println("编码后:\n\t" + data);

		// Base64解码
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] output = decoder.decodeBuffer(data);
		System.err.println("解码后:\n\t" + new String(output));

	}

}
