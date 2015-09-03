package com.funcy.current;


/**
 * synchronized加锁
 * @author Administrator
 *
 */
public class SaleTicket02 implements Runnable {
	private int ticket = 5;
	
	@Override
	public void run() {
        for (int i = 0; i < 100; i++) {
        	synchronized(this){
        		if (ticket > 0) {
        			try {
        				Thread.sleep(1000);
        			} catch (InterruptedException e) {
        				e.printStackTrace();
        			}
        			System.out.println(Thread.currentThread().getName()+ "正在卖票，当前票数： "+ ticket--);
        		}else{
        			System.out.println("票数不足，当前票数：" + ticket);
        		}
        	}
        }
    }
 
    public static void main(String[] args) {
    	SaleTicket02 my = new SaleTicket02();
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
