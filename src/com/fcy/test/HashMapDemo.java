package com.fcy.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("A", "a");
		map.put("B", "b");
		map.put("C", "c");
		//***********��һ�ֱ�����ʽ��Map.Entry***************
		Set<Map.Entry<String, String>> allSet=map.entrySet();
		Iterator<Map.Entry<String, String>> iter=allSet.iterator();
		while(iter.hasNext()){
			Map.Entry<String, String> me=iter.next();
			System.out.println(me.getKey()+"-->"+me.getValue());
		}
		//***********�ڶ��ֱ�����ʽ:��key�õ�value***************
		Set<String> set=map.keySet();
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String st=it.next();
			System.out.println(st+"-->"+map.get(st));//��key�õ�value
		}
		//**********�����ֱ�����ʽ��foreach********************
		for(Map.Entry<String,String> m:map.entrySet()){
			System.out.println(m.getKey()+"-->"+m.getValue());
		}
		
	}
}
