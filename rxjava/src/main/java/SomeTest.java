
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class SomeTest {
	 
	
	public static void main(String[] args) throws Exception {
		
		CountDownLatch latch = new CountDownLatch(1);
		
		BatchGenerator<Integer> olist = new BatchGenerator<>(latch);

	        olist.getObservable()
	        	.doOnCompleted(() -> {
	        		System.out.println("DONE");
	        		latch.countDown();
	        	})
	        	.observeOn(Schedulers.computation())
	        	.subscribe(e -> {
	        		try {
						Thread.sleep(1000);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		System.out.println("Element: " + e + " Tread: " + Thread.currentThread().getName());
	        	});

	        olist.add(1);	        
	        olist.add(2);	        
	        olist.add(3);
	        olist.add(4);
	        olist.add(5);
	        
	        Thread.sleep(1200);
	        
	        
	        olist.complete();
	       
	        try {
	            latch.await();	            
	            System.out.println("2");
	        } catch (InterruptedException e) {}
		
		
		
		
	}

}
