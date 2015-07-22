package org.dima.learn.lambdas;


import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

	Random ran = new Random();

	public static void main(String[] args) throws Exception {

		FutureDemo demo = new FutureDemo();

		ExecutorService service = Executors.newFixedThreadPool(5);

		for (int j = 0; j < 5; j++) {
			Callable<String> call = demo.new MyTask("Task-" + j);
			Future<String> submit = service.submit(call);
			System.out.println(submit.get());
		}
		service.shutdown();
	}

	private class MyTask implements Callable<String> {
		private final String taskId;

		public MyTask(String taskId) {
			this.taskId = taskId;
		}

		@Override
		public String call() throws Exception {
			int sleep = ran.nextInt(4000);
			System.out.println("In Task " + taskId + " sleeping: " + sleep);
			Thread.sleep(sleep);
			String th = Thread.currentThread().getName();
			return taskId + "_" + th;
		}
	}

}
