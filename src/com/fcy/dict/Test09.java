package com.fcy.dict;
//继承中，有方法覆盖时，都是默认从当前类的方法找起
//如果当前类中无此方法，才去调用父类的方法
class Base{
	int i;
	Base(){
		//子类执行add(1)时，会先去找当前类(MyBase)中是否有add(int)方法
		//若有，则调用此方法，否则调用父类的方法
		add(1); //此时调用的子类MyBase中的add(int)方法
		System.out.println("Base构造 "+i);
	}
	void add(int v){
		i+=v;
		System.out.println("Base add "+i);
	}
}

class MyBase extends Base{
	MyBase(){
		//执行add(2)前会默认执行this();
		add(2);
	}
	void add(int v){
		i+=v*2;
		System.out.println("MyBase() add "+i);
	}
}

public class Test09 {
	public static void main(String[] args) {
		go(new MyBase());
	}
	static void go(Base b){
		b.add(8);
	}
}
