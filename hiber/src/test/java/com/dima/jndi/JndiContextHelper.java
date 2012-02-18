package com.dima.jndi;

import java.io.IOException;
import java.util.Properties;

import javax.naming.NamingException;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

/**
 * @author Dmytro Kovtun
 * @since 15.01.2012
 * 
 * This class is helper to create an JNDI context and register data source objects
 * which can be retrieved from unit tests of persistence layer. Essentially it emulates 
 * JNDI support like in application container. The key class for that is SimpleNamingContextBuilder
 * @see also     
 *
 */
public class JndiContextHelper {
		
	private static JndiContextHelper jndiContextHelper;
		
	private SimpleNamingContextBuilder simpleNamingContextBuilder;
	
	private JndiContextHelper(){		
		simpleNamingContextBuilder = new SimpleNamingContextBuilder();
	}
		
	public static void destroyJndiContext(){
		if (jndiContextHelper != null){
			jndiContextHelper.simpleNamingContextBuilder.deactivate();
			jndiContextHelper.simpleNamingContextBuilder.clear();
			jndiContextHelper.simpleNamingContextBuilder = null;
			jndiContextHelper = null;
		}	
	}
	
	public static void initializeJndiContext(String dataSourceName, String hibernateCfg) 
	throws IOException, IllegalStateException, NamingException{		
		if (jndiContextHelper == null){
			jndiContextHelper = new JndiContextHelper();			
			jndiContextHelper.initializeDataSource(dataSourceName, hibernateCfg);
		} else {
			// allows a creation and registration of several data sources in the same JNDI context 
			jndiContextHelper.initializeDataSource(dataSourceName, hibernateCfg);
		}
	}
	
	private void initializeDataSource(String dataSourceName, String hibernateCfg) 
	throws IOException,	IllegalStateException,	NamingException{		
		Properties hibernateProperties = new Properties();		
		hibernateProperties.load(getClass().getResourceAsStream(hibernateCfg));
		
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(hibernateProperties.getProperty(Environment.DRIVER));
		ds.setUrl(hibernateProperties.getProperty(Environment.URL));
		ds.setUsername(hibernateProperties.getProperty(Environment.USER));
		ds.setPassword(hibernateProperties.getProperty(Environment.PASS));
				
		simpleNamingContextBuilder.bind(dataSourceName, ds);
		simpleNamingContextBuilder.activate();		
	}	

}
