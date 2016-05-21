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

import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultDao {
    
    private final static Logger LOGGER = LoggerFactory
			.getLogger(DefaultDao.class);
    
    /**
     * To insert an entity into the database
     * @param entity 
     */
    public static void insertEntity(final IEntity entity) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        } catch(HibernateException e) {
            LOGGER.error("Insertion of entity: " + e);
        }
    }

    /**
     * To update an entity into the database
     * @param entity 
     */
    public static void updateEntity(final IEntity entity) {
        
    }
    
    /**
     * To remove an entity into the database
     * @param entity 
     */
    public static void removeEntity(final IEntity entity) {
        final Session session = HibernateUtil.getSession();
        session.delete(entity);
    }
    
    /**
     * To get all the entities
     * @return 
     */
    public static List<IEntity> getEntities(String entity) {
        final Session session = HibernateUtil.getSession();
        List<IEntity> listEntities = null;
        try {
            Query query = session.createQuery("from " + entity);
            listEntities = query.list();
        }catch (HibernateException e) {
            LOGGER.error("getEntities" + e);
        } 
        return listEntities;
    }
    
    
}
