package com.funcy.current;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class ProductInfo {
	
}

class Preloader {
	
	private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo> (new Callable<ProductInfo>(){
		public ProductInfo call() throws Exception {
			return loadProdectInfo();
		}

		private ProductInfo loadProdectInfo() {
			// TODO Auto-generated method stub
			return null;
		}
	});
	
	private final Thread thread = new Thread (future);
	public void start() {
		thread.start();
	}
	
	public ProductInfo get() throws Exception {
		return future.get();
	}
}

public class FutureTaskTest {

}
