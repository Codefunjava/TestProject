package com.fcy.test03;

public class Test05 {
	
	public static void main(String[] args) {
		B b1 = new B();
		b1.setA(45);
		System.out.println(b1.getA());
	}
	
	
}


class A {
	
	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
}

class B extends A {
	
	private int b;

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
}
