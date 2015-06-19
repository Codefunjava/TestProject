1.线程池 --Executors的静态方法
	newCachedThreadPool()：执行时，先查找线程池中是否有相同的线程，有则用线程池中的线程，否则创建一个新线程。线程执行完成后，
			  			   60s若再无其他操作，线程将会被终结。
	newFixedThreadPool(int nThreads)：创建指定数量的线程，执行时若线程池数量达到上线，程序将会等待其他线程执行完成再执行。		  
	
	newSingleThreadExecutor()：相当于线程数量为1的FixedThreadPool。
	
    线程池创建示例：
	ExecutorService exec = Executors.newCachedThreadPool();
	exec.xxxXxxx();       //调用相关方法

2.从任务中产生返回值
	Runnable是执行工作的独立任务，不返回任何值。如果希任务完成时返回一个值，则可以实现Callable接口，覆盖call()方法，使用
  	ExecutorService.submit()方法调用，submit()方法返回Future对象，示例如下:
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
		public static void main(String[] args) {
			ExecutorService exec = Executors.newCachedThreadPool();
			ArrayList<Future<String>> results = new ArrayList<Future<String>> ();
			for(int i = 0; i < 10; i++){
				results.add(exec.submit(new TaskWithResult(i)));
			}
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
	
3.解决共享资源竞争——给代码加锁
	必须在finally代码块中释放锁
	Lock lock = new ReentrantLock();  
    lock.lock();  
    try {   
      // update object state  
    }finally {  
      lock.unlock();   
    }  











































