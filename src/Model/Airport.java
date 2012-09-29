package Model;

import java.util.HashSet;
import java.util.Set;

public class Airport implements java.io.Serializable {

    private String airportcode;
    private Country country;
    private String name;
    private String city;
    private Set flightsForAirportdestination = new HashSet(0);
    private Set staffs = new HashSet(0);
    private Set flights = new HashSet(0);
    private Set flightsForAirportfrom = new HashSet(0);

    public Airport() {
    }

    public Airport(String airportcode, Country country, String name, String city) {
        this.airportcode = airportcode;
        this.country = country;
        this.name = name;
        this.city = city;
    }

    public Airport(String airportcode, Country country, String name, String city, Set flightsForAirportdestination, Set staffs, Set flights, Set flightsForAirportfrom) {
        this.airportcode = airportcode;
        this.country = country;
        this.name = name;
        this.city = city;
        this.flightsForAirportdestination = flightsForAirportdestination;
        this.staffs = staffs;
        this.flights = flights;
        this.flightsForAirportfrom = flightsForAirportfrom;
    }

    public String getAirportcode() {
        return this.airportcode;
    }

    public void setAirportcode(String airportcode) {
        this.airportcode = airportcode;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set getFlightsForAirportdestination() {
        return this.flightsForAirportdestination;
    }

    public void setFlightsForAirportdestination(Set flightsForAirportdestination) {
        this.flightsForAirportdestination = flightsForAirportdestination;
    }

    public Set getStaffs() {
        return this.staffs;
    }

    public void setStaffs(Set staffs) {
        this.staffs = staffs;
    }

    public Set getFlights() {
        return this.flights;
    }

    public void setFlights(Set flights) {
        this.flights = flights;
    }

    public Set getFlightsForAirportfrom() {
        return this.flightsForAirportfrom;
    }

    public void setFlightsForAirportfrom(Set flightsForAirportfrom) {
        this.flightsForAirportfrom = flightsForAirportfrom;
    }
    
    @Override
    public String toString ()
    {
    return "" + this.name;
    }
}