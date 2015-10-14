package book.learn.powerOfJavaLambdas.designing.delegation;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * NAV - Net assets value - стоимость чистых активов
 * 
 * @author frum
 *
 */

public class CalculateNAV {
	
	private Function<String, BigDecimal> priceFinder;
	
	// constructor to inject function
	public CalculateNAV(Function<String, BigDecimal> priceFinder) {
		this.priceFinder = priceFinder;
	}
	/**
	 * 
	 * @param ticker - тикер, биржевой аппарат, передающий котировки ценных бумаг
	 * @param shares
	 * @return
	 */
	public BigDecimal computeStockWorth(final String ticker, final int shares) {
		return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
	}
	
	
	public static void main(String[] args) {
		
		// Delegate (via constructor) with static reference 
		CalculateNAV yahooCalculator = new CalculateNAV(YahooFinance::getPrice);
		System.out.println(String.format("Worth is: $%.2f", yahooCalculator.computeStockWorth("AMZN", 200)));

		// Delegate (via constructor) with lambda instance
		MyFinance my = new MyFinance();
		new CalculateNAV(ticker -> my.getPrice(ticker));
		
		
	}

}
