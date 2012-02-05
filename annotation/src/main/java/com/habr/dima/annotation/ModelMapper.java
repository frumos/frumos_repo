package com.habr.dima.annotation;

/**
 * @author Dmytro Kovtun
 * 
 * This interface defines a contract for all concrete mappers 
 * which need to map some business methods of Model-1 to Model-2
 */
public interface ModelMapper {
	
	public Object mapM1toM2(Object args[]);

}
