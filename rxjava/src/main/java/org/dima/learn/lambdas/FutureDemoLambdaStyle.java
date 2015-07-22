package org.dima.learn.lambdas;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.IntStream;

public class FutureDemoLambdaStyle {

	public static void main(String[] args) throws Exception {
		Random r = new Random();

		ExecutorService service = Executors.newFixedThreadPool(5);

		Function<String, Callable<String>> call = s -> () -> {
			int sleep = r.nextInt(4000);
			System.out.println("In Task sleeping: " + sleep);
			Thread.sleep(sleep);
			String th = Thread.currentThread().getName();
			return s + "_" + th;
		};

		IntStream
				.range(0, 5)
				// create MyTask, and submit it to execution
				.mapToObj(i -> service.submit(call.apply("Task-" + i)))
				.map(future -> {
					try {
						// get task execution result from future object
						return future.get();
					} catch (Exception ex) {
						throw new RuntimeException(
								"Exeption getting Future result");
					}
				})
				// process task execution result
				.forEach(System.out::println);

		service.shutdown();
	}
	
}