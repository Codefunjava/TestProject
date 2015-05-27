package com.fcy.Thinking;

class AB{
	int i=3;
	public AB(){
		this.print();
	}
	public void print(){
		System.out.println(i);
	}
}

public class Thinking03 extends AB{
	int i=10;
	public Thinking03(){
		//this.print();
	}
	public void print(){
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		new Thinking03();
	}
}
