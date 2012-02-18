package com.dima;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dima.jndi.JndiContextHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-config.xml"})
public class TestTemplate extends HibernateDaoSupport{
	
	private static String jndiDataSource = "java:comp/env/jdbc/student";	
	private static String jndiDataSourceSlave1 = "java:comp/env/jdbc/studentSlave1";
	private static String jndiDataSourceSlave2 = "java:comp/env/jdbc/studentSlave2";
	
	
	private static String hibernateCfg = "/hibernate.cfg.test.properties";
	private static String hibernateCfgSlave1 = "/hibernate.cfg.testSlave1.properties";
	private static String hibernateCfgSlave2 = "/hibernate.cfg.testSlave2.properties";
	
	@BeforeClass
	public static void beforeTestSuit(){
		try {
			JndiContextHelper.initializeJndiContext(jndiDataSource, hibernateCfg);
			JndiContextHelper.initializeJndiContext(jndiDataSourceSlave1, hibernateCfgSlave1);
			JndiContextHelper.initializeJndiContext(jndiDataSourceSlave2, hibernateCfgSlave2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
	
	@AfterClass
	public static void afterTestSuit(){
		JndiContextHelper.destroyJndiContext();
	}
	
	@Autowired
	public void configSessionFactory(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
		getSessionFactory().getStatistics().setStatisticsEnabled(true);
	}
	
	public Statistics getStatistics(){
		return getSessionFactory().getStatistics();
	}
	
	@Test
	public void fake(){
		
	}
	
}
