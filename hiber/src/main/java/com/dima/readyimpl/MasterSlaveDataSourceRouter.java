package com.dima.readyimpl;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author Dmytro Kovtun
 * @since 11.01.2012
 *
 * This class is a router to the dynamic data sources objects 
 *  
 * @see this article in internet describing it: 
 * http://blog.springsource.com/2007/01/23/dynamic-datasource-routing/
 */
public class MasterSlaveDataSourceRouter extends AbstractRoutingDataSource{
		
	@Override
	protected Object determineCurrentLookupKey() {		
		return TransactionSynchronizationManager.isCurrentTransactionReadOnly()?getSlave():"master";
	}
	
	/**
	 * RoundRoubin returns the next slave
	 * 
	 * @return
	 */
	private String getSlave(){
		String slave = RoundRobin.getNextSlave(); 
		System.out.println(" =================== Hit slave source " + slave );
		return slave;
	}
	
}
