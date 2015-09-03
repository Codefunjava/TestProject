package com.funcy.current;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest2 {
	public static long timeTasks(int nThreads, final Runnable task) throws Exception {
		final CountDownLatch startGate = new CountDownLatch(3);
		for(int i = 0; i < nThreads; i++){
			new Thread(new Runnable(){
				public void run(){
					startGate.countDown();
					task.run();
				}
			}).start();
		}
		System.out.println("不知道会发生什么");
		startGate.countDown();
		startGate.await();
		//startGate.countDown();
		System.out.println("应该会阻塞");
		System.out.println("这里会结束");
		return 0L;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("运行耗时：" + timeTasks(2, new Runnable() {
			@Override
			public void run() {
				System.out.println("当前线程：" + Thread.currentThread().getName());
			}
		}));
	}
}
