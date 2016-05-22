package fr.utbm.lo54.project.core.entity.repository;

import fr.utbm.lo54.project.core.entity.CourseSession;
import fr.utbm.lo54.project.core.entity.IEntity;
import java.util.List;

public class CourseSessionDao implements IDao {

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

    @Override
    public IEntity getEntity(int id) {
        return DefaultDao.getEntity(id, CourseSession.class.getCanonicalName());
    }

    @Override
    public List<IEntity> getEntities() {
        return DefaultDao.getEntities(CourseSession.class.getCanonicalName());
    }
}
