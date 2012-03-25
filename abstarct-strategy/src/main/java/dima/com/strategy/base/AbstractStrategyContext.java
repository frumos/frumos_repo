package dima.com.strategy.base;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStrategyContext {
	
	public final Map<String, IStrategy> strategy = new HashMap<String, IStrategy>();
	
	public IStrategy getStrategy(String key) {
		IStrategy str = strategy.get(key); 
		if(str == null) {
			throw new IllegalArgumentException("Can not find strategy for version: " + key);
		} else {
			return str;
		}
	}
}
