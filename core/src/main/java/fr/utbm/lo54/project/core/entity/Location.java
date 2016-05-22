package fr.utbm.lo54.project.core.entity;

import java.io.Serializable;

public class Location  implements Serializable, IEntity {

    private int id;
    private String city;

    public Location() {
    }

    public Location(String city) {
       this.city = city;
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Location{");
        builder.append("id=").append(id);
        builder.append(", city=").append(city);
        builder.append("}");
        return builder.toString();
    }
}
