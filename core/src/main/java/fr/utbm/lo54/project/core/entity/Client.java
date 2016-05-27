package fr.utbm.lo54.project.core.entity;

import java.io.Serializable;

public class Client  implements Serializable, IEntity {

     private int id;
     private String lastName;
     private String firstName;
     private String address;
     private String phone;
     private String email;
     private CourseSession courseSession;

    public Client() {
    }

    public Client(final String lastName, final String firstName, final String address, final String phone, final String email, final CourseSession courseSession) {
       this.lastName = lastName;
       this.firstName = firstName;
       this.address = address;
       this.phone = phone;
       this.email = email;
       this.courseSession = courseSession;
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(final String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    public CourseSession getCourseSession() {
        return this.courseSession;
    }
    
    public void setCourseSession(final CourseSession courseSession) {
        this.courseSession = courseSession;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Client{");
        builder.append("id=").append(id);
        builder.append(", lastName=").append(lastName);
        builder.append(", firstName=").append(firstName);
        builder.append(", address=").append(address);
        builder.append(", phone=").append(phone);
        builder.append(", email=").append(email);
        builder.append(", courseSession=").append(courseSession.toString());
        builder.append("}");
        return builder.toString();
    }
}
