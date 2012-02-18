package com.dima;

import java.util.List;
import org.hibernate.Query;
import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.dima.dto.Student;

public class StudentTestOne extends TestTemplate{
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional(rollbackFor = Exception.class, readOnly=true)
	@Rollback(value = true)
	public void someTestWithTrunsaction()  {		
		Query query = getSession().createQuery("select s from Student s");
		List<Student> students = query.list();		
		assertTrue(students.size() > 0);
	}
	
}
