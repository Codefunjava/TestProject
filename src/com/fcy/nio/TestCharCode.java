package com.fcy.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class TestCharCode {
	public static void main(String[] args) throws CharacterCodingException {
		Charset latinl = Charset.forName("ISO-8859-1");
		CharsetEncoder encoder = latinl.newEncoder();
		CharsetDecoder decoder = latinl.newDecoder();
		CharBuffer cb = CharBuffer.wrap("不有在不中上");
		ByteBuffer buf = encoder.encode(cb);
		System.out.println(decoder.decode(buf));
		
	}
}






















