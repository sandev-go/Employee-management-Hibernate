package com.util;

 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {
	
	static SessionFactory sessionFactory;
	
	static {
		
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		sessionFactory=configuration.buildSessionFactory();
		
	}
	
	public static Session getSession()
	{
		Session session=sessionFactory.openSession();
		return  session;
		
	}
	 
	 

	 

}
