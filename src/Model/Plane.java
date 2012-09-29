package Model;

import java.util.HashSet;
import java.util.Set;

/**
 * Plane generated by hbm2java
 */
public class Plane implements java.io.Serializable {

    private Integer planenumber;
    private int capacity;
    private String type;
    private Set flights = new HashSet(0);

    public Plane() {
    }

    public Plane(int capacity, String type) {
        this.capacity = capacity;
        this.type = type;
    }

    public Plane(int capacity, String type, Set flights) {
        this.capacity = capacity;
        this.type = type;
        this.flights = flights;
    }

    public Integer getPlanenumber() {
        return this.planenumber;
    }

    public void setPlanenumber(Integer planenumber) {
        this.planenumber = planenumber;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set getFlights() {
        return this.flights;
    }

    public void setFlights(Set flights) {
        this.flights = flights;
    }
    
    @Override
    public String toString ()
    {
    return "" + this.getType();
    }
}
