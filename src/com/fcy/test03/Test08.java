package com.fcy.test03;

/**
 * enumTest
 * @author Administrator
 *
 */

public class Test08 {
	public static void main(String[] args) {
		String str1 = EnumTest.ONE.behavior("傳參1");
		String str2 = EnumTest.TWO.behavior("傳參2");
		System.out.println("str1 === " + str1);
		System.out.println("str2 === " + str2);
	}
}

enum EnumTest {
	
	ONE(1, one()){
		@Override
		String behavior(String str) {
			System.out.println(str);
			System.out.println("behavior1");
			return "behavior1";
		}
		
	},
	TWO(2, two()){
		@Override
		String behavior(String str) {
			System.out.println(str);
			System.out.println("behavior2");
			return "behavior2";
		}
	};
	
	abstract String behavior(String str);
	
	private int retMethod;
	private int number;
	
	private EnumTest(int number, int retMethod) {
		this.number = number;
		this.retMethod = retMethod;
	}
	
	private static int one(){
		return 1;
	}
	
	private static int two(){
		return 2;
	}
	
	public int getRetMethod(){
		return retMethod;
	}
	
	public int getNumber(){
		return number;
	}
	
}
