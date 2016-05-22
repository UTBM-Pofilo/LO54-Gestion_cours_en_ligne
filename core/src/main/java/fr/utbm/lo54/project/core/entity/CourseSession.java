package fr.utbm.lo54.project.core.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class CourseSession  implements Serializable, IEntity {

     private int id;
     private Timestamp startDate;
     private Timestamp endDate;
     private Course course;
     private Location location;

    public CourseSession() {
    }

    public CourseSession(Timestamp startDate, Timestamp endDate, Course course, Location location) {
       this.startDate = startDate;
       this.endDate = endDate;
       this.course = course;
       this.location = location;
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Timestamp getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }
    public Timestamp getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    public Location getLocation() {
        return this.location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CourseSession{");
        builder.append("id=").append(id);
        builder.append(", startDate=").append(startDate);
        builder.append(", endDate=").append(endDate);
        builder.append(", course=").append(course.toString());
        builder.append(", location=").append(location.toString());
        builder.append("}");
        return builder.toString();
    }
}
