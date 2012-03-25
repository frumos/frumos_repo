package dima.com.strategy.base;

import java.util.Map;

public abstract class AbstractStrategy implements Map.Entry<String, IStrategy>, IStrategy{
	
	public String getKey() {		
		return getVersion();
	}
	
	public IStrategy getValue() {
		return this;
	}
	
	public IStrategy setValue(IStrategy value) {
		throw new UnsupportedOperationException();
	}

}
