package fr.utbm.lo54.project.core.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hibernate Utility class with a convenient method to get an open session.
 */
public class HibernateUtil {
    private final static Logger LOGGER = LoggerFactory
			.getLogger(HibernateUtil.class);
    
    private static final SessionFactory sessionFactory;
    
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    private static Session SESSION = null;
    public static Session getSession() throws HibernateException {
        if (SESSION == null || SESSION.isOpen() == false) {
            SESSION = sessionFactory.openSession();
        }
        return SESSION;
    }
    
    public static void closeSession() throws HibernateException {
        SESSION.close();
    }
}
