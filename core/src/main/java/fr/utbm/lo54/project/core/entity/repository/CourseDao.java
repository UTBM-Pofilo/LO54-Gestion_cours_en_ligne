package fr.utbm.lo54.project.core.entity.repository;

import fr.utbm.lo54.project.core.entity.Course;
import fr.utbm.lo54.project.core.entity.IEntity;
import java.util.List;

public class CourseDao implements IDao{

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
}
