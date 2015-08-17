package com.funcy.current;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

import org.apache.poi.ss.formula.functions.T;

public class SemaphoreTest {
	private final Set<T> set;
	private final Semaphore sem;
	
	public SemaphoreTest(int bound) {
		this.set = Collections.synchronizedSet(new HashSet<T>());
		sem = new Semaphore(bound);
	}
	
	public boolean add(T o) throws Exception{
		sem.acquire();
		boolean wasAdded = false;
		try {
			wasAdded = set.add(o);
			return wasAdded;
		} finally {
			if(!wasAdded) {
				sem.release();
			}
		}
	}
	
	public boolean remvoe(Object o) {
		boolean wasRemove = set.remove(o);
		if(wasRemove){
			sem.release();
		}
		return wasRemove;
	}
	
}













