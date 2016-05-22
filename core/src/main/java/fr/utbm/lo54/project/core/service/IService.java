package fr.utbm.lo54.project.core.service;

import fr.utbm.lo54.project.core.entity.IEntity;
import java.util.List;

public interface IService {
    /**
     * To store an entity
     * @param entity 
     */
    void storeEntity(final IEntity entity);

    /**
     * To update an entity
     * @param entity 
     */
    void updateEntity(final IEntity entity);
    
    /**
     * To remove an entity
     * @param entity 
     */
    void removeEntity(final IEntity entity);
    
    /**
     * To get an entity by his id
     * @param id
     * @return 
     */
    IEntity getEntity(final int id);
    
    List<IEntity> getEntities();
}
