package com.fcy.test;

import java.util.ArrayList;
import java.util.List;

public class Test08 {
	public static void main(String[] args) {
		List<String> allList = new ArrayList<String>();
		System.out.println("集合操作前是否为空？"+allList.isEmpty());
		allList.add("hello");
		allList.add(0,"world");	//指定位置插入
		allList.add("MLDN");
		System.out.println(allList.contains("hello") ? "\"hello\"字符串否存在!":"\"hello\"字符串存在！");
		List<String> allSub=allList.subList(2, 3);
		System.out.print("集合的截取：");
		for(int i=0;i<allSub.size();i++){
			System.out.print(allList.get(i)+" ");
		}
		System.out.println("\nMLDN字符串的位置："+allList.indexOf("MLDN"));
		System.out.println("集合操作后是否为空？"+allList.isEmpty());
	}
}