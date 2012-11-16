/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class Flight implements java.io.Serializable {

    public static final String FlightDateFormat = "dd-MM-yyyy";
    private Date date = new Date();
    private Airport destination = null;
    private Airport From = null;
    private int number = -1;
    private List<Staff> otherPersonnel = new ArrayList<Staff>();
    private List<Airport> stops = new ArrayList<Airport>();
    private Staff pilot = null;
    private Staff copilot = null;
    private Staff purser = null;
    private Plane plane = null;
    private Flight returnFlight = null;

    public Flight() {
    }

    public Flight(Date date, Airport destination, Airport From, int number, List<Staff> otherPersonnel, List<Airport> stops, Staff pilot, Staff copilot, Staff purser, Plane plane, Flight returnFlight) {
        this.date = date;
        this.destination = destination;
        this.From = From;
        this.number = number;
        this.otherPersonnel = otherPersonnel;
        this.stops = stops;
        this.pilot = pilot;
        this.copilot = copilot;
	this.purser = purser;
        this.plane = plane;
        this.returnFlight = returnFlight;
    }

    public Airport getFrom() {
        return From;
    }

    public void setFrom(Airport From) {
        this.From = From;
    }

    public Staff getCopilot() {
        return copilot;
    }

    public void setCopilot(Staff copilot) {
        this.copilot = copilot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Staff> getOtherPersonnel() {
        return otherPersonnel;
    }

    public void setOtherPersonnel(List<Staff> otherPersonnel) {
        this.otherPersonnel = otherPersonnel;
    }

    public Staff getPilot() {
        return pilot;
    }

    public void setPilot(Staff pilot) {
        this.pilot = pilot;
    }
    
    public Staff getPurser() {
        return purser;
    }

    public void setPurser(Staff purser) {
        this.purser = purser;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Flight getReturnFlight() {
        return returnFlight;
    }

    public void setReturnFlight(Flight returnFlight) {
        this.returnFlight = returnFlight;
    }

    public List<Airport> getStops() {
        return stops;
    }

    public void setStops(List<Airport> stops) {
        this.stops = stops;
    }

    @Override
    public String toString() {
        return "" + this.getNumber();
    }
}
