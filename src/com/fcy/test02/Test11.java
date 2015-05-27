package com.fcy.test02;

import java.util.Date;

@SuppressWarnings("serial")
public class Test11 extends Date{
	public static void main(String[] args) {
		new Test11().test();
 	}
	public void test(){
		System.out.println(super.getClass().getName());
	}
}
