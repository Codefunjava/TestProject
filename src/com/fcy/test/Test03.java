package com.fcy.test;

class Animal1{
	public void say(){
		System.out.println("�����");
	}
}

class Cat extends Animal1{
	public void say(){
		System.out.println("Сè��");
	}
}

class Dog extends Animal1{
	public void say(){
		System.out.println("С����");
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
