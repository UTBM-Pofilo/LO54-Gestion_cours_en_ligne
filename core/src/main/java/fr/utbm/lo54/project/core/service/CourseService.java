package fr.utbm.lo54.project.core.service;

import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.repository.CourseDao;
import java.util.List;

public class CourseService implements IService {
    private final CourseDao courseDao;

    public CourseService() {
        this.courseDao = new CourseDao();
    }
    
    @Override
    public void storeEntity(final IEntity entity) {
        this.courseDao.insertEntity(entity);
    }

    @Override
    public void updateEntity(final Object id, final IEntity entity) {
        this.courseDao.updateEntity(id, entity);
    }

    @Override
    public void removeEntity(final Object id) {
        this.courseDao.removeEntity(id);
    }

    @Override
    public List<IEntity> getEntities() {
        return this.courseDao.getEntities();
    }

    @Override
    public IEntity getEntity(final Object id) {
        return this.courseDao.getEntity(id);
    }
}
