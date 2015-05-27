package com.fcy.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test04 {
	public static void main(String[] args) {
		String str="sdFDaaadfKAjAPodfaa";
		String reg="[A-Z]";  //匹配规则
		Pattern p=Pattern.compile(reg);
		Matcher m=p.matcher(str);
		StringBuffer sb=new StringBuffer();
		while(m.find()){    //执行渐进式替换
			m.appendReplacement(sb, m.group().toLowerCase());
		}
		//没有下面一句，输出结果为：sdfdaaadfkajap
		m.appendTail(sb); //将剩余的字符串复制到sb中
		System.out.println(str);
		System.out.println(sb);
		Pattern pattern=Pattern.compile("java",Pattern.CASE_INSENSITIVE|Pattern.COMMENTS);
	}
}
