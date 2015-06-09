package com.fcy.security;

import java.security.MessageDigest;
import java.util.Arrays;

public class TestMessageDisgest {
	
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
         "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	public static void main(String[] args) throws Exception {
		byte[] input = "abc".getBytes("UTF-8");
		System.out.println(Arrays.toString(input));
		MessageDigest sha = MessageDigest.getInstance("MD5");
		sha.update(input);
		byte[] output = sha.digest();
		long startTime = System.currentTimeMillis();
		
		StringBuilder result= new StringBuilder();
		for(int i=0;i<output.length;i++){
			//result.append(Integer.toHexString((0x000000ff & output[i]) | 0xffffff00).substring(6));
			result.append(byteToArrayString(output[i]) + " ");
		}
		
		System.out.println(result.toString().toUpperCase());
		
		
		long endTime = System.currentTimeMillis();
		System.out.println("使用时间：" +  (endTime - startTime) + "ms");
				
	}
	
	// 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }
	
	
}
