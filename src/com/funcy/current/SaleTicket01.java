package com.funcy.current;

public class SaleTicket01 extends Thread {
	private int ticket = 5;
	
	public void run() {
        for (int i = 0; i < 7; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+ "正在卖票: "+this.ticket--);
            }
        }
    }
 
    public static void main(String[] args) {
    	SaleTicket01 h1 = new SaleTicket01();
    	SaleTicket01 h2 = new SaleTicket01();
    	SaleTicket01 h3 = new SaleTicket01();
        h1.start();
        h2.start();
        h3.start();
    }
 
}
