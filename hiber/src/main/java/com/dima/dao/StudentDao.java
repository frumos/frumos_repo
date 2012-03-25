package com.dima.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dima.dto.Student;

@Repository
public class StudentDao extends DaoTemplate{
	
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
	
	
	public List<Student> fetchStudents(){
		Query query = getSession().createQuery("select s from Student s");	
		query.setCacheable(true);
		return (List<Student>)query.list();
	}
	
	public Student fetchStudentById(Long id){
		Query query = getSession().createQuery("select s from Student s where s.id = :id");
		query.setLong("id", id);
		query.setCacheable(true);
		return (Student)query.uniqueResult();
	}

}
