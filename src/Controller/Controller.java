/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Database.DatabaseConnectie;
import Model.Airport;
import Model.Flight;
import Model.Staff;
import Model.Plane;
import Model.User;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Observable;



/**
 *
 * @author user
 */
public class Controller extends Observable {

    private static Controller controller = new Controller();


    HashMap<Integer, Plane> planes;
    HashMap<String, Airport> airports;
    HashMap<Integer,Staff> staff;
    HashMap<Integer, Flight> flights;

    HashMap<String, User> users;
    User logedIn;

      private void DBSetup(){
        //Database.DatabaseConnectie.Connect("//localhost:3306/flyaway", "root", "root");
//        Database.DatabaseConnectie.Connect("//mysql04.totaalholding.nl/bohnern_flyaway", "bohnern_flyaway", "FlyAWay");
        
        airports = Database.DatabaseConnectie.getAirports();
        staff = Database.DatabaseConnectie.getStaff();
        planes = Database.DatabaseConnectie.getPlanes();
        //We need to add flights as last.
        flights = Database.DatabaseConnectie.getFlights();
    }

    public void Initialize(){        
        DBSetup();        
    }

    public void ShutDown(){
        
//        if(logedIn != null){
//            if(logedIn.getRank() == User.Rank.admin){//              
//                UserSerializer.writeUsers("users.usr", users);
//            }
//        }
    }

    public boolean Login(String username, String password){
        boolean result = true;
        
        users = Database.DatabaseConnectie.getUsers();
        if(users != null){
            User test = new User();
            test.setPassword(password, true); //hash the password
            test.setUsername(username);
	    
	    System.out.println("Test password: "+test.getPassword());
	    
            User test2 = users.get(username);
	    System.out.println("Test2 password: "+test2.getPassword());
	    
            if(test2 != null){              
                if(test2.getPassword().equals(test.getPassword())){
                    this.logedIn = test2;
                    result = true;
                }
            }
	    this.logedIn = test2;
        }  
	
        return result;
    }

    private Controller(){
        planes = new HashMap<Integer, Plane>();
        airports = new HashMap<String, Airport>();
        staff = new HashMap<Integer, Staff>();
        flights = new HashMap<Integer, Flight>();
        
        //testSetup();
    }


    @Override
    public void notifyObservers(Object o){
          this.setChanged();
          super.notifyObservers(o);
    }

    public static Controller Instance(){
        return controller;
    }

    public ArrayList<Airport> getAirports() {
        ArrayList<Airport> results = new ArrayList<Airport>();

        results.addAll(airports.values());

        return results;
    }

    public ArrayList<Flight> getFlights() {
        ArrayList<Flight> result = new ArrayList<Flight>();
        result.addAll(flights.values());
        return result;
    }

/*	
	public ArrayList<Flight> getScheduledFlights(){
		ArrayList<Flight> result = new ArrayList<Flight>();
		Staff s = this.logedIn.getStaffAccount();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.roll(Calendar.DAY_OF_MONTH, false);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		Date d = c.getTime();

		for(Flight f : flights.values()){
			
			Staff[] pilots = f.getPilots();
			if((pilots[0].getNumber() == s.getNumber() || pilots[1].getNumber() == s.getNumber() || f.getOtherPersonal().contains(s)) && f.getDate().after(d)){
				result.add(f);
			}
		
		}
		
		return result;
		
	}
*/
    public ArrayList<Staff> getStaff() {
        ArrayList<Staff> result = new ArrayList<Staff>();
        result.addAll(staff.values());
        return result;
    }

    public ArrayList<Plane> getPlanes() {

        ArrayList<Plane> result = new ArrayList<Plane>();

        result.addAll(planes.values());
        return result;
    }
/*
    public ArrayList<Plane> SearchPlanes(int number ){
        ArrayList<Plane> foundPlanes = new ArrayList<Plane>();
        for(Plane p : planes.values()){
            if(p.getNumber() == number){                
                foundPlanes.add(p);
            }
        }
        return foundPlanes;
    }
	*/
	/*public int getFlightNumber(){
	
		int result = 0;
		for(Flight f: flights.values()){
			if(f.getNumber() > result){
				result = f.getNumber();
			}
		}
		return result + 1;
	}
	*/
    public Plane getPlaneByNumber(int number){        
       return planes.get(number);
    }

