/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author user
 */
public class Staff {

    public enum PersonalType{
        Pilot,
        Stewardess
    }

     private int number;
     private PersonalType type;
     private String name;
     private String primaryairport;

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public PersonalType getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(PersonalType type) {
        this.type = type;
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
   

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrimaryAirport(String primaryairport) {
        this.primaryairport = primaryairport;
    }
    
    public String getPrimaryAirport() {
        return primaryairport;
    }

    @Override
    public String toString(){
        return this.number + " "+this.name+ " : "+ this.type + " : " + this.primaryairport;
    }
}
