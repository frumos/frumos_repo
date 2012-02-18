package com.dima.aop;

import java.util.List;

public class SomePspBusinessProcess {
	
	@ExecuteAop(mapper=MyMethodMapper.class)
	public String pspBusinessMethos(String operatorId, List<String> l){
		int i = 0;
		for (String string : l) {
			if(string.equals(operatorId)) break;
			i++;
		}
		System.out.println("BUSINES METHOD CALLED");
		return "Operator: " + operatorId + " has index: " + i;
	}

}
