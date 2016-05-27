package fr.utbm.lo54.project.core.entity.repository;

import fr.utbm.lo54.project.core.entity.IEntity;
import java.util.List;

public interface IDao {
    
    /**
     * To insert an entity into the database
     * @param entity 
     */
    void insertEntity(final IEntity entity);

    /**
     * To update an entity into the database
     * @param entity 
     */
    void updateEntity(final IEntity entity);
    
    /**
     * To remove an entity into the database
     * @param entity 
     */
    void removeEntity(final IEntity entity);
    
    /**
     * To get an entity from an id
     * @param id
     * @return 
     */
    IEntity getEntity(final int id);

    
    /**
     * To get all the entities
     * @return 
     */
    List<IEntity> getEntities();

}
