package fr.utbm.lo54.project.core.repository;

import fr.utbm.lo54.project.core.entity.IEntity;
import java.util.List;

public interface IDao<T> {
    
    /**
     * To insert an entity into the database
     * @param entity 
     */
    void insertEntity(final IEntity entity);

    /**
     * To update an entity into the database
     * @param id
     * @param entity 
     */
    void updateEntity(final T id, final IEntity entity);
    
    /**
     * To remove an entity into the database
     * @param id 
     */
    void removeEntity(final T id);
    
    /**
     * To get an entity from an id
     * @param id
     * @return 
     */
    IEntity getEntity(final T id);

    
    /**
     * To get all the entities
     * @return 
     */
    List<IEntity> getEntities();

}
