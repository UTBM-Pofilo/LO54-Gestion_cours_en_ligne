package fr.utbm.lo54.project.core.service;

import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.entity.repository.CourseDao;
import java.util.List;

public class CourseService implements IService {
    private final CourseDao courseDao;

    public CourseService() {
        this.courseDao = new CourseDao();
    }
    
    @Override
    public void storeEntity(IEntity entity) {
        this.courseDao.insertEntity(entity);
    }

    @Override
    public void updateEntity(IEntity entity) {
        this.courseDao.updateEntity(entity);
    }

    @Override
    public void removeEntity(IEntity entity) {
        this.courseDao.removeEntity(entity);
    }

    @Override
    public IEntity getEntity(int id) {
        return this.courseDao.getEntity(id);
    }

    @Override
    public List<IEntity> getEntities() {
        return this.courseDao.getEntities();
    }
}
