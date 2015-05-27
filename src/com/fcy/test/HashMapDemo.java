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
		//***********第一种遍历方式：Map.Entry***************
		Set<Map.Entry<String, String>> allSet=map.entrySet();
		Iterator<Map.Entry<String, String>> iter=allSet.iterator();
		while(iter.hasNext()){
			Map.Entry<String, String> me=iter.next();
			System.out.println(me.getKey()+"-->"+me.getValue());
		}
		//***********第二种遍历方式:由key得到value***************
		Set<String> set=map.keySet();
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String st=it.next();
			System.out.println(st+"-->"+map.get(st));//由key得到value
		}
		//**********第三种遍历方式：foreach********************
		for(Map.Entry<String,String> m:map.entrySet()){
			System.out.println(m.getKey()+"-->"+m.getValue());
		}
		
	}
}
