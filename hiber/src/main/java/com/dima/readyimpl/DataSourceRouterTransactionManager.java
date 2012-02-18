
package com.dima.readyimpl;

import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * This class is created to work around a Spring bug.
 * Routing data source can not work correctly if current transaction information
 * is not bound to transactional context before asking connection from the data source. 
 * 
 * @author Dmytro Kovtun 
 * 
 */

@SuppressWarnings("serial")
public class DataSourceRouterTransactionManager extends HibernateTransactionManager{
	
	@Override
	protected void doBegin(Object transaction, TransactionDefinition definition) {
		TransactionSynchronizationManager.setCurrentTransactionReadOnly(definition.isReadOnly());
		super.doBegin(transaction, definition);
	}
}
