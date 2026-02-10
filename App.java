package com.incapp.HibernateApp;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
    	cfg.configure("incapp.xml");
    	cfg.addAnnotatedClass(Book.class); // Create a Book table in Database
    	SessionFactory factory = cfg.buildSessionFactory(); // Connected with data base
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
    	
        Book b=new Book();
        b.setName("Java");
        b.setPrice(1500);
        b.setAuthor("Rahul Chauhan");
        b.setDop(new Date());
        
        session.persist(b); // Insert Book data inside the Book Table of DB
		txn.commit(); // Commit to confirm the insertion in DB
		session.close();
		System.out.println("Success");
        
    }
}
