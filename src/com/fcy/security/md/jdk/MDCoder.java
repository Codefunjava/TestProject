/**
 * 2009-9-3
 */
package com.fcy.security.md.jdk;

import java.security.MessageDigest;

/**
 * MD加密组件
 * 
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */
public abstract class MDCoder {

	/**
	 * MD2加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeMD2(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("MD2");

		// 执行消息摘要
		return md.digest(data);
	}

	/**
	 * MD5加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeMD5(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("MD5");

		// 执行消息摘要
		return md.digest(data);
	}
//[-86, 36, -122, 48, -103, -49, 36, 105, 109, 78, -80, -8, 44, -111, -120, 73]
}
