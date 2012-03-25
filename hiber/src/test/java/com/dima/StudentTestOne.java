package com.dima;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.dima.dao.StudentDao;
import com.dima.dto.Student;

public class StudentTestOne extends TestTemplate{
	
	@Autowired
	StudentDao studentDao;
	
//	@SuppressWarnings("unchecked")
//	@Test
//	@Transactional(rollbackFor = Exception.class, readOnly=true)
//	@Rollback(value = true)
//	public void someTestWithTrunsaction()  {		
//		Query query = getSession().createQuery("select s from Student s");
//		List<Student> students = query.list();		
//		assertTrue(students.size() > 0);
//	}
	
	
	@Test
	public void cacheTest(){
		List<Student> students = studentDao.fetchStudents();			
	}
	
	@Test
	public void cacheTest2(){
		
		SessionFactory sessionFactory = getSessionFactory();
		Statistics stat = sessionFactory.getStatistics();
		
		List<Student> students = studentDao.fetchStudents();
		
		System.out.println("DIMA DEBUG1-1 " + stat.getSecondLevelCacheHitCount());
		
		
	}
	
//	@Test
//	public void cacheTest1(){
//		
//		SessionFactory sessionFactory = getSessionFactory();
//		Statistics stat = sessionFactory.getStatistics();
//		Student students = studentDao.fetchStudentById(1L);	
//		Student students1 = studentDao.fetchStudentById(1L);
//		Student students2 = studentDao.fetchStudentById(1L);
//		Student students3 = studentDao.fetchStudentById(1L);
//		Student students4 = studentDao.fetchStudentById(1L);
//		
//		System.out.println("DIMA DEBUG " + stat.getQueryCacheHitCount());
//		
//		Student students5 = studentDao.fetchStudentById(2L);
//		System.out.println("DIMA DEBUG1 " + stat.getQueryCacheHitCount());
//		Student students6 = studentDao.fetchStudentById(2L);
//		System.out.println("DIMA DEBUG1 " + stat.getQueryCacheHitCount());
//		
//		System.out.println("DIMA DEBUG1-1 " + stat.getSecondLevelCacheHitCount());		
//		
//		stat.clear();
//	}
	
	
}
