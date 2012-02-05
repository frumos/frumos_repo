package com.habr.dima.annotation;

import org.springframework.stereotype.Component;

/**
 * @author Dmytro Kovtun
 * 
 * I am a class who exposes a business logic of old model. 
 * I am normally invoked by presentation layer based 
 * on old good WEB services 
 */
@Component
public class OldModelBasedOnWebService {
	
	// but we also mark this method with our "brand-new" annotation to be 
	// handled by mapper to perform some magic in the new model
    @MapModels(mapper=NewModelBasedOnRestMapper.class)
    public String createSubscription(String operator){
    	return "Old model invocation: I just created a " +
    			"new subscription in DB for operator: " + operator;
    }
}
