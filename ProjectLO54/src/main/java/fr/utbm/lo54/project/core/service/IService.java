/*
 * Copyright (C) 2016
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.utbm.lo54.project.core.service;

import fr.utbm.lo54.project.core.entity.IEntity;

/**
 *
 * @author Vincent
 */
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
    
    // TODO: not sure about this parameter
    IEntity getEntity(final int id);
}
