package fr.utbm.lo54.project.core.service;

import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.entity.repository.ClientDao;
import java.util.List;

public class ClientService implements IService {

    private final ClientDao clientDao;

    public ClientService() {
        this.clientDao = new ClientDao();
    }
    
    @Override
    public void storeEntity(IEntity entity) {
        this.clientDao.insertEntity(entity);
    }

    @Override
    public void updateEntity(IEntity entity) {
        this.clientDao.updateEntity(entity);
    }

    @Override
    public void removeEntity(IEntity entity) {
        this.clientDao.removeEntity(entity);
    }

    @Override
    public IEntity getEntity(int id) {
        return this.clientDao.getEntity(id);
    }

    @Override
    public List<IEntity> getEntities() {
        return this.clientDao.getEntities();
    }
}
