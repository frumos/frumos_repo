


	
	import java.util.concurrent.CountDownLatch;
	import java.util.stream.IntStream;


	public class Client {

	    public static void main(String[] args) {
	       
	       
	        CountDownLatch latch = new CountDownLatch(1);
	        final RecordProcessor<String> rs = new RecordProcessor<>(10, latch);
	       
	        System.out.println("1");
	        IntStream.range(0, 23).forEach(e -> rs.addRecord("Element:" + e));
	        
	        IntStream.range(0, 15).forEach(e -> rs.addRecord("Element:" + e));
	       
	        
	        
	        try {
	            latch.await();
	            rs.completeGeneration();
	            System.out.println("2");
	        } catch (InterruptedException e) {}
	       
	    }
}
