package dima.com.strategy.product;

import org.springframework.stereotype.Component;

@Component
public class ProductV1 extends ProductAbstractStrategy{

	public void executeStrategy() {		
		System.out.println("Executing product V1");
	}

	public String getVersion() {		
		return "V1";
	}

}
