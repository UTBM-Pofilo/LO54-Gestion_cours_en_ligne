package fr.utbm.lo54.project.core.repository;

import fr.utbm.lo54.project.core.entity.Course;
import fr.utbm.lo54.project.core.entity.CourseSession;
import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.entity.Location;
import fr.utbm.lo54.project.core.util.HibernateUtil;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseSessionDao implements IDao {
    
    private final static Logger LOGGER = LoggerFactory
			.getLogger(CourseSessionDao.class);

    @Override
    public void insertEntity(final IEntity entity) {
        DefaultDao.insertEntity(entity);
    }

    @Override
    public void updateEntity(final Object id, final IEntity entity) {
        DefaultDao.updateEntity((int) id, CourseSession.class.getCanonicalName(), entity);
    }

    @Override
    public void removeEntity(final Object id) {
        DefaultDao.removeEntity((int) id, CourseSession.class.getCanonicalName());
    }

    @Override
    public IEntity getEntity(final Object id) {
        return DefaultDao.getEntity((int) id, CourseSession.class.getCanonicalName());
    }

    @Override
    public List<IEntity> getEntities() {
        return DefaultDao.getEntities(CourseSession.class.getCanonicalName());
    }
    
    public List<IEntity> getEntitiesByTimeStamp(final Timestamp tmin, final Timestamp tmax) {
        final Session session = HibernateUtil.getSession();
        List<IEntity> listEntities = null;
        
        try {
            Query query = session.createQuery("from " + CourseSession.class.getCanonicalName() + " c where c.startDate < :timeStampMax and c.startDate > :timeStampMin");
            query.setParameter("timeStampMin", tmin);
            query.setParameter("timeStampMax", tmax);
            listEntities = query.list();
        }catch (HibernateException e) {
            LOGGER.error("getEntities" + e);
        } 
        return listEntities;
    }
    
    public List<IEntity> getEntitiesByLocation(final String filter) {
        final Session session = HibernateUtil.getSession();
        List<IEntity> listEntities = null;
        
        try {
            Query query = session.createQuery("from " + Location.class.getCanonicalName() + " where city = :cityFilter");
            query.setParameter("cityFilter", filter);
            listEntities = query.list();
        }catch (HibernateException e) {
            LOGGER.error("getEntities" + e);
        } 
        
        List<IEntity> listResult;
        listResult = new ArrayList<>();
        
        for(IEntity entity : listEntities) {
            Location location = (Location) entity;
                
            List<IEntity> listEntities2 = null;
        
            try {
                Query query = session.createQuery("from " + CourseSession.class.getCanonicalName() + " where location = :locationFilter");
                query.setParameter("locationFilter", location);
                listEntities2 = query.list();
                listResult.addAll(listEntities2);
            }catch (HibernateException e) {
                LOGGER.error("getEntities" + e);
            } 
        }
        return listResult;
    }
    
    public List<IEntity> getEntitiesByTitle(final String filter) {
        final Session session = HibernateUtil.getSession();
        List<IEntity> listEntities = null;
        try {
            Query query = session.createQuery("from " + Course.class.getCanonicalName() + " where title like :titleFilter");
            query.setParameter("titleFilter", "%" + filter + "%");
            listEntities = query.list();
        }catch (HibernateException e) {
            LOGGER.error("getEntities" + e);
        } 
        
        List<IEntity> listEntities2 = null;
        
        if (listEntities != null) {
            for(IEntity entity : listEntities) {
                Course course = (Course) entity;
                try {
                    Query query = session.createQuery("from " + CourseSession.class.getCanonicalName() + " where course like :code");
                    query.setParameter("code", course);
                    listEntities2 = query.list();
                }catch (HibernateException e) {
                    LOGGER.error("getEntities" + e);
                } 
            }
        }
        return listEntities2;
    }
}
