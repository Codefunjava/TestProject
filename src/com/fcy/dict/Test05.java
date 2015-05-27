package com.fcy.dict;

import java.util.Date;

public class Test05 implements Cloneable{
	private Date begin;
	public Date getBegin(){
		return this.begin;
	}
	public void setBegin(Date d){
		this.begin=d;
	}
	public Object clone(){
		Object obj=null;
		try{
			obj=super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return obj;
	}
	public static void main(String[] args) {
		//for循环可以不使用“{}”，但仅限于执行语句
		//并不包括声明语句
		//下列代码中的k作用范围是整个main方法
		//故会引起变量重复定义错误，给for加上“{}”就正确了
		for(int i=0;i<=10;i++){
			Integer k=new Integer(i);
		}
		System.out.println("hello world");
	}
}
