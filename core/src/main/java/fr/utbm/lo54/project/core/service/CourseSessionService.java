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
import fr.utbm.lo54.project.core.entity.repository.CourseSessionDao;
import java.util.List;

public class CourseSessionService implements IService {
    private final CourseSessionDao courseSessionDao;

    public CourseSessionService() {
        this.courseSessionDao = new CourseSessionDao();
    }
    
    @Override
    public void storeEntity(IEntity entity) {
        this.courseSessionDao.insertEntity(entity);
    }

    @Override
    public void updateEntity(IEntity entity) {
        this.courseSessionDao.updateEntity(entity);
    }

    @Override
    public void removeEntity(IEntity entity) {
        this.courseSessionDao.removeEntity(entity);
    }

    @Override
    public IEntity getEntity(int id) {
        return this.courseSessionDao.getEntity(id);
    }

    @Override
    public List<IEntity> getEntities() {
        return this.courseSessionDao.getEntities();
    }
}
