package com.fcy.test;

public class Test09 {
	public static void main(String[] args) {
		String str1="hello world";
		String str2="hello"+" world";
		String str3="hello";
		String str4=" world";
		String str5=str3+str4;
		System.out.println("str5:"+str5);
		System.out.println("str1==str2:"+(str1==str2));
		System.out.println("str1==str5:"+(str1==str5));
		System.out.println(str2.indexOf('h'));
	}
}
