package com.funcy.current.synchronizedTest;

class Test02A {
	public void funA() {
		synchronized(this){
			
			System.out.println(Thread.currentThread().getName() + "synchronizedTestB.funA 开始运行");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "synchronizedTestB.funA 运行结束");
		}
	}
	public void funB() {
		synchronized(this){
			System.out.println(Thread.currentThread().getName() + "synchronizedTestB.funB 开始运行");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "synchronizedTestB.funB 运行结束");
		}
	}
	public synchronized void funC() {
		System.out.println(Thread.currentThread().getName() + "synchronizedTestB.funC 开始运行");
		System.out.println(Thread.currentThread().getName() + "synchronizedTestB.funC 运行结束");
	}
}

public class Test02 {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++){
					Test02A a = new Test02A();
					a.funA();
					if(i == 5){
						System.out.println(Thread.currentThread().getName() + "休眠");
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++){
					Test02A a = new Test02A();
					a.funB();
					if(i == 5){
						System.out.println(Thread.currentThread().getName() + "休眠");
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
	}
}
