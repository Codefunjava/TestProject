package com.funcy.current;

public class ThreadLocalTest2 {
	public String name = "初始线程";
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name += name;
	}
	
	public static void main(String[] args) {
		ThreadLocalTest2 tL = new ThreadLocalTest2();
		Runnable run = new Runnable(){
			@Override
			public void run(){
				for(int i = 0; i < 2; i++) {
					tL.setName("-" + Thread.currentThread().getName());
					System.out.println("当前线程：" + Thread.currentThread().getName() + ", " + tL.getName());
				}
			}
		};
		Thread thread1 = new Thread(run);
		Thread thread2 = new Thread(run);
		Thread thread3 = new Thread(run);
		Thread thread4 = new Thread(run);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
	
}
