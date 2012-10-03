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
    private Airport destination;
    private Airport From;
    private int number;
    private List<Staff> otherPersonal;
    private List<Airport> stops;
    private Staff pilot;
	private Staff copilot;
    private Plane plane;
    private Flight returnFlight;

	public Flight() {
	}

	
	public Flight(Airport destination, Airport From, int number, List<Staff> otherPersonal, List<Airport> stops, Staff pilot, Staff copilot, Plane plane) {
		this.destination = destination;
		this.From = From;
		this.number = number;
		this.otherPersonal = otherPersonal;
		this.stops = stops;
		this.pilot = pilot;
		this.copilot = copilot;
		this.plane = plane;
		//this.returnFlight = returnFlight;
	}

	
	
    /**
     * Get the value of date
     *
     * @return the value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the value of date
     *
     * @param date new value of date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get the value of plane
     *
     * @return the value of plane
     */
    public Plane getPlane() {
        return plane;
    }

    /**
     * Set the value of plane
     *
     * @param plane new value of plane
     */
    public void setPlane(Plane plane) {
        this.plane = plane;
    }


    /**
     * Get the value of From
     *
     * @return the value of From
     */
    public Airport getFrom() {
        return From;
    }

    /**
     * Set the value of From
     *
     * @param From new value of From
     */
    public void setFrom(Airport From) {
        this.From = From;
    }


    /**
     * Get the value of destination
     *
     * @return the value of destination
     */
    public Airport getDestination() {
        return destination;
    }

    /**
     * Set the value of destination
     *
     * @param destination new value of destination
     */
    public void setDestination(Airport destination) {
        this.destination = destination;
    }



    /**
     * Get the value of otherPersonal
     *
     * @return the value of otherPersonal
     */
    public List<Staff> getOtherPersonal() {
        return otherPersonal;
    }

    /**
     * Set the value of otherPersonal
     *
     * @param otherPersonal new value of otherPersonal
     */
    public void setOtherPersonal(List<Staff> otherPersonal) {
        this.otherPersonal = otherPersonal;
    }


        /**
     * Get the value of stops
     *
     * @return the value of stops
     */
    public List<Airport> getStops() {
        return stops;
    }

    /**
     * Set the value of stops
     *
     * @param otherPersonal new value of stops
     */
    public void setStops(List<Airport> stops) {
        this.stops = stops;
    }

	public Staff getCopilot() {
		return copilot;
	}

	public void setCopilot(Staff copilot) {
		this.copilot = copilot;
	}

	public Staff getPilot() {
		return pilot;
	}

	public void setPilot(Staff pilot) {
		this.pilot = pilot;
	}


   
    /**
     * Get the value of number
     *
     * @return the value of number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Set the value of number
     *
     * @param number new value of number
     */
    public void setNumber(int number) {
        this.number = number;
    }
    
    public Flight getReturnFlight() {
        return returnFlight;
    }
    
    public void setReturnFlight(Flight returnFlight){
        this.returnFlight = returnFlight;
    }
	
	@Override
	public String toString(){
		return "" + this.getNumber();
	}
}
