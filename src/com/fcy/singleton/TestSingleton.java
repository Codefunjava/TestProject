package com.fcy.singleton;

public class TestSingleton {
	public static void main(String[] args) throws CloneNotSupportedException {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = (Singleton) s1.clone();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
	}
}
