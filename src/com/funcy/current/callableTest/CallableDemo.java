package com.funcy.current.callableTest;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/**
 * Callable接口在任务完成时能够返回一个值。
 * 实现Callable接口，并实现call()方法
 * 调用时，使用ExecutorService.submit()方法调用
 * 
 */
class TaskWithResult implements Callable<String> {
	private int id;
	public TaskWithResult(int id){
		this.id = id;
	}
	public String call() {
		return "result of TaskWithResult：" + id;
	}
}

public class CallableDemo {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>> ();
		for(int i = 0; i < 10; i++){
			results.add(exec.submit(new TaskWithResult(i)));
		}
		TimeUnit.MILLISECONDS.sleep(1000);
		for(Future<String> fs : results) {
			try{
				System.out.println(fs.get());
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				exec.shutdown();
			}
		}
	}
	
}