    public ArrayList<Plane> SearchPlanes(String type){
          ArrayList<Plane> foundPlanes = new ArrayList<Plane>();
        for(Plane p : planes.values()){
            if(p.getType().contains(type)){            
               
                foundPlanes.add(p);
            }
        }
        return foundPlanes;
    }

     public ArrayList<Plane> SearchPlanesAvailable(Date d){

         ArrayList<Plane> foundPlanes = new ArrayList<Plane>();
        for(Plane p : planes.values()){
             boolean dontAdd = false;
             for (Flight f : flights.values()) {
                 if (d.getYear() == f.getDate().getYear() && d.getMonth() == f.getDate().getMonth() && d.getDay() == f.getDate().getDay() && f.getPlane() == p) {
                     dontAdd = true;
                 }
             }
             if (!dontAdd) {
                 foundPlanes.add(p);
             }
         }
        return foundPlanes;
    }

   public boolean DeletePlane(Plane planeToRemove) {
        boolean result = false;

        if(DatabaseConnectie.deletePlane(planeToRemove))
        {
            planes.remove(planeToRemove.getPlanenumber());
            result = true;
            notifyObservers(planeToRemove);
        }

        return result;
    }

    public boolean AddPlane(Plane p){
        boolean result = false;

        if(DatabaseConnectie.insertPlane(p))
        {
            planes.put(p.getPlanenumber(), p);
            
             notifyObservers(p);

            result = true;
        }     
       
        return result;
    }

    public boolean ChangePlane(Plane newPlane, Plane oldPlane) {
        boolean result = false;
        if(DatabaseConnectie.updatePlane(newPlane, oldPlane)){
            planes.remove(oldPlane.getPlanenumber());
            oldPlane.setType(newPlane.getType());
            oldPlane.setCapacity(newPlane.getCapacity());
            oldPlane.setPlanenumber(newPlane.getPlanenumber());
            planes.put(oldPlane.getPlanenumber(), oldPlane);
            notifyObservers(oldPlane);
        }
        return result;
    }

    public ArrayList<Staff> SearchStaff(String name) {
        ArrayList<Staff> result = new ArrayList<Staff>();

        for (Staff s : staff.values()) {
            if (s.getName().contains(name)) {
                result.add(s);
            }
        }
        return result;
    }
/*
   public ArrayList<Staff> SearchStaff(Staff.PersonalType st) {
        ArrayList<Staff> result = new ArrayList<Staff>();

        for (Staff s : staff.values()) {
            if (s.getType().equals(st)) {
                result.add(s);
            }
        }
        return result;
    }
*//*
   public ArrayList<Staff> SearchStaffPilots(String name){
        ArrayList<Staff> result = new ArrayList<Staff>();

        for (Staff s : staff.values()) {
            if (s.getName().contains(name) && s.getType().equals(Staff.PersonalType.Pilot)) {
                result.add(s);
            }
        }
        return result;
   }
*/
    public ArrayList<Staff> SearchStaff(int staffId) {
        ArrayList<Staff> result = new ArrayList<Staff>();
        
        for (Staff s : staff.values()) {
            if (s.getStaffnumber() == staffId) {
                result.add(s);
            }
        }
        return result;
    }

         public ArrayList<Staff> SearchStaffAvailable(Date d){

         ArrayList<Staff> foundStaff = new ArrayList<Staff>();
        for(Staff s : staff.values()){
             boolean dontAdd = false;
             for (Flight f : flights.values()) {
                 if (f.getStaffs().contains(s) || f.getStaffByPilot().equals(s) || f.getStaffByCopilot().equals(s)){
                     Date nextDay = (Date) d.clone();
                     nextDay.setDate(d.getDate() + 1);
                     Date previousDay = (Date) d.clone();
                     previousDay.setDate(d.getDate() - 1);


                     if((f.getDate().getDate() == d.getDate() &&
                                f.getDate().getMonth() == d.getMonth() &&
                                f.getDate().getYear() == d.getYear()) || // staff is already on a plane today
                             (f.getDate().getDate() == nextDay.getDate() &&
                                f.getDate().getMonth() == nextDay.getMonth() &&
                                f.getDate().getYear() == nextDay.getYear()) || // staff is already on a plane tomorrow
                             (f.getDate().getDate() == previousDay.getDate() &&
                                f.getDate().getMonth() == previousDay.getMonth() &&
                                f.getDate().getYear() == previousDay.getYear()) // staff was already on a plane yesterday
                     ){

                        dontAdd = true;

                     }
                 }
             }
             if (!dontAdd) {
                 foundStaff.add(s);
             }
         }
        return foundStaff;
    }

