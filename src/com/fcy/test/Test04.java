package com.fcy.test;

class Test04A{
	static final int MAXIMUM_CAPACITY = 1 << 30;
	public int a=3;
	public void display(){
		System.out.println("Test04A!");
	}
}

class Test04B extends Test04A{
	public int a=5;
	public void display(){
		System.out.println("Test04B!");
	}
}

public class Test04{
	public static void main(String[] args) {
		Test04A t= new Test04B();
		System.out.println(t.a);
		t.display();
	}
}
