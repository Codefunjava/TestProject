package com.fcy.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test01 {
	public static void main(String[] args) {
		String str="1983-07-27";			//进行匹配的字符
		String pat="\\d{4}-\\d{2}-\\d{2}"; 	//正则表达式
		Pattern p=Pattern.compile(pat);  	//获取Pattern实例
		Matcher m=p.matcher(str);    	    //获取Matcher实例
		if(m.matches()){            		//进行匹配
			System.out.println("日期格式合法！");
		}else{
			System.out.println("日期格式不合法！");
		}
	}
}
