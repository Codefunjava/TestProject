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
		return "������"+this.name+";���䣺"+this.age;
	}
	/**
	 * ȥ���ظ�Ԫ�أ�equqls������hashCode������ͬ����
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
		allSet.add(new Person("����",30));
		allSet.add(new Person("����",30));
		allSet.add(new Person("����",30));
		allSet.add(new Person("����",32));
		System.out.println(allSet);
	}
}