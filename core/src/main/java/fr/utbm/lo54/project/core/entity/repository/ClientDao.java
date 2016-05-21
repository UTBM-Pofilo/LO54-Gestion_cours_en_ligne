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
package fr.utbm.lo54.project.core.entity.repository;

import fr.utbm.lo54.project.core.entity.Client;
import fr.utbm.lo54.project.core.entity.IEntity;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientDao implements IDao{

    private final static Logger LOGGER = LoggerFactory
			.getLogger(ClientDao.class);
    
    @Override
    public void insertEntity(final IEntity entity) {
        DefaultDao.insertEntity(entity);
    }

    @Override
    public void updateEntity(final IEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeEntity(final IEntity entity) {
        DefaultDao.removeEntity(entity);
    }

    @Override
    public IEntity getEntity(final int id) {
        return DefaultDao.getEntity(id, Client.class.getCanonicalName());
    }

    @Override
    public List<IEntity> getEntities() {
        return DefaultDao.getEntities(Client.class.getCanonicalName());
    }
    
}
