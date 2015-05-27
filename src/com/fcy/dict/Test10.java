package com.fcy.dict;

public class Test10 {
	public static void main(String[] args) {
		String str="2006-04-15 02:31:04";
//		str=str.replaceAll("-", "");
//		str=str.replaceAll(":", "");
//		str=str.replaceAll(" ", "");
//		System.out.println(str);
		
		String str2="";
		String []result=str.split("\\D");
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
			str2+=result[i];
		}
		System.out.println(str2);
		
	}
}
