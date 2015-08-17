package com.funcy.current.synchronizedTest;

class SynchronizedTestA {
	public synchronized void fun() {
		SynchronizedTestB b = new SynchronizedTestB();
		System.out.println("this is method synchronizedTestA.fun");
		b.fun();
	}
}

class SynchronizedTestB {
	public synchronized void fun() {
		System.out.println("this is method synchronizedTestB.fun");
	}
}

public class Test01 {
	public static void main(String[] args) {
		SynchronizedTestA a = new SynchronizedTestA();
		a.fun();
	}
	
}
