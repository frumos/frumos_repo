package com.dima.readyimpl;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Dmytro Kovtun
 *
 */
@Component
public class RoundRobin {
	
	private static String[] slaves;
	
	private static int index = 0;
	
	private static int size;
	
	/**
	 * Constructor which initiates an array of slaves passed via spring context 
	 * 
	 * @param slaves
	 */
	public RoundRobin(List<String> slaves){
		RoundRobin.slaves = new String[slaves.size()];
		size = slaves.size();
		for (int i = 0; i < size; i++) {
			RoundRobin.slaves[i] = slaves.get(i);
		}		
	}
	
	public static synchronized String getNextSlave(){
		if (index == size){
			index = 0;
		}
		return slaves[index++];
	}

}
