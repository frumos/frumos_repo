package com.dima.aop;

// I am a class who exposes a business logic of old model. I am normally invoked by
// presentation layer based on old good WEB services 
public class OldModelBasedOnWebService {
	
	// but we also mark this method with our annotation to be handled by
	// mapper to do some magic in new model
	@ExecuteAop(mapper=MyMethodMapper.class)
	public String createSubscription(String operator){		
		return "Old model invocation: I just created a new subscription in DB for operator: " + operator;
	}
}
