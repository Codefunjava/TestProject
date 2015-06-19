package com.funcy.current.runnableTest;

public class DaemonDemo implements Runnable {
	public void run(){
		try{
			System.out.println("start DaemonDemo");
			Thread.sleep(10);
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			System.out.println("this should always run ?");
		}
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new DaemonDemo());
		t.setDaemon(true);
		t.start();
	}
	
}
