package com.fcy.thinking21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thinking02 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0;i < 5 ; i++){
			exec.execute(new Thinking01());
			//exec.shutdown();
		}
	}
}
