package com.funcy.current;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 使用Lock加锁
 * @author Administrator
 *
 */
public class SaleTicket03 implements Runnable {
	
	private int ticket = 5;
	private Lock lock = new ReentrantLock();
	
	@Override
	public void run() {
        for (int i = 0; i < 100; i++) {
        	//lock.lock();
        	boolean flag = false;
        	try {
				flag = lock.tryLock(800, TimeUnit.MILLISECONDS);
				
        		if (ticket > 0 && flag) {
        			try {
        				Thread.sleep(1000);
        			} catch (InterruptedException e) {
        				e.printStackTrace();
        			}
        			System.out.println(Thread.currentThread().getName()+ "正在卖票，当前票数： "+ ticket--);
        		}else{
        			System.out.println("票数不足，当前票数：" + ticket);
        		}
        	}catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				if(flag){
					lock.unlock();
				}
        	}
        }
    }
 
    public static void main(String[] args) {
    	SaleTicket03 my = new SaleTicket03();
        new Thread(my, "1号窗口").start();
        new Thread(my, "2号窗口").start();
        new Thread(my, "3号窗口").start();
        new Thread(my, "4号窗口").start();
        new Thread(my, "5号窗口").start();
        new Thread(my, "6号窗口").start();
        new Thread(my, "7号窗口").start();
        new Thread(my, "8号窗口").start();
        new Thread(my, "9号窗口").start();
    }
 
}
