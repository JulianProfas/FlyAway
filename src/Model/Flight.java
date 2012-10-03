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
public class Flight implements java.io.Serializable{

    public static final String FlightDateFormat = "dd-MM-yyyy";
    
    private Date date = new Date();
    private Airport destination = null;
    private Airport From = null;
    private int number = -1;
    private List<Staff> otherPersonal = new ArrayList<Staff>();
    private List<Airport> stops = new ArrayList<Airport>();
    private Staff pilot = null;
	private Staff copilot = null;
    private Plane plane = null;
    private Flight returnFlight = null;

	public Flight() {
	}

	
	public Flight(Airport destination, Airport From, int number, List<Staff> otherPersonal, List<Airport> stops, Staff pilot, Staff copilot, Plane plane,Flight returnFlight) {
		this.destination = destination;
		this.From = From;
		this.number = number;
		this.otherPersonal = otherPersonal;
		this.stops = stops;
		this.pilot = pilot;
		this.copilot = copilot;
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

	public List<Staff> getOtherPersonal() {
		return otherPersonal;
	}

	public void setOtherPersonal(List<Staff> otherPersonal) {
		this.otherPersonal = otherPersonal;
	}

	public Staff getPilot() {
		return pilot;
	}

	public void setPilot(Staff pilot) {
		this.pilot = pilot;
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
	public String toString(){
		return "" + this.getNumber();
	}
}
