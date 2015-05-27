package com.fcy.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
	public static void main(String[] args) {
		List<String> all=new ArrayList<String>();
		all.add("hello");
		all.add("_");
		all.add("world");
		for(String str:all){
			System.out.print(str);
		}
	}
}
