package com.incapp.HibernateApp;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Read 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
    	cfg.configure("incapp.xml");
    	cfg.addAnnotatedClass(Book.class); // Create a Book table in Database
    	SessionFactory factory = cfg.buildSessionFactory(); // Connected with data base
		Session session = factory.openSession();
    	
		Book b=session.get(Book.class, "math");
		if(b==null) {
			System.out.println("Book Not found!");
		}else {
			System.out.println(b);
		}
		
        session.close();
        
    }
}
