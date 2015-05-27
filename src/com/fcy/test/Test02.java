package com.fcy.test;
class Animal{
	private String desc;
	public Animal(){
		this.desc=getDesc();
	}
	public String getDesc(){
		return "Animal";
	}
	public String toString(){
		return desc;
	}
}

public class Test02 extends Animal{
	private String name;
	private double weight;
	public Test02(String name,double weight){
		this.name=name;
		this.weight=weight;
	}
	public String getDesc(){
		return "Wolf[name="+name+",weight="+weight+"]";
	}
	public static void main(String args[]){
		System.out.println(new Test02("»ÒÌ«àO",32.3));
	}
}
