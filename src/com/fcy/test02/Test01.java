package com.fcy.test02;

class SingleTonX{
	private SingleTonX(){}
	public static SingleTonX instance=new SingleTonX();
	public static SingleTonX getInstance(){
		return instance;
	}
	public void print(){
		System.out.println(this.hashCode());
	}
	
}

public class Test01 {
	public static void main(String[] args) {
		SingleTonX.getInstance().print();
		SingleTonX.getInstance().print();
		SingleTonX.getInstance().print();
	}
}
