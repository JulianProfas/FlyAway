package Model;

import java.util.HashSet;
import java.util.Set;

public class Country implements java.io.Serializable {

    private String countrycode;
    private int regioncode;
    private String name;
    private Set airports = new HashSet(0);

    public Country() {
    }

    public Country(String countrycode, int regioncode, String name) {
        this.countrycode = countrycode;
        this.regioncode = regioncode;
        this.name = name;
    }

    public Country(String countrycode, int regioncode, String name, Set airports) {
        this.countrycode = countrycode;
        this.regioncode = regioncode;
        this.name = name;
        this.airports = airports;
    }

    public String getCountrycode() {
        return this.countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public int getRegioncode() {
        return this.regioncode;
    }

    public void setRegioncode(int regioncode) {
        this.regioncode = regioncode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getAirports() {
        return this.airports;
    }

    public void setAirports(Set airports) {
        this.airports = airports;
    }
    
    @Override
    public String toString ()
    {
    return "" + this.getName();
    }
}
