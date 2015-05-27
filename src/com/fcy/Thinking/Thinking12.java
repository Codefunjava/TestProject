package com.fcy.Thinking;

interface Anim{
	public void fun();
}

class Cat implements Anim{
	public void fun(){
		System.out.println("cat cat cat");
	}
}

class Dog implements Anim{
	public void fun(){
		System.out.println("dog dog dog");
	}
}

public class Thinking12 {
	public static void main(String[] args) {
		Anim animal = new Cat();
		animal.fun();
		Dog d = (Dog) animal;
		d.fun();
	}
}
