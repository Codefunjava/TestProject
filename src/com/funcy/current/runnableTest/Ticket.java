package com.funcy.current.runnableTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Ticket implements Runnable {
	
	private int count;
	private Lock lock = new ReentrantLock();
	
	public Ticket() {}
	
	public Ticket(int count) {
		this.count = count;
	}
	
	public int sale(){
		lock.lock();
		if(count > 0){
			count--;
			System.out.println(Thread.currentThread().getName() + "售票成功，当前剩余票数：" + count);
		}else{
			System.out.println(Thread.currentThread().getName() + "票数不足，当前剩余票数：" + count);
		}
		lock.unlock();
		return count;
	}
	
	public void run(){
		sale();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Ticket ticket = new Ticket(5);
		for(int i = 0; i < 10; i++){
			new Thread(ticket).start();
		}
		
	}
	
	
}
