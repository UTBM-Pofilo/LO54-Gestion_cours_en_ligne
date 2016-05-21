package fr.utbm.lo54.project.core.entity;

import java.io.Serializable;

/**
 * Course generated by hbm2java
 */
public class Course  implements Serializable, IEntity {

     private String code;
     private String title;
     private int id;

    public Course() {
    }

    public Course(String code, String title) {
       this.code = code;
       this.title = title;
    }
   
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Course{");
        builder.append("id=").append(id);
        builder.append(", title=").append(title);
        builder.append(", code=").append(code);
        return builder.toString();
    }
    
    
    
}

