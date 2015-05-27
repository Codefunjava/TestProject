package com.fcy.test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class MapDemo {
	public static void main(String[] args) {
		String str=new String("疯狂java讲义");
		ReferenceQueue<String> rq= new ReferenceQueue<String>();
		PhantomReference<String> pr=new PhantomReference<String>(str,rq);
		str=null;
		System.out.println(rq.poll()==pr);//被虚引用的对象被回收后，虚引用将加入到引用队列中
		System.out.println(pr.get());//虚引用无法获得引用对象，此处输出null
		System.gc();
		System.runFinalization();
		System.out.println(rq.poll()==pr);//被虚引用的对象被回收后，虚引用将加入到引用队列中
	}
}
