package com.fcy.test;

import java.util.ArrayList;
import java.util.List;

public class Test07 {
	public static void main(String[] args) {
		List<String> allList = new ArrayList<String>();
		allList.add("hello");
		allList.add(0,"world");	//指定位置插入
		allList.add("MLDN");
		String str[]=allList.toArray(new String[]{});//指定泛型的类型
		for(int i=0;i<str.length;i++){
			System.out.print(str[i]+" ");
		}
		System.out.println("\n直接返回数组对象");
		Object obj[]=allList.toArray();
		for(int i=0;i<obj.length;i++){
			String temp=(String)obj[i];
			System.out.print(temp+" ");
		}
	}
}
