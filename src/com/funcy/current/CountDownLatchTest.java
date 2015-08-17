package com.funcy.current;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static long timeTasks(int nThreads, final Runnable task) throws Exception {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		for(int i = 0; i < nThreads; i++) {
			Thread t = new Thread() {
				public void run() {
					try{
						startGate.await();
						try{
							task.run();
						}finally{
							endGate.countDown();
						}
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			t.start();
		}
		long start = System.nanoTime();
		startGate.countDown();
		System.out.println("此处会阻塞");
		endGate.await();
		long end = System.nanoTime();
		return end - start;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("运行耗时：" + timeTasks(5, new Runnable() {
			@Override
			public void run() {
				System.out.println("当前线程：" + Thread.currentThread().getName());
			}
		}));
	}
}
