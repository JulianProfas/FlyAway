/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Patrick
 */
public class AirMarshall extends Staff implements java.io.Serializable{
    private int weaponNumber;
    private Nationality nationality;

    public AirMarshall() {
    }
    
    public AirMarshall(int badgeNumber, Nationality nationality) {
	
		this.weaponNumber = badgeNumber;
		this.nationality = nationality;
    }

	public AirMarshall(int weaponNumber, Nationality nationality, int number, PersonalType type, String name, Airport primaryAirport) {
		super(number, type, name, primaryAirport);
		this.weaponNumber = weaponNumber;
		this.nationality = nationality;
	}

	
	public void fillStaff(Staff s){
		this.setName(s.getName());
		this.setNumber(s.getNumber());
		this.setPrimaryAirport(s.getPrimaryAirport());
		this.setType(s.getType());
	}
	
	public int getWeaponNumber() {
		return weaponNumber;
	}

	public void setWeaponNumber(int weaponNumber) {
		this.weaponNumber = weaponNumber;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

    @Override
    public String toString() {
        return super.getName();
    }
}