package com.fcy.test02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

class Singleton implements Serializable{
	private static Singleton instance;
	private String name;
	private Singleton(String name){
		System.out.println("调用有参数的构造器");
		this.name = name;
	}
	public static Singleton getInstance(String name){
		if(instance == null){
			instance = new Singleton(name);
		}
		return instance;
	}
	
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
}

public class Test13 {
	public static void main(String[] args) throws Exception {
		Singleton s = Singleton.getInstance("灰太狼");
		System.out.println("Wolf对象创建完成~");
		Singleton s2 = null;
		try(
			ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("b.bin"));
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("b.bin"));
		){
			oos.writeObject(s);
			oos.flush();
			s2 = (Singleton)ois.readObject();
			System.out.println(s==s2);
		}
		
	}
	
}
