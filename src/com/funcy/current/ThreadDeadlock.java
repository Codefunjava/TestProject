package com.funcy.current;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDeadlock {
	ExecutorService exec = Executors.newSingleThreadExecutor();
	
	public class RenderPageTask implements Callable<String> {
		public String call() throws Exception {
			Future<String> header, footer;
			header = exec.submit(new LoadFileTask("header.html"));
			footer = exec.submit(new LoadFileTask("footer.html"));
			String page = renderBody();
			return header.get() + page + footer.get();
			
		}
		
		private String renderBody() {
            // Here's where we would actually render the page
            return " page ";
        }
	}
	
	public class LoadFileTask implements Callable<String> {
		
		private String str;
		
		public LoadFileTask(String str){
			this.str = str;
		}
		
		@Override
		public String call() throws Exception {
			return str == null ? "" : str;
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec2 = Executors.newSingleThreadExecutor();
		Future<String> str = exec2.submit(new ThreadDeadlock().new RenderPageTask());
		System.out.println(str.get());
	}
}
