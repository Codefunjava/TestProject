package com.fcy.security.mac;

import java.util.Arrays;

import org.junit.Test;

public class MACCoderTest {
	@Test
	public final void testEncodeHmacMd5() throws Exception{
		String str = "HmacMD5消息摘要";
		byte[] key = MACCoder.initHmacMD5key();
		byte[] data1 = MACCoder.encodeHmacMD5(str.getBytes(), key);
		byte[] key2 = MACCoder.initHmacMD5key();
		byte[] data2 = MACCoder.encodeHmacMD5(str.getBytes(), key2);
		System.out.println(Arrays.toString(data1));
		System.out.println(Arrays.toString(data2));

	}

}


















