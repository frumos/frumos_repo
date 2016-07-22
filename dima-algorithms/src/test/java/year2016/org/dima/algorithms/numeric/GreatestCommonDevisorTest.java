package year2016.org.dima.algorithms.numeric;

import org.junit.Assert;
import org.junit.Test;


public class GreatestCommonDevisorTest {
	
	GreatestCommonDevisor gcd = new GreatestCommonDevisor();
	
	@Test
	public void gcdTest() {
		int result = gcd.gcd(20, 15);
		Assert.assertEquals(5, result);		
		
		int result1 = gcd.gcd(44, 8);
		Assert.assertEquals(4, result1);
		
		int result2 = gcd.gcd(12, 33);
		Assert.assertEquals(3, result2);		
	}
	

}