 /*           public ArrayList<Staff> SearchStaffPilotsAvailable(Date d){

         ArrayList<Staff> foundStaff = new ArrayList<Staff>();
        for(Staff s : staff.values()){
            if(s.getType() != Staff.PersonalType.Pilot) continue; // only looking for pilots, so if this isn't a pilot, continue to the next staff member
             boolean dontAdd = false;
             for (Flight f : flights.values()) {
                 if (f.getPilots()[0].equals(s) || f.getPilots()[1].equals(s)){
                     Date nextDay = (Date) d.clone();
                     nextDay.setDate(d.getDate() + 1);
                     Date previousDay = (Date) d.clone();
                     previousDay.setDate(d.getDate() - 1);


                     if((f.getDate().getDate() == d.getDate() &&
                                f.getDate().getMonth() == d.getMonth() &&
                                f.getDate().getYear() == d.getYear()) || // staff is already on a plane today
                             (f.getDate().getDate() == nextDay.getDate() &&
                                f.getDate().getMonth() == nextDay.getMonth() &&
                                f.getDate().getYear() == nextDay.getYear()) || // staff is already on a plane tomorrow
                             (f.getDate().getDate() == previousDay.getDate() &&
                                f.getDate().getMonth() == previousDay.getMonth() &&
                                f.getDate().getYear() == previousDay.getYear()) // staff was already on a plane yesterday
                     ){

                        dontAdd = true;

                     }
                 }
             }
             if (!dontAdd) {
                 foundStaff.add(s);
             }
         }
        return foundStaff;
    }
*/
	public User getUserByStaff(Staff s){
		
		User found = null;
				
		for(User u : users.values()){
			
			if(u.getStaff() == s){
			
				found = u;	
			}
		}
		return found;
	}

    public Staff getStaffById(int staffId){
        return staff.get(staffId);
    }

    public boolean DeleteStaff(Staff s){
        boolean result = false;

        if(DatabaseConnectie.deleteStaff(s)){
            staff.remove(s.getStaffnumber());
			User u = getUserByStaff(s);
			if(u != null){
				users.remove(u.getUsername());
			}
            result = true;
            notifyObservers(s);
        }
        return result;
    }

    public boolean AddStaff(Staff s){
        boolean result = false;
        if(DatabaseConnectie.insertStaff(s)){

            staff.put(s.getStaffnumber(), s);
            result = true;
            notifyObservers(s);
        }
        return result;
    }
	public int getStaffID(){
		int result = 0;
		
		for(Staff s : staff.values()){
		
			if(s.getStaffnumber() > result){
				result = s.getStaffnumber();
			}
		}
		
		return result + 1;
	}
	
    public boolean ChangeStaff(Staff newStaff, Staff oldStaff){
        boolean result = false;

        if(DatabaseConnectie.updateStaff(newStaff, oldStaff)){
            staff.remove(oldStaff.getStaffnumber());
            oldStaff.setName(newStaff.getName());
            oldStaff.setStaffnumber(newStaff.getStaffnumber());
            oldStaff.setType(newStaff.getType());
            result = true;
            staff.put(oldStaff.getStaffnumber(), oldStaff);

            notifyObservers(oldStaff);

        }
        
        return result;
    }
/*
    public ArrayList<Airport> SearchAirport(String searchString){
        ArrayList<Airport> result = new ArrayList<Airport>();

        for(Airport a : airports.values()){
            if(a.getCity().contains(searchString)){
                result.add(a);
            }
            else if(a.getCountry().contains(searchString)){
                result.add(a);
            }
            else if(a.getName().contains(searchString)){
                result.add(a);
            }
            else if(a.getCode().contains(searchString)){
                result.add(a);
            }
        }

        return result;
    }
*/
    public Airport getAirportByName(String name){
        Airport foundAirport = null;

        for(Airport a : airports.values()){

            if(a.getName().equals(name)){
                foundAirport = a;
                break;
            }
        }
        return foundAirport;
    }
    
    public Airport getAirportByCode(String code) {
        Airport foundAirport = null;
        for(Airport a : airports.values()){

            if(a.getAirportcode().equals(code)){
                foundAirport = a;
                break;
            }
        }
        return foundAirport;
    }

    public boolean RemoveAirport(Airport a) {
        boolean result = false;

        if (DatabaseConnectie.deleteAirport(a)) {
            airports.remove(a.getName());
            result = true;
            notifyObservers(a);
        }


        return result;
    }

