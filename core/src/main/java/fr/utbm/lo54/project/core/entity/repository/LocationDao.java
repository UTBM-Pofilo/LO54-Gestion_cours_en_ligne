package fr.utbm.lo54.project.core.entity.repository;

import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.entity.Location;
import java.util.List;

public class LocationDao implements IDao {

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
        return DefaultDao.getEntity(id, Location.class.getCanonicalName());
    }

    @Override
    public List<IEntity> getEntities() {
        return DefaultDao.getEntities(Location.class.getCanonicalName());
    }
}
