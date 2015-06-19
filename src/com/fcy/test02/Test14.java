package com.fcy.test02;


public class Test14 {
	@SuppressWarnings("finally")
	public static void main(String[] args) {
		try{
			int a = 20/0;
		}finally{
			System.out.println("finally块被执行");
			return;
		}
	}
	
}
