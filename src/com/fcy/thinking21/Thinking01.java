package com.fcy.thinking21;

public class Thinking01 implements Runnable{
	protected int countDown = 10;
	private static int taskCount  = 0 ;
	private final int id = taskCount++;
	public Thinking01(){}
	public Thinking01(int countDown){
		this.countDown = countDown;
	}
	public String status(){
		return "#"+id+"("+(countDown > 0 ? countDown : "LiftOff!")+"), ";
	}
	public void run(){
		while(countDown-- >0){
			System.out.println(status());
			Thread.yield();
		}
	}
	
	public static void main(String[] args) {
		new Thread(new Thinking01()).start();
		new Thread(new Thinking01()).start();
		new Thread(new Thinking01()).start();
		new Thread(new Thinking01()).start();
		new Thread(new Thinking01()).start();
		System.out.println("Waiting for LiftOff!");
	}
}
