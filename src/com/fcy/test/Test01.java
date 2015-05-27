package com.fcy.test;

class Base{
	private int i=2;
	public Base(){
		System.out.println("Base"+this.getClass());
		this.display();
	}
	public void display(){
		System.out.println("Base-display()");
		System.out.println(i);
	}
}

class Deriverd extends Base{
	private int i=22;
	public Deriverd(){
		i=222;
	}
	public void display(){
		System.out.println("Dervierd-display()");
		System.out.println(i);
	}
}

public class Test01{
	
	public static void change(String str){
		str="22";
	}
	
	public static void main(String[] args) {
		new Deriverd();
		String a="11";
		change(a);
		System.out.println(a);
	}
}
