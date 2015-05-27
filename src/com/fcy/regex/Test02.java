package com.fcy.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test02 {
	public static void main(String[] args) {
		String str="A1B22C333D4444E5555F";
		String pat="\\d+";  //按多个数字拆分
		Pattern p=Pattern.compile(pat);
		Matcher m=p.matcher(str);
		String newString=m.replaceAll("");
		System.out.println(newString);
	}
}
