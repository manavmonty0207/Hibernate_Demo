package com.incapp.HibernateApp;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Delete 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
    	cfg.configure("incapp.xml");
    	cfg.addAnnotatedClass(Book.class); // Create a Book table in Database
    	SessionFactory factory = cfg.buildSessionFactory(); // Connected with data base
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
    	
		Book b=session.get(Book.class, "SST");
		if(b==null) {
			System.out.println("Book Not found!");
		}else {
			session.remove(b);
			txn.commit();
			System.out.println("Success!");
		}
        session.close();
        
    }
}
