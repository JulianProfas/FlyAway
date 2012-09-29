package Model;

import java.util.HashSet;
import java.util.Set;

public class Staff implements java.io.Serializable {

    private Integer staffnumber;
    private Airport airport;
    private String name;
    private String type;
    private Set users = new HashSet(0);
    private Set flightsForCopilot = new HashSet(0);
    private Set flightsForPilot = new HashSet(0);
    private Set flights = new HashSet(0);

    public Staff() {
    }

    public Staff(Airport airport, String name, String type) {
        this.airport = airport;
        this.name = name;
        this.type = type;
    }

    public Staff(Airport airport, String name, String type, Set users, Set flightsForCopilot, Set flightsForPilot, Set flights) {
        this.airport = airport;
        this.name = name;
        this.type = type;
        this.users = users;
        this.flightsForCopilot = flightsForCopilot;
        this.flightsForPilot = flightsForPilot;
        this.flights = flights;
    }

    public Integer getStaffnumber() {
        return this.staffnumber;
    }

    public void setStaffnumber(Integer staffnumber) {
        this.staffnumber = staffnumber;
    }

    public Airport getAirport() {
        return this.airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set getUsers() {
        return this.users;
    }

    public void setUsers(Set users) {
        this.users = users;
    }

    public Set getFlightsForCopilot() {
        return this.flightsForCopilot;
    }

    public void setFlightsForCopilot(Set flightsForCopilot) {
        this.flightsForCopilot = flightsForCopilot;
    }

    public Set getFlightsForPilot() {
        return this.flightsForPilot;
    }

    public void setFlightsForPilot(Set flightsForPilot) {
        this.flightsForPilot = flightsForPilot;
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
    return "" + this.getName();
    }
}