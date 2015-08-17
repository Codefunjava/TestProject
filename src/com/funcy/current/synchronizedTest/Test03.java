package com.funcy.current.synchronizedTest;

public class Test03 implements Runnable { 
    public void run() { 
         synchronized(this) { 
              for (int i = 0; i < 5; i++) { 
                   System.out.println(Thread.currentThread().getName() + " synchronized loop " + i); 
              } 
         } 
    } 
    public static void main(String[] args) { 
    	Test03 t1 = new Test03(); 
         Thread ta = new Thread(t1, "A"); 
         Thread tb = new Thread(t1, "B"); 
         ta.start(); 
         tb.start(); 
    }
}