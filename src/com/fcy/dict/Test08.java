package com.fcy.dict;

class X{
	Y b=new Y();
	X(){
		System.out.println("X");
	}
}

class Y{
	Y(){
		System.out.println("Y");
	}
}

public class Test08 extends X{
	Y y=new Y();
	Test08(){
		System.out.println("Z");
	}
	public static void main(String[] args){
		new Test08();
	}
}
