package com.fcy.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 匹配字符串的获取
 * 1.将正则表达式封装成对象
 * 2.让正则对象和要操作字符串相关联
 * 3.关联后，获取正则匹配引擎
 * 4.通过引擎对符合规则的子串进行操作，比如取出
 */
public class Test05 {
	public static void main(String[] args) {
		getDemo();
	}
	
	public static void getDemo(){
		String str="ming tian jiu yao fnag jia le,da jie";
		String reg="\\b[a-z]+\\b";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str);
		while(m.find()){
			System.out.print(m.group()+"-->");
			System.out.println(m.start()+"......"+m.end());
		}
	}
	
}
