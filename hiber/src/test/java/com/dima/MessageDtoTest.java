package com.dima;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.junit.Test;

import org.springframework.transaction.annotation.Transactional;

import com.dima.dto.Message;

@SuppressWarnings("unchecked")
public class MessageDtoTest extends TestTemplate{
	
	
	@Test
	@Transactional(rollbackFor = Exception.class, readOnly = true)	
	public void testMessage1(){
		Query query = getSession().createQuery("select m from Message m");
		List<Message> m = query.list();	
		assertNotNull(m);
		getStatistics().logSummary();				
	}
	
	@Test
	@Transactional(rollbackFor = Exception.class, readOnly = true)	
	public void testMessage2(){
		Query query = getSession().createQuery("select m from Message m");
		List<Message> m = query.list();
		assertNotNull(m);						
	}
	
}
