package fr.utbm.lo54.project.core.entity.repository;

import fr.utbm.lo54.project.core.entity.Course;
import fr.utbm.lo54.project.core.entity.IEntity;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseDao implements IDao{

    private final static Logger LOGGER = LoggerFactory
			.getLogger(CourseDao.class);
        
    @Override
    public void insertEntity(final IEntity entity) {
        DefaultDao.insertEntity(entity);
    }

    @Override
    public void updateEntity(final IEntity entity) {
        DefaultDao.updateEntity(entity);
    }

    @Override
    public List<IEntity> getEntities() {
        return DefaultDao.getEntities(Course.class.getCanonicalName());
    }

    @Override
    public void removeEntity(final Object id) {
        DefaultDao.removeEntity((String) id, Course.class.getCanonicalName());
    }

    @Override
    public IEntity getEntity(final Object id) {
        return DefaultDao.getEntity((String) id, Course.class.getCanonicalName());
    }
}
