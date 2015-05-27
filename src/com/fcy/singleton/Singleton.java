package com.fcy.singleton;

public class Singleton implements Cloneable{
	private static Singleton instance = new Singleton();
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		return instance;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
