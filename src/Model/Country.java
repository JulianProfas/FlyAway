/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author julianprofas
 */
public class Country {

    private String countryCode;
    private int regionCode;
    private String name;

	public Country() {
		
	}

	public Country(String countryCode, int regionCode, String name) {
		this.countryCode = countryCode;
		this.regionCode = regionCode;
		this.name = name;
	}

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    public int getRegionCode() {
        return regionCode;
    }
    
    public void setRegionCode(int regionCode) {
        this.regionCode = regionCode;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
 @Override
    public String toString(){
        return "" + name;
    }   
}
