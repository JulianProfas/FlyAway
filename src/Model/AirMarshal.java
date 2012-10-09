/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Patrick
 */
public class AirMarshal extends Staff {
    int badgeNumber;
    String nationality;

    public AirMarshal() {
    }
    
    public AirMarshal(int badgeNumber, String nationality, int number, PersonalType type, String name, Airport primaryAirport) {
	super(number, type, name, primaryAirport);
	this.badgeNumber = badgeNumber;
	this.nationality = nationality;
    }

    public int getBadgeNumber() {
	return badgeNumber;
    }

    public void setBadgeNumber(int badgeNumber) {
	this.badgeNumber = badgeNumber;
    }

    public String getNationality() {
	return nationality;
    }

    public void setNationality(String nationality) {
	this.nationality = nationality;
    }
    
    @Override
    public String toString() {
        return super.getName();
    }
}