package com.fcy.dict;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test03 {
	
	public static void main(String[] args) {
		String str="aavzcadfdsfsdhshgWasdfasdfdddaaa";
		Test03 t=new Test03();
		//Map map=t.count(str);
		Map<String,Integer> map=t.maxCount(t.count(str));
		t.print(map);
	}
	//统计字符串中每个字符出现的次数
	public Map<String,Integer> count(String s){
		Map<String,Integer> map=new TreeMap<String,Integer>();
		char ch[]=s.toCharArray();
		for(int i=0;i<ch.length;i++){
			String input=String.valueOf(ch[i]);
			if(!map.containsKey(input)){
				map.put(input, 1);
			}else{
				int count=map.get(input);
				map.put(input, ++count);
			}
		}
		return map;
	}
	//将最大次数的字符加入到map中
	public Map<String,Integer> maxCount(Map<String,Integer> m){
		Map<String,Integer> map=new TreeMap<String,Integer>();
		//设置一个变量max
		int max=0;
		//得到keySet
		Set<String> set=m.keySet();
		//遍历set，得到max的值
		for(String s:set){
			int value=m.get(s);
			if(value>max){
				max=value;
			}
		}
		//遍历set，当value=max时，将key和value添加到map中
		for(String s:set){
			int value=m.get(s);
			//添加条件
			if(value==max){
				map.put(s, value);
			}
		}
		return map;
	}
	//遍历map
	public void print(Map<String,Integer> map){
		Set<String> set=map.keySet();
		for(String s:set){
			System.out.println(s+"->"+map.get(s));
		}
	}
}
