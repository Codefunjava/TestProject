package com.fcy.test;

import java.util.ArrayList;
import java.util.List;

public class Test08 {
	public static void main(String[] args) {
		List<String> allList = new ArrayList<String>();
		System.out.println("���ϲ���ǰ�Ƿ�Ϊ�գ�"+allList.isEmpty());
		allList.add("hello");
		allList.add(0,"world");	//ָ��λ�ò���
		allList.add("MLDN");
		System.out.println(allList.contains("hello") ? "\"hello\"�ַ��������!":"\"hello\"�ַ������ڣ�");
		List<String> allSub=allList.subList(2, 3);
		System.out.print("���ϵĽ�ȡ��");
		for(int i=0;i<allSub.size();i++){
			System.out.print(allList.get(i)+" ");
		}
		System.out.println("\nMLDN�ַ�����λ�ã�"+allList.indexOf("MLDN"));
		System.out.println("���ϲ������Ƿ�Ϊ�գ�"+allList.isEmpty());
	}
}