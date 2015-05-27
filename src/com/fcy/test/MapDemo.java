package com.fcy.test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class MapDemo {
	public static void main(String[] args) {
		String str=new String("���java����");
		ReferenceQueue<String> rq= new ReferenceQueue<String>();
		PhantomReference<String> pr=new PhantomReference<String>(str,rq);
		str=null;
		System.out.println(rq.poll()==pr);//�������õĶ��󱻻��պ������ý����뵽���ö�����
		System.out.println(pr.get());//�������޷�������ö��󣬴˴����null
		System.gc();
		System.runFinalization();
		System.out.println(rq.poll()==pr);//�������õĶ��󱻻��պ������ý����뵽���ö�����
	}
}
