package com.fcy.Thinking;

import java.util.Random;

class Initable{
	static final int staticFinal = 47;		//编译期常量
	static final int staticFinal2 = Thinking08.rand.nextInt(1000);
	static{
		System.out.println("Initialiaing Initable");
	}
}

class Initable2{
	static int staticNonFinal = 147;
	static {
		System.out.println("Initalizing Initable2");
	}
}

class Initable3{
	static int staticNonFinal = 74;
	static {
		System.out.println("Initalizing Initable3");
	}
}

public class Thinking08 {
	public static Random rand = new Random(47);
	public static void main(String args[]) throws ClassNotFoundException{
		//.class生成的Class对象不会进行初始化
		Class initable = Initable.class;  
		System.out.println("After creating Initable ref");
		//访问“编译期常量”不会进行初始化
		System.out.println(Initable.staticFinal);
		//虽然staticFinal2是final和static型的，但值编译期不确定，故也会进行初始化
		System.out.println(Initable.staticFinal2);
		System.out.println(Initable2.staticNonFinal);
		//使用Class.forName()生成Class对象会进行初始化
		Class initable3=Class.forName("com.fcy.Thinking.Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}
}
