package com.dima;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.dima.dto.Student;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
         
        Transaction tx = session.beginTransaction();
        
        Student s = new Student();
        s.setFirst_name("Dima");
        s.setLast_name("Kovtun");
        
        session.save(s);
        tx.commit();
        
    }
}
