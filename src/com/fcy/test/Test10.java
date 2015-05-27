package com.fcy.test;
public class Test10 {
	public static void main(String[] args) {
		new Test10().test();
	}
	
	private void test(){
		System.out.println(new Inner());
		try {
			System.out.println(Inner.class.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	public class Inner{
		public String toString(){
			return "Inner∂‘œÛ";
		}
	}
}
