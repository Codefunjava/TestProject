/**
 * 2009-9-3
 */
package com.fcy.security.md.commonCodec;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * MD5校验
 * 
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */
public class MD5CoderTest {

	/**
	 * 测试MD5
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testEncodeMD5() throws Exception {
		String str = "MD5消息摘要";

		// 获得摘要信息
		byte[] data1 = MD5Coder.encodeMD5(str);
		byte[] data2 = MD5Coder.encodeMD5(str);

		// 校验
		assertArrayEquals(data1, data2);
	}

	/**
	 * 测试MD5Hex
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testEncodeMD5Hex() throws Exception {
		String str = "EncodeMD5(activity.gm99.com)";

		// 获得摘要信息
		String data1 = MD5Coder.encodeMD5Hex(str).toUpperCase();
		String data2 = MD5Coder.encodeMD5Hex(str);

		System.err.println("原文：\t" + str);
		
		System.err.println("MD5Hex-1：\t" + data1);
		System.err.println("MD5Hex-2：\t" + data2);
		
	}

}
