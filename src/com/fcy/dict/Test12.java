package com.fcy.dict;

import java.math.BigInteger;

public class Test12 {
	public static void main(String[] args) {
		//构造，创建BigInteger对象
		BigInteger one=new BigInteger("1");
		BigInteger two=new BigInteger("2");
		BigInteger three=new BigInteger("3");
		BigInteger sum=new BigInteger("0");
		//以下方式得到的结果为0
		sum.add(one);
		sum.add(two);
		sum.add(three);
		//这样才能得到6
//		sum=sum.add(one);
//		sum=sum.add(two);
//		sum=sum.add(three);
		System.out.println(sum.toString());
	}
}
