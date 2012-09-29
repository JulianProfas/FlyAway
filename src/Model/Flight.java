package Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Flight implements java.io.Serializable {

    private Integer flightnumber;
    private Airport airportByAirportdestination;
    private Staff staffByPilot;
    private Staff staffByCopilot;
    private Plane plane;
    private Airport airportByAirportfrom;
    private Flight flight;
    private Date date;
    private Set airports = new HashSet(0);
    private Set flights = new HashSet(0);
    private Set staffs = new HashSet(0);

    public Flight() {
    }

    public Flight(Airport airportByAirportdestination, Staff staffByPilot, Staff staffByCopilot, Plane plane, Airport airportByAirportfrom, Date date) {
        this.airportByAirportdestination = airportByAirportdestination;
        this.staffByPilot = staffByPilot;
        this.staffByCopilot = staffByCopilot;
        this.plane = plane;
        this.airportByAirportfrom = airportByAirportfrom;
        this.date = date;
    }

    public Flight(Airport airportByAirportdestination, Staff staffByPilot, Staff staffByCopilot, Plane plane, Airport airportByAirportfrom, Flight flight, Date date, Set airports, Set flights, Set staffs) {
        this.airportByAirportdestination = airportByAirportdestination;
        this.staffByPilot = staffByPilot;
        this.staffByCopilot = staffByCopilot;
        this.plane = plane;
        this.airportByAirportfrom = airportByAirportfrom;
        this.flight = flight;
        this.date = date;
        this.airports = airports;
        this.flights = flights;
        this.staffs = staffs;
    }

    public Integer getFlightnumber() {
        return this.flightnumber;
    }

    public void setFlightnumber(Integer flightnumber) {
        this.flightnumber = flightnumber;
    }

    public Airport getAirportByAirportdestination() {
        return this.airportByAirportdestination;
    }

    public void setAirportByAirportdestination(Airport airportByAirportdestination) {
        this.airportByAirportdestination = airportByAirportdestination;
    }

    public Staff getStaffByPilot() {
        return this.staffByPilot;
    }

    public void setStaffByPilot(Staff staffByPilot) {
        this.staffByPilot = staffByPilot;
    }

    public Staff getStaffByCopilot() {
        return this.staffByCopilot;
    }

    public void setStaffByCopilot(Staff staffByCopilot) {
        this.staffByCopilot = staffByCopilot;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Airport getAirportByAirportfrom() {
        return this.airportByAirportfrom;
    }

    public void setAirportByAirportfrom(Airport airportByAirportfrom) {
        this.airportByAirportfrom = airportByAirportfrom;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set getAirports() {
        return this.airports;
    }

    public void setAirports(Set airports) {
        this.airports = airports;
    }

    public Set getFlights() {
        return this.flights;
    }

    public void setFlights(Set flights) {
        this.flights = flights;
    }

    public Set getStaffs() {
        return this.staffs;
    }

    public void setStaffs(Set staffs) {
        this.staffs = staffs;
    }
    
    @Override
    public String toString ()
    {
    return "" + this.getFlightnumber();
    }
}