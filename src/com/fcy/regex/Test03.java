package com.fcy.regex;

import java.util.regex.Pattern;

public class Test03 {
	public static void main(String[] args) {
		String str="A1B22C333D4444E5555F";
		String pat="\\d+";//按数字进行拆分
		Pattern p=Pattern.compile(pat);
		String s[]=p.split(str);
		for(int x=0;x<s.length;x++){
			System.out.print(s[x]+" ");
		}
	}
}
