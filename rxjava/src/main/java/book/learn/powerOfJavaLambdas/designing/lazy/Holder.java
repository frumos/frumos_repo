package book.learn.powerOfJavaLambdas.designing.lazy;

import java.util.function.Supplier;

public class Holder {
	
	private Supplier<Heavy> heavy = () -> createAndCacheHeavy();
	
	private synchronized Heavy createAndCacheHeavy() {
		class HeavyFactory implements Supplier<Heavy> {
			private final Heavy heavyInstance = new Heavy();
			@Override
			public Heavy get() {return heavyInstance;}			
		}
		
		if(!HeavyFactory.class.isInstance(heavy)) {
			heavy = new HeavyFactory();
		}		
		return heavy.get();
	}
	
	public Holder() {
		System.out.println("Holder is created");
	}
	
	public Heavy createHeavy() {
		return heavy.get();
	}
	
	public static void main(String[] args) {
		Holder holder = new Holder();
		holder.createHeavy();
		holder.createHeavy();
		holder.createHeavy();
	}

}
