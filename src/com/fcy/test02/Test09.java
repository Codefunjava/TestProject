package com.fcy.test02;

public class Test09 {
	public static void main(String[] args) {
		int tmp=1;
		int value=1023;
		int i=0;
		while(tmp<value){
			tmp<<=1;
			i++;
		}
		if(tmp>value){
			System.out.println(value+"不是2的n次幂  "+tmp);
		}
		if(tmp==value){
			System.out.println(value+"是2的"+i+"次幂");
		}
	}
}
