package fr.utbm.lo54.project.core.repository;

import fr.utbm.lo54.project.core.entity.Client;
import fr.utbm.lo54.project.core.entity.IEntity;
import java.util.List;

public class ClientDao implements IDao{
    
    @Override
    public void insertEntity(final IEntity entity) {
        DefaultDao.insertEntity(entity);
    }

    @Override
    public void updateEntity(final Object id, final IEntity entity) {
        DefaultDao.updateEntity((int) id, Client.class.getCanonicalName(), entity);
    }

    @Override
    public void removeEntity(final Object id) {
        DefaultDao.removeEntity((int) id, Client.class.getCanonicalName());
    }

    @Override
    public IEntity getEntity(final Object id) {
        return DefaultDao.getEntity((int) id, Client.class.getCanonicalName());
    }

    @Override
    public List<IEntity> getEntities() {
        return DefaultDao.getEntities(Client.class.getCanonicalName());
    }
}
