package com.funcy.current;

public class ThreadLocalTest {
	public String name;
	
	ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
		 @Override  
	        protected String initialValue() {  
	            return "初始线程";  
	        }  
	};
	
	public String getName(){
		return threadLocal.get();
	}
	public void setName(String name){
		threadLocal.set(this.getName() + name);
	}
	
	public static void main(String[] args) {
		ThreadLocalTest tL = new ThreadLocalTest();
		Runnable run = new Runnable(){
			@Override
			public void run(){
				for(int i = 0; i < 5; i++) {
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
