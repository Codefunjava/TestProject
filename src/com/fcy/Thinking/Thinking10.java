package com.fcy.Thinking;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Exam{
	private String field1="私有属性";
	public String field2="公有属性";
	public void fun1(){
		System.out.println("fun1:这是一个public访问权限方法");
	}
	
	private void fun2(){
		System.out.println("fun2:这是一个private访问权限方法");
	}
	
	private void fun3(String arg){
		System.out.println("fun3:这是一个private访问权限且带参数的方法，参数为："+arg);
	}
	
}

public class Thinking10 {
	public static void main(String args[]){
		Exam e=new Exam();
		Field field1;
		Field field2;
		Field field[] = e.getClass().getFields();
		for(Field f : field){
			System.out.println(f);
		}
		try {
			field1 = e.getClass().getDeclaredField("field1");
			field2 = e.getClass().getDeclaredField("field2");
			field1.setAccessible(true);
			System.out.println("field1: "+field1.get(e));
			field1.set(e,"重新设置一个field1值");
			System.out.println("field1: "+field1.get(e));
			System.out.println("field2: "+field2.get(e));
			field2.set(e,"重新设置一个field2值");
			System.out.println("field2: "+field2.get(e));
		} catch (NoSuchFieldException e1) {
			e1.printStackTrace();
		}catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		Method[] method = e.getClass().getMethods();
		for(Method m : method){
			System.out.println(m);
		}
		
		try {
			
			Method method1 = e.getClass().getDeclaredMethod("fun1");
			method1.invoke(e);
			
			Method method2 = e.getClass().getDeclaredMethod("fun2");
			method2.setAccessible(true);
			method2.invoke(e);
			
			Method method3 = e.getClass().getDeclaredMethod("fun3",String.class);
			method3.setAccessible(true);
			method3.invoke(e,"fun3的参数");
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
