package year2016.org.dima.algorithms.numeric;

import org.junit.Assert;
import org.junit.Test;

public class BinaryAdditionTest {
		
	@Test
	public void binaryAdditionTest() {
		BinaryAddition binaryAddition = new BinaryAddition();
		
		String a = "0011001011001"; //1625
		String b = "1101010101"; // 853
		
		Assert.assertEquals(2478, 
				Integer.parseInt(binaryAddition.addition(a, b), 2)); //2478
						
		
		a = "111001"; //57
		b = "1101"; // 13
		
		Assert.assertEquals(70, 
				Integer.parseInt(binaryAddition.addition(a, b), 2)); //70
		
		
		
		a = "10011001001"; //1225
		b = "1101001"; //105
		
		Assert.assertEquals(1330, 
				Integer.parseInt(binaryAddition.addition(a, b), 2)); //1330
		
		
		a = "10011011010101"; //9941
		b = "1101011111101"; //6909
		
		
		Assert.assertEquals(16850, 
				Integer.parseInt(binaryAddition.addition(a, b), 2)); //16850
		
		
		a = "1111111"; //127
		b = "0000000000"; //0
		
		
		Assert.assertEquals(127, 
				Integer.parseInt(binaryAddition.addition(a, b), 2)); //127
		
		
		a = "100111111"; //319
		b = "101"; // 5
		
		Assert.assertEquals(324, 
				Integer.parseInt(binaryAddition.addition(a, b), 2)); //324
		
		
	}
	

}
