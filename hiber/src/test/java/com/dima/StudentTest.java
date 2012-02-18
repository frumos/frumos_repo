package com.dima;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dima.dao.StudentDao;
import com.dima.dto.Student;

public class StudentTest extends TestTemplate{
	
	@Autowired
	StudentDao studentDao;
	
	@Before
	public void before(){
		System.out.println("TEST");
	}
	
	@Test
	@Transactional
	@Rollback(value=true)
	public void someTest(){
		System.out.println("BEFORE TEST");
		Student s = new Student();
		s.setFirst_name("Morda11");
		s.setLast_name("Mordich11");
		studentDao.saveOrUpdate(s);
	}
	
	
	

}
