package book.learn.powerOfJavaLambdas.designing;

import java.math.BigDecimal;
import java.util.function.Function;

import org.junit.Test;

import book.learn.powerOfJavaLambdas.designing.delegation.CalculateNAV;
import static org.junit.Assert.*;

/**
 * Test showing how do we delegate (via constructor creation) to the different functions 
 * @author frum
 *
 */
public class CalculateNAVTest {
	
	@Test
	public void computeStocks() {				
		
		// old way creating constructor with anonimus class
		CalculateNAV calculateNAV = new CalculateNAV(new Function<String, BigDecimal>() {			
			@Override
			public BigDecimal apply(String t) {
				return new BigDecimal("6.01");
			}
		});
		
		// old way creating constructor with lambda
		CalculateNAV calculateNAV_new = new CalculateNAV(ticker -> new BigDecimal("6.01"));

		BigDecimal expected = new BigDecimal("60.1");
		BigDecimal expected_new = new BigDecimal("6010.00");
		
		assertEquals(0, calculateNAV.computeStockWorth("whatever_ticker_stub", 10).compareTo(expected));
		assertEquals(0, calculateNAV_new.computeStockWorth("whatever_ticker_stub_new", 1000).compareTo(expected_new));
		
	}

}
