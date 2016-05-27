package fr.utbm.lo54.project.core.entity;

import java.io.Serializable;

public class Course  implements Serializable, IEntity {

    private String code;
    private String title;

    public Course() {
    }

    public Course(final String code, final String title) {
       this.code = code;
       this.title = title;
    }
   
    public String getCode() {
        return this.code;
    }
    
    public void setCode(final String code) {
        this.code = code;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Course{");
        builder.append("title=").append(title);
        builder.append(", code=").append(code);
        builder.append("}");
        return builder.toString();
    }
}
