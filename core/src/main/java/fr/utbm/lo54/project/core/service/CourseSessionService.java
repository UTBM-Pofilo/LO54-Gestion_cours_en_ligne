package fr.utbm.lo54.project.core.service;

import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.entity.repository.CourseSessionDao;
import java.util.List;

public class CourseSessionService implements IService {
    private final CourseSessionDao courseSessionDao;

    public CourseSessionService() {
        this.courseSessionDao = new CourseSessionDao();
    }
    
    @Override
    public void storeEntity(IEntity entity) {
        this.courseSessionDao.insertEntity(entity);
    }

    @Override
    public void updateEntity(IEntity entity) {
        this.courseSessionDao.updateEntity(entity);
    }

    @Override
    public void removeEntity(IEntity entity) {
        this.courseSessionDao.removeEntity(entity);
    }

    @Override
    public IEntity getEntity(int id) {
        return this.courseSessionDao.getEntity(id);
    }

    @Override
    public List<IEntity> getEntities() {
        return this.courseSessionDao.getEntities();
    }
}
