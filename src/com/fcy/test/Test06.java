package com.fcy.test;

import java.util.ArrayList;
import java.util.Iterator;

public class Test06 {
//	public static void main(String[] args) {
//		TreeSet<String> set=new TreeSet<String>();
//		set.add("111");
//		set.add("222");
//		set.add("333");
//		for(Iterator<String> it=set.iterator();it.hasNext();){
//			String ele=it.next();
//			System.out.print(ele+" ");
//			/**
//			* ע�⣺ɾ����Ԫ��Ϊ�����е����ڶ������������ConcurrentModificationException�쳣
//			*/
//			if(ele.equals("333")){
//				set.remove(ele);
//			}
//		}
//	}
	
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("111");
		list.add("222");
		list.add("333");
		for(Iterator<String> it=list.iterator();it.hasNext();){
			String ele=it.next();
			System.out.print(ele+" ");
			/**
			 * ע�⣺ɾ����Ԫ��Ϊ�����е����ڶ������������ConcurrentModificationException�쳣
			 */
			if(ele.equals("222")){
				list.remove(ele);
			}
		}
	}
	
}
