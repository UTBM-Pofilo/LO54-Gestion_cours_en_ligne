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
import fr.utbm.lo54.project.core.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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
        final Session session = HibernateUtil.getSession();
        IEntity entity = null;
        try {
            session.beginTransaction();
            entity = (IEntity) session.get(Client.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.err.println(e);
        } 
        return entity;
    }

    @Override
    public List<IEntity> getEntities() {
        String clazz = this.getClass().getSimpleName();
        clazz = clazz.substring(0, clazz.lastIndexOf("Dao"));
        return DefaultDao.getEntities(clazz);
    }
    
}
