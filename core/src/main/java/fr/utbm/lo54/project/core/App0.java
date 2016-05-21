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
package fr.utbm.lo54.project.core;

import fr.utbm.lo54.project.core.entity.Course;
import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.entity.Location;
import fr.utbm.lo54.project.core.entity.repository.CourseDao;
import fr.utbm.lo54.project.core.entity.repository.LocationDao;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App0 {
    private final static Logger LOGGER = LoggerFactory
			.getLogger(App0.class);
    
    public static void main(String[] args) {
        
        LocationDao locationDao = new LocationDao();
        Location location = new Location("Paris");
        //locationDao.insertEntity(location);
        //LOGGER.info("location: " + locationDao.getEntity(2).toString());
        
        List<IEntity> listLocation = locationDao.getEntities();
        
        for(IEntity entity : listLocation) {
            Location location2 = (Location) entity;
            LOGGER.info("--> " + location2.toString());
        }
        
        
        /////////////////////////////////////////////////////////
        
        CourseDao courseDao = new CourseDao();
        Course course = new Course("LC00", "Chinois");
        // courseDao.insertEntity(course);
        
        LOGGER.info("course: " + courseDao.getEntity("LO54").toString());
        
        List<IEntity> listCourse = courseDao.getEntities();
        for(IEntity entity : listCourse) {
            Course course2 = (Course) entity;
            LOGGER.info("--> " + course2.toString());
        }
        
        /////////////////////////////////////////////////////////
        
        // TODO: tester courseSession et client
        
        LOGGER.info("\n\n\n\nOK");
    
    }
}
