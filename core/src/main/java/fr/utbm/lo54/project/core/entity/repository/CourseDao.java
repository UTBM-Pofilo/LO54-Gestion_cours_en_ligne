package fr.utbm.lo54.project.core.entity.repository;

import fr.utbm.lo54.project.core.entity.Course;
import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseDao implements IDao{

    private final static Logger LOGGER = LoggerFactory
			.getLogger(CourseDao.class);
        
    @Override
    public void insertEntity(IEntity entity) {
        DefaultDao.insertEntity(entity);
    }

    @Override
    public void updateEntity(IEntity entity) {
        DefaultDao.updateEntity(entity);
    }

    @Override
    public void removeEntity(IEntity entity) {
        DefaultDao.removeEntity(entity);
    }

    public IEntity getEntity(String id) {
        return DefaultDao.getEntity(id, Course.class.getCanonicalName());
    }

    @Override
    public List<IEntity> getEntities() {
        return DefaultDao.getEntities(Course.class.getCanonicalName());
    }

    @Override
    public IEntity getEntity(int id) {
        throw new UnsupportedOperationException("Not supported.");
    }

    public List<IEntity> getEntities(String filter) {
        final Session session = HibernateUtil.getSession();
        List<IEntity> listEntities = null;
        try {
            Query query = session.createQuery("from " + Course.class.getCanonicalName() + " where title like :titleFilter");
            query.setParameter("titleFilter", "%" + filter + "%");
            listEntities = query.list();
        }catch (HibernateException e) {
            LOGGER.error("getEntities" + e);
        } 
        return listEntities;
    }
}
