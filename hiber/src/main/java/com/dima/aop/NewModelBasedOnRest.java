package com.dima.aop;

// I am an implementation for new more better model based on REST service.
// I normally invoked by REST interface but also can be invoked by
// somebody else who is marked by @ExecuteAop annotation. 
public class NewModelBasedOnRest implements MethodMapper{

	public Object mapMethod(Object[] args) throws Exception {
		String param = (String) args[0];
		return "I just performed an execution of business method of new model for operator: " + param;
	}
}
