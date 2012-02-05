package com.habr.dima.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/** 
 * @author Dmytro Kovtun
 * 
 * @MapModels annotation handler based on around aspect 
 */

@Aspect
@Component
public class AnnotationHandler {
	
	@Autowired
	private ApplicationContext ctx;
	
	@Around("@annotation(mapModels)")
	public Object around(ProceedingJoinPoint joinPoint, MapModels mapModels) throws Throwable{
		// getting concrete mapper implementation 
		ModelMapper mapper = ctx.getBean(mapModels.mapper());
		
		// magic is here, convert model-1 into model-2 and perform model-2 business logic invocation
		String result = (String)mapper.mapM1toM2(joinPoint.getArgs());
		
		System.out.println("Handling @MapModels annotation");
		System.out.println(result);
		
		// and finally execute business logic of model-1, transparently for client  
		return joinPoint.proceed();
	}
}
