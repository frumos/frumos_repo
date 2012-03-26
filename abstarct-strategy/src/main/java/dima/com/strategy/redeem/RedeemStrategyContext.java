package dima.com.strategy.redeem;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dima.com.strategy.base.AbstractStrategyContext;

@Component
public class RedeemStrategyContext extends AbstractStrategyContext{
	
	@Autowired
	public void setContext(Set<RedeemAbstractStrategy> strategy){	
		super.setMap(strategy);
	}

	@Override
	public Class<? extends AbstractStrategyContext> getStrategyContext() {		
		return this.getClass();
	}

	
}
