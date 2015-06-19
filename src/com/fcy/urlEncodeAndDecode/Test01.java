package com.fcy.urlEncodeAndDecode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test01 {
	
	public static String str = "nUgtv1Kv0qxmPBknLav+13zcjokCkx+86sQtLKVtynbThBIVma5smQ==";
	
	public static void main(String[] args){
		try {
			System.out.println("str:\t\t" + str);
			String encodeString = URLEncoder.encode(str, "utf-8");
			System.out.println("encodeString:\t" + encodeString);
			String decodeString = URLDecoder.decode(encodeString, "utf-8");
			System.out.println("decodeString:\t" + decodeString);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
