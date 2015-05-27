package com.fcy.dict;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test01 {
	
	public static void main(String[] args) {
		String[] array={"1","2","3","4"};
		//将数组转化为ArrayList,再调用方法
		listAll(Arrays.asList(array),""); 
	}
	
	public static void listAll(List candidate,String prefix){
		System.out.println(prefix);
		for(int i=0;i<candidate.size();i++){
			List temp =new LinkedList(candidate);
			listAll(temp,prefix+temp.remove(i));  //递归调用
		}
	}
}
