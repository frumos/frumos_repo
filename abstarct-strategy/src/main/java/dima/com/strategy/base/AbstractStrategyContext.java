package dima.com.strategy.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class AbstractStrategyContext {
	
	public final Map<String, IStrategy> strategies = new HashMap<String, IStrategy>();
	
	public IStrategy getStrategy(String key) {
		IStrategy str = strategies.get(key); 
		if(str == null) {
			throw new IllegalArgumentException("Can not find strategy in the context: "  
					+ getStrategyContext().getName() + " for version: " + key);
		} else {
			return str;
		}
	}
	
	public abstract Class<? extends AbstractStrategyContext> getStrategyContext();
	
	public void setMap(Set<? extends AbstractStrategy> strategy){		
		for (AbstractStrategy s : strategy) {
			this.strategies.put(s.getKey(), s.getValue());
		}
	}
	
}
