package fr.utbm.lo54.project.core.service;

import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.entity.repository.LocationDao;
import java.util.List;

public class LocationService implements IService {
    private final LocationDao locationDao;

    public LocationService() {
        this.locationDao = new LocationDao();
    }
    
    @Override
    public void storeEntity(IEntity entity) {
        this.locationDao.insertEntity(entity);
    }

    @Override
    public void updateEntity(IEntity entity) {
        this.locationDao.updateEntity(entity);
    }

    @Override
    public void removeEntity(IEntity entity) {
        this.locationDao.removeEntity(entity);
    }

    @Override
    public IEntity getEntity(int id) {
        return this.locationDao.getEntity(id);
    }

    @Override
    public List<IEntity> getEntities() {
        return this.locationDao.getEntities();
    }
}
