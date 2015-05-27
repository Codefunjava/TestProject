package com.fcy.test;

import java.util.HashSet;
import java.util.Set;

class Person{
	private String name;
	private int age;
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return "姓名："+this.name+";年龄："+this.age;
	}
	/**
	 * 去除重复元素，equqls方法和hashCode方法共同作用
	 */
	public boolean equals(Object obj){
		if(this==obj)  return true;
		if(!(obj instanceof Person)) return false;
		Person p=(Person)obj;
		if(this.name.equals(p.name)&&this.age==p.age){
			return true;
		}else{
			return false;
		}
	}
	public int hashCode(){
		return this.name.hashCode()*this.age;
	}
	
}
public class TreeSetDemo {
	public static void main(String[] args) {
		Set<Person> allSet=new HashSet<Person>();
		allSet.add(new Person("李四",30));
		allSet.add(new Person("张三",30));
		allSet.add(new Person("李四",30));
		allSet.add(new Person("李四",32));
		System.out.println(allSet);
	}
}