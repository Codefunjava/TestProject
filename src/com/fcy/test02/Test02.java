package com.fcy.test02;
public class Test02 {
	public static String fun(String a,String b){
		return a+b;
	}
	public static void main(String[] args) {
		String str="hello world";
		char[] ch=str.toCharArray();
		for(char c:ch){
			System.out.print(c+" ");
		}
		String str2=new String(ch);
		System.out.println("\nhello world");
		String a="hello ";
		String b="world";
		System.out.println(fun(a,b));
		System.out.println(str2);
	}
}
