package com.funcy.current;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;


public class TimingThreadPool extends ThreadPoolExecutor {
	private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	private final Logger log = Logger.getLogger(TimingThreadPool.class);
	private final AtomicLong numTasks = new AtomicLong();
	private final AtomicLong totalTime = new AtomicLong();
	
	public TimingThreadPool() {
        super(1, 1, 0L, TimeUnit.SECONDS, null);
    }
	
	protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        log.info(String.format("Thread %s: start %s", t, r));
        startTime.set(System.nanoTime());
    }

    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long endTime = System.nanoTime();
            long taskTime = endTime - startTime.get();
            numTasks.incrementAndGet();
            totalTime.addAndGet(taskTime);
            log.info(String.format("Thread %s: end %s, time=%dns",
                    t, r, taskTime));
        } finally {
            super.afterExecute(r, t);
        }
    }
	
	protected void terminated() {
		try {
			log.info(String.format("Terminated: avg time = %dns", totalTime.get() / numTasks.get()));
		}finally{
			super.terminated();
		}
	}
	
}













