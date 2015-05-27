package com.fcy.test;

class Animal1{
	public void say(){
		System.out.println("动物叫");
	}
}

class Cat extends Animal1{
	public void say(){
		System.out.println("小猫叫");
	}
}

class Dog extends Animal1{
	public void say(){
		System.out.println("小狗叫");
	}
}

public class Test03 {
	public static void main(String args[]){
		Animal1 a=new Cat();
		a.say();
		Dog d=(Dog)a;
		d.say();
	}
}
