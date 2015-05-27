package com.fcy.regex;

/**
 * 叠词处理：
 * 将叠词替换成本身
 * $[m]：取得匹配的第m组，正则表达式外部取
 */

public class Test07 {
	public static void main(String[] args) {
		String str = "addddfdssssddskffkkkkkkk";
		System.out.println(str);
		String reg = "(.)\\1+";
		String arr = str.replaceAll(reg,"$1");
		System.out.println(arr);
	}
}
