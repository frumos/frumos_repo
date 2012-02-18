package com.dima.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dima.dto.Student;

@Repository
public class StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly = false)
	public void saveOrUpdate(Student s){
		sessionFactory.getCurrentSession().saveOrUpdate(s);
	}
	
	public void fetch(){
		Query q = sessionFactory.getCurrentSession().createQuery("");
		q.setFirstResult(0).setMaxResults(100);
		
		
		
	}

}
