package com.dima.aop;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.DisposableBean;

public class AsyncExecutor implements DisposableBean {
	
	private static final boolean IS_FIFO_QUEUE = true;
	private static final int THREADS_NUMBER_IN_POOL = 3;
	private static final int MAX_THREADS_NUMBER_IN_POOL = 10;
	private static final long THREAD_TIME_TO_LIVE = 60L;
	private static final int NUMBER_TASK_REJECTED = 10;	
	
	static final private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10, IS_FIFO_QUEUE);	
	static final private ThreadPoolExecutor executor = new ThreadPoolExecutor(
			THREADS_NUMBER_IN_POOL,
			MAX_THREADS_NUMBER_IN_POOL,
			THREAD_TIME_TO_LIVE,
			TimeUnit.SECONDS, queue);
		
	public static void executeAsync(Task t){
		int rejected = 0;
		boolean isTaskAccepted = false;		
		while(!isTaskAccepted && rejected <= NUMBER_TASK_REJECTED ){
			try {
				// offers a task to FIFO queue to be executed at some time in future				
				executor.execute(t);
				isTaskAccepted = true;
			} catch (RejectedExecutionException e) {				
				rejected++;
				System.out.println("Task was rejected: " + rejected + " times");
			}
		}
	}		
		
	class Task implements Runnable{			
		private AspectEngine engine;
		private ProceedingJoinPoint jp;
		
		Task(AspectEngine engine, ProceedingJoinPoint jp){
			this.engine = engine;
			this.jp = jp;
		}
		
		public void run() {
			System.out.println("IN RUNABLE");
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			try {
				engine.executePsp(jp);
			} catch (Throwable e) {
				System.out.println("IN EXCEPTION");				
			}						
		}		
	}

	public void destroy() throws Exception {
		executor.shutdown();		
	}	

}
