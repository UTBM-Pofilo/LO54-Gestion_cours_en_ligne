package fr.utbm.lo54.project.core.repository;

import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.entity.Location;
import java.util.List;

public class LocationDao implements IDao {

    @Override
    public void insertEntity(final IEntity entity) {
        DefaultDao.insertEntity(entity);
    }

    @Override
    public void updateEntity(final Object id, final IEntity entity) {
        DefaultDao.updateEntity((int) id, Location.class.getCanonicalName(), entity);
    }

    @Override
    public void removeEntity(final Object id) {
        DefaultDao.removeEntity((int) id, LocationDao.class.getCanonicalName());
    }

    @Override
    public IEntity getEntity(final Object id) {
        return DefaultDao.getEntity((int) id, Location.class.getCanonicalName());
    }

    @Override
    public List<IEntity> getEntities() {
        return DefaultDao.getEntities(Location.class.getCanonicalName());
    }
}
