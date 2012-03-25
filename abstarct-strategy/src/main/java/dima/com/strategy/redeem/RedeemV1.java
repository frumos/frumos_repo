package dima.com.strategy.redeem;

import org.springframework.stereotype.Component;

@Component
public class RedeemV1 extends RedeemAbstractStrategy{

	public void executeStrategy() {
		System.out.println("Executing redeem v.1");
	}

	public String getVersion() {		
		return "V1";
	}

}
