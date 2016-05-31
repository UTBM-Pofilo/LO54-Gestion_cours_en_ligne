package fr.utbm.lo54.project.core.entity.repository;

import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultDao {
    
    private final static Logger LOGGER = LoggerFactory
			.getLogger(DefaultDao.class);
    
    /**
     * To insert an entity into the database
     * @param entity 
     */
    public static void insertEntity(final IEntity entity) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        } catch(HibernateException e) {
            LOGGER.error("insertEntity: " + e);
        }
    }

    /**
     * To update an entity into the database
     * @param entity 
     */
    public static void updateEntity(final IEntity entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * To remove an entity into the database
     * @param id
     * @param clazz
     */
    public static void removeEntity(final int id, final String clazz) {
        IEntity entity = DefaultDao.getEntity(id, clazz);
        Session session = HibernateUtil.getSession();
        try{
           session.beginTransaction();
           session.delete(entity);
           session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.error("removeEntity: " + e);
        } 
    }
    
    /**
     * To remove an entity into the database
     * @param id
     * @param clazz
     */
    public static void removeEntity(final String id, final String clazz) {
        IEntity entity = DefaultDao.getEntity(id, clazz);
        Session session = HibernateUtil.getSession();
        try{
           session.beginTransaction();
           session.delete(entity);
           session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.error("removeEntity: " + e);
        } 
    }
    
    /**
     * To get an entity from his id and class
     * @param id
     * @param clazz
     * @return 
     */
    public static IEntity getEntity(final int id, final String clazz) {
        final Session session = HibernateUtil.getSession();
        IEntity entity = null;
        try {
            session.beginTransaction();
            entity = (IEntity) session.get(clazz, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.error("getEntity: " + e);
        } 
        return entity;
    }
    
    /**
     * To get an entity from his id and class
     * @param id
     * @param clazz
     * @return 
     */
    public static IEntity getEntity(final String id, final String clazz) {
        final Session session = HibernateUtil.getSession();
        IEntity entity = null;
        try {
            session.beginTransaction();
            // entity = (IEntity) session.get(Client.class, id);
            entity = (IEntity) session.get(clazz, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.error("getEntity: " + e);
        } 
        return entity;
    }
    
    /**
     * To get all the entities
     * @param clazz
     * @return 
     */
    public static List<IEntity> getEntities(final String clazz) {
        final Session session = HibernateUtil.getSession();
        List<IEntity> listEntities = null;
        try {
            Query query = session.createQuery("from " + clazz);
            listEntities = query.list();
        }catch (HibernateException e) {
            LOGGER.error("getEntities: " + e);
        } 
        return listEntities;
    }
    
}
