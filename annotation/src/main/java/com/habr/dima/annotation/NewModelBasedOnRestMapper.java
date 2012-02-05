package com.habr.dima.annotation;

import org.springframework.stereotype.Component;

/**
 * @author Dmytro Kovtun 
 * 
 * I am an implementation for new better model 
 * based on REST service. I invoked by somebody else who
 * is marked by @ExecuteAop annotation.
 */
@Component
public class NewModelBasedOnRestMapper implements ModelMapper{

	public Object mapM1toM2(Object args[]) {
		String param = (String) args[0];
        return "I just performed an execution of business " +
        		"method of new model for operator: " + param;		
	}
}
