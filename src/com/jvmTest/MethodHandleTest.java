package com.jvmTest;

import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

public class MethodHandleTest {

	static class ClassA {
		public void println(String s) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) throws Throwable {
		Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
		getPrintMH(obj).invokeExact("icyfenix");
	}
	
	private static MethodHandle getPrintMH(Object reveiver) throws Throwable {
		MethodType mt = MethodType.methodType(void.class, String.class);
		return lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);
	}
	
}





















