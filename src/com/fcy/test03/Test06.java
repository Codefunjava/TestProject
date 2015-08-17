package com.fcy.test03;

import java.util.regex.Pattern;


public class Test06 {
	public static void main(String[] args) {
		String sql = "select a, b, c, d, e FROM t_activity WHERE SELECT * FROM group by group by"; 
		//String regex = "SELECT\\b.*?\\bFROM";
		String regex = "group\\s+?by";
		String replaceStr = "SELECT COUNT(*) FROM";
		
		String str = replaceStr(sql, regex, replaceStr);
		boolean flag = findByString(sql, "group\\s+?by");
		System.out.println(flag);
		System.out.println(str);
	}
	
	
	public static String replaceStr(String str, String regex, String replaceStr){
		return Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(str).replaceFirst(replaceStr);
	}
	public static boolean findByString(String str, String regex){
		return Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(str).find();
	}
	
}
