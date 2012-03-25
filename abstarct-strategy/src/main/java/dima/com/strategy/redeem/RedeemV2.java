package dima.com.strategy.redeem;

import org.springframework.stereotype.Component;


@Component
public class RedeemV2 extends RedeemAbstractStrategy{

	public void executeStrategy() {
		System.out.println("Executing redeem v.2");
	}

	public String getVersion() {		
		return "V2";
	}

}
