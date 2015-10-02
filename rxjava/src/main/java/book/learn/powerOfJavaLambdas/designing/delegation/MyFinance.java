package book.learn.powerOfJavaLambdas.designing.delegation;

import java.math.BigDecimal;

/**
 * Just another price provider
 * @author frum
 *
 */
public class MyFinance {
	
	public BigDecimal getPrice(String ticker) {
		return new BigDecimal("20.00");
	}
	
}
