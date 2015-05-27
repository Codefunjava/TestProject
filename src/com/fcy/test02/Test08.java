package com.fcy.test02;

class Value{
	public int i=15;
}

public class Test08 {
	public static void main(String args[]){
		Test08 t=new Test08();
		t.first();
	}
	public void first(){
		int i=5;
		Value v=new Value();
		v.i=25;
		//将v的地址值传入second方法
		second(v,i);
		System.out.println(v.i);
	}
	
	public void second(Value v,int i){
		i=0;
		v.i=20;
		Value val=new Value();
		//此时v的地址值为val的地址值
		v=val;
		System.out.println(v.i+" "+i);	
	}
}
//运行结果:15 0 20


