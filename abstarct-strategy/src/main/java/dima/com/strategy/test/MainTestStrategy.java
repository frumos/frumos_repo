package dima.com.strategy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dima.com.strategy.product.ProductStrategyContext;
import dima.com.strategy.redeem.RedeemStrategyContext;

public class MainTestStrategy {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-cfg.xml");
		RedeemStrategyContext redeemContext = ctx.getBean(RedeemStrategyContext.class);		
		ProductStrategyContext productContext = ctx.getBean(ProductStrategyContext.class);
		
		redeemContext.getStrategy("V1").executeStrategy();
		productContext.getStrategy("V5").executeStrategy();
		
	}

}
