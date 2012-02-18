package com.dima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AspectEngine implements ApplicationContextAware {

	@Autowired
    private ApplicationContext ctx;    
    private AsyncExecutor asyncExecutor = new AsyncExecutor();
	
	public void setAsyncExecutor(AsyncExecutor asyncExecutor) {
		this.asyncExecutor = asyncExecutor;
	}

	@Around("@annotation(executeAop)")
	public Object around(ProceedingJoinPoint joinPoint, ExecuteAop executeAop) throws Throwable {
		MethodMapper mm = ctx.getBean(executeAop.mapper());
		
		String result = (String)mm.mapMethod(joinPoint.getArgs());
		
		AsyncExecutor.executeAsync(asyncExecutor.new Task(this, joinPoint));
		return result;
	}

	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx = ctx;		
	}
	
	protected void executePsp(ProceedingJoinPoint joinPoint) throws Throwable{		
		System.out.println("RESULT OF ASYNC PSP EXECUTION: " + joinPoint.proceed());		
	}

}
