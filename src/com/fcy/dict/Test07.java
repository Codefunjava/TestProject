package com.fcy.dict;

import java.util.HashMap;
import java.util.Map;

public class Test07 {
	public static void main(String[] args) {
		Map<String,String> map=new HashMap<String,String>();
		map.put(String.valueOf(System.currentTimeMillis())+"a","1");
		map.put(String.valueOf(System.currentTimeMillis())+"a","2");
		map.put(String.valueOf(System.currentTimeMillis())+"a","3");
		for(Map.Entry<String,String> entry:map.entrySet()){
			System.out.println(entry.getValue());
		}
	}
	
}
