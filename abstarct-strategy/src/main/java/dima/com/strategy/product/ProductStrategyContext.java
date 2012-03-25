package dima.com.strategy.product;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dima.com.strategy.base.AbstractStrategy;
import dima.com.strategy.base.AbstractStrategyContext;

@Component
public class ProductStrategyContext extends AbstractStrategyContext{
	
	@Autowired
	public void setMap(Set<ProductAbstractStrategy> strategy){		
		for (AbstractStrategy s : strategy) {
			this.strategy.put(s.getKey(), s.getValue());
		}
	}
	

}
