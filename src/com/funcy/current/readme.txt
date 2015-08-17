
--不安全的“先检查后执行”，代码形式如下：
	if(条件满足){   //这里容易出现线程安全问题
		//doSomething
	}else{
		//doOther
	}
	



1.线程池 --Executors的静态方法，请求时即响应，减少了线程的创建时间，提高了响应速度。
	newCachedThreadPool()：执行时，先查找线程池中是否有相同的线程，有则用线程池中的线程，否则创建一个新线程。线程执行完成后，
			  			   60s若再无其他操作，线程将会被终结。
	newFixedThreadPool(int nThreads)：创建指定数量的线程，执行时若线程池数量达到上线，程序将会等待其他线程执行完成再执行。		  
	
	newSingleThreadExecutor()：相当于线程数量为1的FixedThreadPool。
	
	newScheduledThreadPool()：创建一个固定长度的线程池，而且以延迟或定时的方式来执行任务，类似于Timer.
	
	DelayQueue：延时队列
	
    线程池创建示例：
	ExecutorService exec = Executors.newCachedThreadPool();
	exec.xxxXxxx();       //调用相关方法

2.从任务中产生返回值
	Runnable是执行工作的独立任务，不返回任何值。如果希任务完成时返回一个值，则可以实现Callable接口，
	覆盖call()方法，使用ExecutorService.submit()方法调用，submit()方法返回Future对象，示例如下:
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
      lock.unlock();  //一定要释放锁，一般使用try-finally释放 
    }  
    
4.容器遍历时，可以克隆一个副本，并在副本上进行遍历来解决线程不安全。
   如果直接在容器上加锁，当容器规模很大时，效率会很低。
   容器隐式遍历发生位置：hashCode和equals等方法会间接地执行迭代操作，当容器作为另一个元素或键值时，
  					  就会出现这种情况。同样，containsAll/removeAll和retainAll等方法，以及把容器
  					  作为参数的构造方法，都会对空串进行迭代。
  
5.使用java.util.concurrent包中的ConcurrentHashMap来代替Map
	  java.util.concurrent包中的CopyOnWriteArrayList代替以遍历为主的的List
	  java.util.concurrent包中的CopyOnWriteArraySet代替以遍历为主的的Set
	  java.util.concurrent包中的ConcurrentSkipListMap代替SortedMap
	  java.util.concurrent包中的ConcurrentSkipListSet代替SortedSet
	  
	  ConcurrentHasMap使用分段锁来进行线程访问控制，单线程环境下只损失非常小的性能。不会抛出ConcurrentModificationException
			非“及时失败”，并发环境下得到的size和isEmpty可能是过期的。

5.闭锁
	1) CountDownLatch
	2) FutureTask
	3) Semaphore-信号量
	4) 栅栏，闭锁用于等待事件，而栅栏用于等待其他线程。
	
6.Executor--线程任务的执行

7.Future表示一个任务的生命周期，并提供了相应的方法判断是否已经完成或取消，以及
  获取任务的结果和取消任务等。

8.锁
	1）自旋锁：为了让线程等待，可以让线程执行一个忙循环（自旋），这项技术就是所谓的自旋锁。
	







































