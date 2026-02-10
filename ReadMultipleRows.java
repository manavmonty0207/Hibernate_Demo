package com.incapp.HibernateApp;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadMultipleRows 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
    	cfg.configure();
//    	cfg.configure("incapp.xml");
    	cfg.addAnnotatedClass(Book.class); // Create a Book table in Database
    	SessionFactory factory = cfg.buildSessionFactory(); // Connected with data base
		Session session = factory.openSession();
    	
		List<Book> books=session.createQuery("from Book",Book.class).list();
		if(books.isEmpty()) {
			System.out.println("Table is Empty!");
		}else {
			for(Book b:books) {
				System.out.println(b);
			}
		}
        session.close();
        
    }
}
