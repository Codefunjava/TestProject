package com.jvmTest;

public class TestOrder {
	public int calc(){
		int a = 100;
		int b = 200;
		int c = 300;
		return (a + b) * c;
	}
	
	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		int tt = 3;
		long ll = 3L;
		System.out.println(c == d);
		System.out.println(e == f);
		System.out.println(c == (a + b));
		System.out.println(c.equals(a + b));
		System.out.println(g == (a + b));
		System.out.println(g.equals(a + b));
		System.out.println(ll == tt);
	}
	
	
}
