package com.fcy.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Apple{
	double weight;
	public Apple(double weight){
		this.weight=weight;
	}
}

public class Test05 {
	public static void main(String[] args) {
		Apple t1=new Apple(2.2);
		Apple t2=new Apple(1.8);
		List<Apple> list=new ArrayList<Apple>(4);
		list.add(t1);
		list.add(t2);
		System.out.println(list.get(0)==t1);
		System.out.println(list.get(1)==t2);
		
		Set<Apple> s=new HashSet<Apple>();
		s.add(new Apple(2.2));
		System.out.println(s.contains(new Apple(2.2)));
		System.out.println(new Apple(2.2).hashCode());
		System.out.println(new Apple(2.2).hashCode());
		System.out.println(s);
		
	}
	
}
