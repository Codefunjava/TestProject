package com.fcy.regex;

/**
 * 替换叠词：
 * 将字符串中的叠词替换为一个“#”
 * \[m]：取得匹配的第m组，正则表达式内部取
 */
public class Test06 {
	public static void main(String[] args) {
		String str = "adfdsddskffk";
		String reg = "(.)\\1+";
		String arr = str.replaceAll(reg,"#");
		System.out.println(arr);
	}
}