    public boolean AddAirport(Airport a){
        boolean result = false;

        if (DatabaseConnectie.insertAirport(a)) {

            airports.put(a.getName(), a);
            result = true;            
            this.setChanged();
            this.notifyObservers(a);
        }
        return result;
    }

  /*  public boolean ChangeAirport(Airport newAirport, Airport oldAirport){
        boolean result = false;

        if(DatabaseConnectie.updateAirport(newAirport, oldAirport)){
            airports.remove(oldAirport.getName());

            oldAirport.setName(newAirport.getName());
            oldAirport.setCountry(newAirport.getCountry());
            oldAirport.setCity(newAirport.getCity());
            oldAirport.setCode(newAirport.getCode());

            airports.put(oldAirport.getName(), oldAirport);
            notifyObservers(oldAirport);
        }
        result = true;
        return result;
    }
*/

//Flights
    public boolean AddFlight(Flight f){
        boolean result = false;

        if(flights.get(f.getFlightnumber()) == null){
            
            if(DatabaseConnectie.insertFlight(f)){
                 result = true;
                 flights.put(f.getFlightnumber(), f);
                 notifyObservers(f);
            }           
        }

        return result;
    }

	public Flight GetFlight(int number){
		Flight found = null;
		for(Flight f : flights.values())
		{
			if(f.getFlightnumber() == number){
				found = f;
				break;
			}		
		}
		return found;
	}
	
	/*public Flight getReturnFlight(int number){
		Flight found = null;
		for(Flight f : flights.values())
		{
			Flight rf = f.getReturnFlight();
			if(rf != null){
				
				if(f.getReturnFlight().getNumber() == number){
					found = f;
					break;
				}	
			
			}
				
		}
		return found;
	}
	*/
   /* public boolean ChangeFlight(Flight newFlight, Flight oldFlight){
        boolean result = false;

        result = DatabaseConnectie.updateFlight(newFlight,oldFlight);
        if(result){
            flights.remove(oldFlight.getNumber());
            oldFlight.setNumber(newFlight.getNumber());
            oldFlight.setDate(newFlight.getDate());
            oldFlight.setPilots(newFlight.getPilots());
            oldFlight.setFrom(newFlight.getFrom());
            oldFlight.setDestination(newFlight.getDestination());
            oldFlight.setPlane(newFlight.getPlane());
            oldFlight.setOtherPersonal(newFlight.getOtherPersonal());
            flights.put(oldFlight.getNumber(), oldFlight);
            notifyObservers(oldFlight);
        }
        return result;
    }
*/

    public boolean removeFlight(Flight f){
        boolean result = false;

        if(DatabaseConnectie.deleteFlight(f)){
            flights.remove(f.getFlightnumber());
			
			Flight rf = Controller.Instance().GetFlight(f.getFlightnumber());
			if(rf != null){
				flights.remove(rf.getFlightnumber());
				notifyObservers(f.getFlight());
			}
            result = true;
            notifyObservers(f);
			
        }
        return result;
    }

    public ArrayList<Flight> searchFlight(Date date) {
        ArrayList<Flight> result = new ArrayList<Flight>(); 


        for (Flight f : flights.values()) {
            if (f.getDate().equals(date)) {
                result.add(f);
            }
        }
        return result;        
    }

    public ArrayList<User> getUsers(){
        ArrayList<User> result = new ArrayList<User>();
        result.addAll(users.values());
        
        return result;
    }

    public User getLogedIn() {
        return logedIn;
    }

    public boolean ChangeUser(User oldUser, User newUser){
        boolean result = false;
     
        if(users.get(oldUser.getUsername()) != null){
			if(Database.DatabaseConnectie.updateUser(newUser, oldUser)){
			
			users.remove(oldUser.getUsername());
            users.put(newUser.getUsername(), newUser);
            notifyObservers(newUser);
            result = true;
			}
            
        }
        return result;        
    }

    public boolean addUser(User user){
        boolean result = false;

        if(users.get(user.getUsername()) == null){
            
			if(Database.DatabaseConnectie.insertUser(user)){
				users.put(user.getUsername(), user);
				notifyObservers(user);
				result = true;
			}
			
        }
        return result;
    }

    public boolean removeUser(User user){
        boolean result = false;
		
		if(Database.DatabaseConnectie.deleteUser(user)){
		
			if(users.remove(user.getUsername()) != null){

				notifyObservers(user);
				result = true;
			}
			
		}
        return result;
    }
    
    
}
