package com.fcy.test;

public class ThreadDemo implements Runnable{
	boolean flag=true;
	public synchronized void  test01(){
		System.out.println("����һ����Ʒ��");
	}
	public synchronized void  test02(){
		System.out.println("����һ����Ʒ��");
	}
	public void run(){
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag){
				test01();
				flag=false;
			}else{
				test02();
				flag=true;
			}
		}
	}
	
	public static void main(String args[]){
		new Thread(new ThreadDemo()).start();
	}

}
