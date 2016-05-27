package fr.utbm.lo54.project.core;

import fr.utbm.lo54.project.core.entity.Client;
import fr.utbm.lo54.project.core.entity.Course;
import fr.utbm.lo54.project.core.entity.CourseSession;
import fr.utbm.lo54.project.core.entity.IEntity;
import fr.utbm.lo54.project.core.entity.Location;
import fr.utbm.lo54.project.core.entity.repository.ClientDao;
import fr.utbm.lo54.project.core.entity.repository.CourseDao;
import fr.utbm.lo54.project.core.entity.repository.CourseSessionDao;
import fr.utbm.lo54.project.core.entity.repository.LocationDao;
import java.sql.Timestamp;
import java.util.Calendar;
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

        for (IEntity entity : listLocation) {
            Location location2 = (Location) entity;
            LOGGER.info("--> " + location2.toString());
            LOGGER.info("kkkkkkkkkkkkkkkkkkkkkkkk -> " + location2.getId());
        }

        /////////////////////////////////////////////////////////
        CourseDao courseDao = new CourseDao();
        Course course = new Course("LC00", "Chinois");
        // courseDao.insertEntity(course);

        LOGGER.info("course: " + courseDao.getEntity("LO54").toString());

        List<IEntity> listCourse = courseDao.getEntities();
        for (IEntity entity : listCourse) {
            Course course2 = (Course) entity;
            LOGGER.info("--> " + course2.toString());
        }

        /////////////////////////////////////////////////////////
        CourseSessionDao courseSessionDao = new CourseSessionDao();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2016);
        calendar.set(Calendar.MONTH, Calendar.MAY);
        calendar.set(Calendar.DAY_OF_MONTH, 24);
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Timestamp startDate = new Timestamp(calendar.getTimeInMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 16);
        Timestamp endDate = new Timestamp(calendar.getTimeInMillis());
        
        CourseSession courseSession = new CourseSession(startDate, endDate, (Course) courseDao.getEntity("LO54"), (Location) locationDao.getEntity(2));
        //courseSessionDao.insertEntity(courseSession);
        CourseSession courseSession2 = (CourseSession) courseSessionDao.getEntity(1);
        //LOGGER.info("@@@@@@@@@@> courseSession: " + courseSession2);
        
        List<IEntity> listCourseSession = courseSessionDao.getEntities();
        for (IEntity entity : listCourseSession) {
            CourseSession courseSession3 = (CourseSession) entity;
            LOGGER.info("|||--> " + courseSession3.toString());
        }
        
        ///////////////////////////////////////////////////////////////
        ClientDao clientDao = new ClientDao();
        Client client = new Client("LAST", "FIRST", "La-bas", "06xxxxxx", "ici@la.bas", courseSession2);
        
        //clientDao.insertEntity(client);
        
        //LOGGER.info("1111111111111111CLIENT: " + clientDao.getEntity(2));
        
        List<IEntity> listClient = clientDao.getEntities();
        for (IEntity entity : listClient) {
            Client client2 = (Client) entity;
            LOGGER.info("°°°°°°--> " + client2.toString());
        }
        
        ///////////////////////////////////////////////////////////////
        
        
        List<IEntity> listFilter = courseSessionDao.getEntitiesByLocation("Les Auxons");
        for (IEntity entity : listFilter) {
            CourseSession course3 = (CourseSession) entity;
            LOGGER.info("€€€€€€€€€€€€€€€€€ --> " + course3.toString());
        }
        
        
        
        
        LOGGER.info("\n\n\n\nOK");

    }
}
