import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class RecordProcessor<R>  {
	
	  private final BlockingQueue<R> q;
	   
	    private final CountDownLatch latch;
	    
	    private int k;
	   
	    public RecordProcessor(int numberOfRecords, CountDownLatch latch) {
	        this.q = new ArrayBlockingQueue<>(numberOfRecords);
	        this.latch = latch;
	    }
	   
	    public void addRecords(Collection<R> records) {
	        records
	            .stream()
	            .forEach(this::addRecord);
	    }
	
	    public void addRecord(R record) {       
	        if(!q.offer(record)) {
	            List<R> l = new ArrayList<>();
	            synchronized (q) {               
	                q.drainTo(l);       
	                q.add(record);
	                System.out.println("Drain...");
	                k++;
	            }
	            processSetOfRecords(l);
	        }
	    }   
	   
	    public void completeGeneration() {
	        List<R> l = new ArrayList<>();
	        q.drainTo(l);
	        
//	        System.out.println("KKKKKKKKKKKKKKKKKKKK " + k );
	        getRecordsObservable(l, () -> latch.countDown());
	    }   
	   
	    private void processSetOfRecords(List<R> l) {
	        getRecordsObservable(l, () -> {});
	    }
	    
	    private void getRecordsObservable(List<R> l, Action0 onComplete) {
	        Observable
	            .just(l)
	            .doOnCompleted(onComplete)           
	            .observeOn(Schedulers.computation())           
	            .subscribe(new onNextRecordSetAction(),
	                    new onErrorRecordSetAction(),
	                    new onCopleteRecordSetAction()
	        );
	    }
	   
	    private class onNextRecordSetAction implements Action1<List<R>> {
	        @Override
	        public void call(List<R> list) {
	            try {               
	            	System.out.println("HERE");
	            	list.stream().forEach(e -> {
		                System.out.println("Thread " + Thread.currentThread().getName() + " " +  e);
		            });   
//	                Thread.sleep(300);
	            } catch (Exception ex) {
	                System.out.println(ex.getMessage());
	            }                   
	                    
	        }       
	    }   

	    private class onCopleteRecordSetAction implements Action0 {
	        @Override
	        public void call() {
	        	System.out.println("Done with SET");
	        }
	    }
	   
	    private class onErrorRecordSetAction implements Action1<Throwable> {
	        @Override
	        public void call(Throwable t) {
	            // TODO Auto-generated method stub
	           
	        }       
	    }
	
	
	

}
