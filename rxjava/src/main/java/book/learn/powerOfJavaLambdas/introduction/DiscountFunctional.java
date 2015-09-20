package book.learn.powerOfJavaLambdas.introduction;

import static book.learn.powerOfJavaLambdas.introduction.Prices.*;

import java.math.BigDecimal;

public class DiscountFunctional {
	
	public static void main(String[] args) {
		
		BigDecimal result = prices.stream()
			.filter(pr -> pr.compareTo(BigDecimal.valueOf(20.0)) > 0)
			.map(pr -> pr.multiply(BigDecimal.valueOf(0.9)))
			.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		System.out.println(result);
	}

}
