package com.habr.dima.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @author Dmytro Kovtun
 * 
 * Custom annotation definition 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MapModels {
	
	Class<? extends ModelMapper> mapper();

}
