package fr.utbm.lo54.project.core.entity;

/**
 * Course generated by hbm2java
 */
public class Course  implements java.io.Serializable {

     private String code;
     private String title;

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

}

