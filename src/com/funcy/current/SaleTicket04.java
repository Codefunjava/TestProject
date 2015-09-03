package com.funcy.current;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * synchronized错误的加锁方式
 * @author Administrator
 *
 */
public class SaleTicket04 implements Runnable {
	
	@Override
	public void run() {
		AtomicInteger ticket = new AtomicInteger(5);
        for (int i = 0; i < 100; i++) {
	        boolean flag = false;
			synchronized(this) {
				flag = ticket.get() > 0;
			}
			if (flag) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+ "正在卖票，当前票数： "+ ticket.getAndDecrement());
			}else{
				System.out.println("票数不足，当前票数：" + ticket);
			}
        }
		
    }
 
    public static void main(String[] args) {
    	
    	SaleTicket04 my = new SaleTicket04();
        new Thread(my, "1号窗口").start();
        new Thread(my, "2号窗口").start();
        new Thread(my, "3号窗口").start();
        new Thread(my, "4号窗口").start();
        new Thread(my, "5号窗口").start();
        new Thread(my, "6号窗口").start();
        new Thread(my, "7号窗口").start();
        new Thread(my, "8号窗口").start();
        new Thread(my, "9号窗口").start();
        new Thread(my, "10号窗口").start();
        new Thread(my, "11号窗口").start();
        new Thread(my, "12号窗口").start();
    }
 
}
