package com.dima.aop;

import java.util.List;

public class MyMethodMapper implements MethodMapper{

	public Object mapMethod(Object[] args) throws Exception {
		String operatorId = (String)args[0];		
		List<String> l = (List<String>)args[1];
		return "RESULT OF SEBE SYNC EXECUTION: " + operatorId.toUpperCase() + " in list with size: " + l.size();
	}

}
