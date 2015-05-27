package com.fcy.dict;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;


public class Test02 {
	public static void main(String args[]){
		String input="aavzcadfdsfsdhshgWasdfasdfdddaaa";
		new Test02().doString(input);
	}
	
	public void doString(String input){
		char[] chars=input.toCharArray();
		ArrayList<String> lists=new ArrayList<String>();
		TreeSet<String> set=new TreeSet<String>();
		//将字符中的字符一个个分别加入list和set中
		for(int i=0;i<chars.length;i++){
			lists.add(String.valueOf(chars[i]));
			set.add(String.valueOf(chars[i]));
		}
		System.out.println(set);
		//将lists中的字符进行排序后输出
		Collections.sort(lists); 
		System.out.println(lists);
		//将排序后的lists中的字符放入sb中
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<lists.size();i++){
			sb.append(lists.get(i));
		}
		//输出sb
		input =sb.toString();
		System.out.println(input);
		int max=0;
		String maxString="";
		ArrayList<String> maxList=new ArrayList<String>();
		//遍历set
		Iterator<String> its=set.iterator();
		while(its.hasNext()){
			String os=(String)its.next();
			int begin=input.indexOf(os);
			int end=input.lastIndexOf(os);
			int value=end-begin+1;
			if(value>max){
				max=value;
				maxString=os;
				maxList.add(os);
			}else if(value==max){
				maxList.add(os);
			}
		}
		int index=0;
		for(int i=0;i<maxList.size();i++){
			if(maxList.get(i).equals(maxString)){
				index=i;
				break;
			}
		}
		System.out.print("max data:");
		for(int i=index;i<maxList.size();i++){
			System.out.print(maxList.get(i)+" ");
		}
		System.out.println();
		System.out.println("max:"+max);
	}
	
}
