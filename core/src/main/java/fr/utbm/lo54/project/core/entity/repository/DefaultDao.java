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
            LOGGER.error("Insertion of entity: " + e);
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
     * @param entity 
     */
    public static void removeEntity(final IEntity entity) {
        final Session session = HibernateUtil.getSession();
        session.delete(entity);
    }
    
    /**
     * To get an entity from his id and class
     * @param id
     * @param clazz
     * @return 
     */
    public static IEntity getEntity(final int id, String clazz) {
        final Session session = HibernateUtil.getSession();
        IEntity entity = null;
        try {
            session.beginTransaction();
            entity = (IEntity) session.get(clazz, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.err.println(e);
        } 
        return entity;
    }
    
    /**
     * To get an entity from his id and class
     * @param id
     * @param clazz
     * @return 
     */
    public static IEntity getEntity(final String id, String clazz) {
        final Session session = HibernateUtil.getSession();
        IEntity entity = null;
        try {
            session.beginTransaction();
            // entity = (IEntity) session.get(Client.class, id);
            entity = (IEntity) session.get(clazz, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.err.println(e);
        } 
        return entity;
    }
    
    /**
     * To get all the entities
     * @param clazz
     * @return 
     */
    public static List<IEntity> getEntities(String clazz) {
        final Session session = HibernateUtil.getSession();
        List<IEntity> listEntities = null;
        try {
            Query query = session.createQuery("from " + clazz);
            listEntities = query.list();
        }catch (HibernateException e) {
            LOGGER.error("getEntities" + e);
        } 
        return listEntities;
    }
    
}
