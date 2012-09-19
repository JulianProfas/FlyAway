/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author user
 */
public class Flight {


    public static final String FlightDateFormat = "dd-MM-yyyy";
    
    private Date date = new Date();
    private Airport destination = null;
    private Airport From = null;
    private int number;
    private ArrayList<Staff> otherPersonal = new ArrayList<Staff>();
    private ArrayList<Airport> stops = new ArrayList<Airport>();
    private Staff[] Pilots = new Staff[2];
    private Plane plane = null;
    private int returnFlight;


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
    public ArrayList<Staff> getOtherPersonal() {
        return otherPersonal;
    }

    /**
     * Set the value of otherPersonal
     *
     * @param otherPersonal new value of otherPersonal
     */
    public void setOtherPersonal(ArrayList<Staff> otherPersonal) {
        this.otherPersonal = otherPersonal;
    }


        /**
     * Get the value of stops
     *
     * @return the value of stops
     */
    public ArrayList<Airport> getStops() {
        return stops;
    }

    /**
     * Set the value of stops
     *
     * @param otherPersonal new value of stops
     */
    public void setStops(ArrayList<Airport> stops) {
        this.stops = stops;
    }


    /**
     * Get the value of Pilots
     *
     * @return the value of Pilots
     */
    public Staff[] getPilots() {
        return Pilots;
    }

    /**
     * Set the value of Pilots
     *
     * @param Pilots new value of Pilots
     */
    public void setPilots(Staff[] Pilots) {
        this.Pilots = Pilots;
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
    
    public int getReturnFlight() {
        return returnFlight;
    }
    
    public void setReturnFlight(int returnFlight){
        this.returnFlight = returnFlight;
    }
}
