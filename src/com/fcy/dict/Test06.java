package com.fcy.dict;

import java.util.ArrayList;
import java.util.List;

public class Test06 {
	private String value=null;
	public Test06(String v){
		value=v;
	}
	public boolean equals(Test06 o){
		if(o==this){
			return true;
		}
		if(o instanceof Test06){
			Test06 test=(Test06) o;
			return value.equals(test.value);
		}
		return false;
	}
	public static void main(String[] args) {
		List list=new ArrayList();
		Test06 test1=new Test06("object");
		Test06 test2=new Test06("object");
		Test06 test3=new Test06("object");
		Object test4=new Test06("object");
		list.add(test1);
		//test1与test2的地址不同
		System.out.println(list.contains(test2)); //false
		//调用的是Test06类的equals()方法 
		System.out.println(test2.equals(test3));  //true
		//调用的是Object类的equals()方法 
		System.out.println(test3.equals(test4));  //false
	}
}
