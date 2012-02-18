package com.dima.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Helper class for all DAO objects to obtain a Session or HibernateTemplate
 * 
 * @author Dmytro Kovtun
 *
 */
public abstract class DaoTemplate extends HibernateDaoSupport{

	@Autowired
	public void configSessionFactory(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	
}
