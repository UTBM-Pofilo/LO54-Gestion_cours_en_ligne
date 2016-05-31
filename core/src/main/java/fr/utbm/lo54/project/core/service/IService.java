package fr.utbm.lo54.project.core.service;

import fr.utbm.lo54.project.core.entity.IEntity;
import java.util.List;

public interface IService<T> {
    /**
     * To store an entity
     * @param entity 
     */
    void storeEntity(final IEntity entity);

    /**
     * To update an entity
     * @param id
     * @param entity 
     */
    void updateEntity(final T id, final IEntity entity);
    
    /**
     * To remove an entity
     * @param id 
     */
    void removeEntity(final T id);
    
    /**
     * To get an entity by his id
     * @param id
     * @return 
     */
    IEntity getEntity(final T id);
    
    /**
     * To get the list of entities
     * @return 
     */
    List<IEntity> getEntities();
}
