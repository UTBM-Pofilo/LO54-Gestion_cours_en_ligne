package fr.utbm.lo54.project.core.service;

import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.entity.repository.CourseSessionDao;
import java.sql.Timestamp;
import java.util.List;

public class CourseSessionService implements IService {
    private final CourseSessionDao courseSessionDao;

    public CourseSessionService() {
        this.courseSessionDao = new CourseSessionDao();
    }
    
    @Override
    public void storeEntity(final IEntity entity) {
        this.courseSessionDao.insertEntity(entity);
    }

    @Override
    public void updateEntity(final Object id, final IEntity entity) {
        this.courseSessionDao.updateEntity(id, entity);
    }

    @Override
    public void removeEntity(final Object id) {
        this.courseSessionDao.removeEntity(id);
    }

    @Override
    public IEntity getEntity(final Object id) {
        return this.courseSessionDao.getEntity(id);
    }

    @Override
    public List<IEntity> getEntities() {
        return this.courseSessionDao.getEntities();
    }
    
    public List<IEntity> getEntitiesByTitle(final String filter) {
        return this.courseSessionDao.getEntitiesByTitle(filter);
    }
    
    public List<IEntity> getEntitiesByLocation(final String filter) {
        return this.courseSessionDao.getEntitiesByLocation(filter);
    }
    
    public List<IEntity> getEntitiesByTimeStamp(final Timestamp tmin, final Timestamp tmax) {
        return this.courseSessionDao.getEntitiesByTimeStamp(tmin, tmax);
    }
}
