import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

import rx.Observable;
import rx.subjects.PublishSubject;


public class BatchGenerator<R> {
	
	private final CountDownLatch latch;
	
	private final BlockingQueue<R> q;
    
    protected final PublishSubject<List<R>> onAdd;

    public BatchGenerator(CountDownLatch latch) {
    	this.q = new ArrayBlockingQueue<>(2);	        
        this.onAdd = PublishSubject.create();
        this.latch = latch;
    }
    
    public void add(R value) {	
    	if(!q.offer(value)) {
            List<R> l = new ArrayList<>();
            synchronized (q) {               
                q.drainTo(l);       
                q.add(value);
                System.out.println("Drain...");		               
            }
            onAdd.onNext(l);		            
    	}
    }	
    	
    public Observable<List<R>> getObservable() {
        return onAdd;
    }
    
    public void complete() {
    	List<R> l = new ArrayList<>();
    	q.drainTo(l);
    	onAdd.onNext(l);
    	onAdd.onCompleted();
    }
}

