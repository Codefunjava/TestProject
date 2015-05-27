package com.bjsxt.reflect;
/**
 * 获取结构信息Class对象(源头)
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ClassNotFoundException {
		String  str ="abc";
		//Class对象
		//对象.getClass()
		Class<?> clz =str.getClass();
		//类.class
		clz =String.class;
		//完整路径
		clz=Class.forName("java.lang.String");
		
	}
}
