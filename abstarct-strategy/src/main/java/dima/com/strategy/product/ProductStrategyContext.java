package dima.com.strategy.product;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dima.com.strategy.base.AbstractStrategyContext;

@Component
public class ProductStrategyContext extends AbstractStrategyContext{
	
	@Autowired
	public void setContext(Set<ProductAbstractStrategy> strategy){	
		super.setMap(strategy);
	}

	@Override
	public Class<? extends AbstractStrategyContext> getStrategyContext() {
		return this.getClass();
	}
}
