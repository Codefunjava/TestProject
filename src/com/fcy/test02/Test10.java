package com.fcy.test02;

public class Test10 {
	public static void main(String[] args) {
		int i=-1;
		System.out.println(Integer.toBinaryString(i));
		i>>>=10;
		System.out.println(Integer.toBinaryString(i)+" "+i);
		long l=-1;
		System.out.println(Long.toBinaryString(l));
		short s=-1;
		System.out.println(Integer.toBinaryString(s));
		int x=-2147483648;
		System.out.println(Integer.toBinaryString(x));
		System.out.println((long)Math.pow(2, 31));
	}
}
