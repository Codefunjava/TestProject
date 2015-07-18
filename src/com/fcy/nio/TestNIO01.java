package com.fcy.nio;

import java.nio.IntBuffer;

public class TestNIO01 {
	public static void main(String[] args) {
		IntBuffer buf = IntBuffer.allocate(10);
		System.out.println("1.写入数据之前的position、limit和capacity: ");
		System.out.println("position = " + buf.position() + ", limit = " + buf.limit() 
				+ ",capacity = " + buf.capacity());
		int temp[] = {5, 7, 9};
		buf.put(3);
		buf.put(temp);
		System.out.println("2.写入数据之后的position、limit和capacity: ");
		System.out.println("position = " + buf.position() + ", limit = " + buf.limit() 
				+ ", capacity = " + buf.capacity());
		buf.flip();
		System.out.println("3.准备输出数据时的position、limit和capacity: ");
		System.out.println("positon = " + buf.position() + ", limit = " 
		+ buf.limit() + ",capacity = " + buf.capacity());
		System.out.println("缓冲区中的内容：");
		while(buf.hasRemaining()){
			int x= buf.get();
			System.out.print(x + "、");
		}
		System.out.println("\n===================================");
		int pos = buf.limit();
		buf.limit(10);
		buf.position(pos);
		buf.put(29);
		buf.slice();
		System.out.println("缓冲区中的内容：");
		while(buf.hasRemaining()){
			int x= buf.get();
			System.out.print(x + "、");
		}
		
	}
}

















