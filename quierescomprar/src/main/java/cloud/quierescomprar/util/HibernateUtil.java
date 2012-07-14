package cloud.quierescomprar.util;


import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	
private static final SessionFactory sessionFactory;
	
	
static {
		try {
		
			sessionFactory= new AnnotationConfiguration().configure().buildSessionFactory();
			
		} catch (Throwable ex) {
			// Asegúrese de loguear la excepción, dado que puede ser "tragada"
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSessionFactory() {
		return sessionFactory.openSession();
	}
	
	
}