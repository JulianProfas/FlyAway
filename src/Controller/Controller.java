<<<<<<< HEAD
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AirMarshall;
import Model.Airport;
import Model.Country;
import Model.Flight;
import Model.PersonalType;
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
    HashMap<Integer, Staff> staff;
    HashMap<Integer, Flight> flights;
    HashMap<String, User> users;
    HashMap<String, Country> countries;
	HashMap<Integer, AirMarshall> airMarshalls;
    User loggedInUser;

    public void Initialize() {
		countries = Database.DatabaseConnectie.getCountries();
        users = Database.DatabaseConnectie.getUsers();
        airports = Database.DatabaseConnectie.getAirports();
        staff = Database.DatabaseConnectie.getStaff();
		airMarshalls = Database.DatabaseConnectie.getAirMarshalls();
        planes = Database.DatabaseConnectie.getPlanes();
        //We need to add flights as last.
        flights = Database.DatabaseConnectie.getFlights();
        
    }

    public boolean Login(String username, String password) {
        boolean result = false;

        if (users != null) {
            User permittedUser = new User();
            permittedUser.setPassword(password, false);
            permittedUser.setUsername(username);

            User currentUser = users.get(username);

            if (currentUser != null) {
                if (currentUser.getPassword().equals(permittedUser.getPassword())) {
                    this.loggedInUser = currentUser;
                    result = true;
                }
            }
        }
        return result;
    }

	
	
	public HashMap<Integer, AirMarshall> getAirMarshalls() {
		return airMarshalls;
	}
	
    public Controller() {
        planes = new HashMap<Integer, Plane>();
        airports = new HashMap<String, Airport>();
        staff = new HashMap<Integer, Staff>();
        flights = new HashMap<Integer, Flight>();
        users = new HashMap<String, User>();
        countries = new HashMap<String, Country>();
    }

    @Override
    public void notifyObservers(Object o) {
        this.setChanged();
        super.notifyObservers(o);
    }

    public static Controller Instance() {
        return controller;
    }

    public ArrayList<Airport> getAirports() {
        ArrayList<Airport> results = new ArrayList<Airport>();
        airports = Database.DatabaseConnectie.getAirports();
        results.addAll(airports.values());

        return results;
    }

    public ArrayList<Country> getCountries() {
        ArrayList<Country> results = new ArrayList<Country>();
        countries = Database.DatabaseConnectie.getCountries();
        results.addAll(countries.values());
        return results;
    }

    public ArrayList<Flight> getFlights() {
        ArrayList<Flight> result = new ArrayList<Flight>();
	flights = Database.DatabaseConnectie.getFlights();
        result.addAll(flights.values());
        return result;
    }

    public ArrayList<Staff> getStaff() {
        ArrayList<Staff> result = new ArrayList<Staff>();
	staff = Database.DatabaseConnectie.getStaff();
        result.addAll(staff.values());
        return result;
    }

    public ArrayList<Plane> getPlanes() {

        ArrayList<Plane> result = new ArrayList<Plane>();
	planes = Database.DatabaseConnectie.getPlanes();
        result.addAll(planes.values());
        return result;
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> result = new ArrayList<User>();
	users = Database.DatabaseConnectie.getUsers();
        result.addAll(users.values());

        return result;
    }

    public boolean saveObject(Object o) {

        boolean result = false;
        if (Database.DatabaseConnectie.saveObject(o)) {
            if (o instanceof User) {
                User u = (User) o;
                users.put(u.getUsername(), u);
                this.notifyObservers(u);
            } else if (o instanceof Staff) {
                Staff s = (Staff) o;
                staff.put(s.getNumber(), s);
                this.notifyObservers(s);
            } else if (o instanceof Plane) {
                Plane p = (Plane) o;
                planes.put(p.getNumber(), p);
                this.notifyObservers(p);
            } else if (o instanceof Airport) {
                Airport a = (Airport) o;
                airports.put(a.getCode(), a);
                this.notifyObservers(a);
            } else if (o instanceof Flight) {
                Flight f = (Flight) o;
                flights.put(f.getNumber(), f);
                this.notifyObservers(f);
            } else if(o instanceof AirMarshall){
				AirMarshall a = (AirMarshall) o;
				airMarshalls.put(a.getNumber(), a);
				this.notifyObservers(a);
			}
            result = true;
        }
        return result;
    }

    public boolean updateObject(Object o) {

        boolean result = false;
        if (Database.DatabaseConnectie.updateObject(o)) {
            if (o instanceof User) {
                User u = (User) o;
                this.notifyObservers(u);
            } else if (o instanceof Staff) {
                Staff s = (Staff) o;
                this.notifyObservers(s);
            } else if (o instanceof Plane) {
                Plane p = (Plane) o;
                this.notifyObservers(p);
            } else if (o instanceof Airport) {
                Airport a = (Airport) o;
                this.notifyObservers(a);
            } else if (o instanceof Flight) {
                Flight f = (Flight) o;
                this.notifyObservers(f);
            } else if(o instanceof AirMarshall){
				AirMarshall a = (AirMarshall) o;
				this.notifyObservers(a);
			}
            result = true;
        }
        return result;
    }

    public boolean deleteObject(Object o) {

        boolean result = false;
		
        if (Database.DatabaseConnectie.deleteObject(o)) {
            if (o instanceof User) {
                User u = (User) o;
                users.remove(u.getUsername());
                this.notifyObservers(u);
            } else if (o instanceof Staff) {
                Staff s = (Staff) o;
                staff.remove(s.getNumber());
                this.notifyObservers(s);
            } else if (o instanceof Plane) {
                Plane p = (Plane) o;
                planes.remove(p.getNumber());
                this.notifyObservers(p);
            } else if (o instanceof Airport) {
                Airport a = (Airport) o;
                airports.remove(a.getCode());
                this.notifyObservers(a);
            } else if (o instanceof Flight) {
                Flight f = (Flight) o;
                flights.remove(f.getNumber());
                this.notifyObservers(f);
            } else if(o instanceof AirMarshall){
				AirMarshall a = (AirMarshall) o;
				airMarshalls.remove(a.getNumber());
				this.notifyObservers(a);
			}
            result = true;
        }
        return result;
    }

    public ArrayList<Flight> getScheduledFlights() {
        ArrayList<Flight> result = new ArrayList<Flight>();
        Staff s = this.loggedInUser.getStaffAccount();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.roll(Calendar.DAY_OF_MONTH, false);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        Date d = c.getTime();

        for (Flight f : flights.values()) {

            Staff pilot = f.getPilot();
            Staff coPilot = f.getCopilot();

            if ((pilot.getNumber() == s.getNumber() || coPilot.getNumber() == s.getNumber() || f.getOtherPersonal().contains(s)) && f.getDate().after(d)) {
                result.add(f);
            }
        }
        return result;
    }
    
    public ArrayList<Flight> getScheduledFlights(User user) {
        ArrayList<Flight> result = new ArrayList<Flight>();
        Staff s = user.getStaffAccount();
        
	Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.roll(Calendar.DAY_OF_MONTH, false);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        Date d = c.getTime();
	flights = Database.DatabaseConnectie.getFlights();
	
	System.out.println(flights.size());
        for (Flight f : flights.values()) {

            Staff pilot = f.getPilot();
            Staff coPilot = f.getCopilot();
	    

            if ((pilot.getNumber() == s.getNumber() || coPilot.getNumber() == s.getNumber() || f.getOtherPersonal().contains(s)) && f.getDate().after(d)) {
                result.add(f);
            }
        }
	
        return result;
    }

    public ArrayList<Plane> SearchPlanes(int number) {
        ArrayList<Plane> foundPlanes = new ArrayList<Plane>();
        for (Plane p : planes.values()) {
            if (p.getNumber() == number) {
                foundPlanes.add(p);
            }
        }
        return foundPlanes;
    }

    public User getUserByUsername(String userName) {
        return users.get(userName);
    }

    public Plane getPlaneByNumber(int number) {
        return planes.get(number);
    }

    public ArrayList<Plane> SearchPlanes(String type) {
        ArrayList<Plane> foundPlanes = new ArrayList<Plane>();
        for (Plane p : planes.values()) {
            if (p.getType().contains(type)) {

                foundPlanes.add(p);
            }
        }
        return foundPlanes;
    }

    public ArrayList<Plane> SearchPlanesAvailable(Date d) {

        ArrayList<Plane> foundPlanes = new ArrayList<Plane>();
        for (Plane p : planes.values()) {
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

    public ArrayList<Staff> SearchStaff(String name) {
        ArrayList<Staff> result = new ArrayList<Staff>();

        for (Staff s : staff.values()) {
            if (s.getName().contains(name)) {
                result.add(s);
            }
        }
        return result;
    }

    public ArrayList<Staff> SearchStaff(PersonalType st) {
        ArrayList<Staff> result = new ArrayList<Staff>();

        for (Staff s : staff.values()) {
            if (s.getType().equals(st)) {
                result.add(s);
            }
        }
        return result;
    }

    public ArrayList<Staff> SearchStaffPilots(String name) {
        ArrayList<Staff> result = new ArrayList<Staff>();

        for (Staff s : staff.values()) {
            if (s.getName().contains(name) && s.getType().equals(PersonalType.Pilot)) {
                result.add(s);
            }
        }
        return result;
    }

    public ArrayList<Staff> SearchStaff(int staffId) {
        ArrayList<Staff> result = new ArrayList<Staff>();

        for (Staff s : staff.values()) {
            if (s.getNumber() == staffId) {
                result.add(s);
            }
        }
        return result;
    }

    public int getReturnFlightID(int id) {
        int result = id + 1;

        while (this.GetFlight(result) != null) {

            result++;
        }

        return result;
    }

    public ArrayList<Staff> SearchStaffAvailable(Date d) {

        ArrayList<Staff> foundStaff = new ArrayList<Staff>();
	boolean dontAdd = false;
        for (Staff s : staff.values()) {
	    if(s.getType().equals(PersonalType.Pilot)){
		dontAdd = true;
	    }else{
		dontAdd = false;
		for (Flight f : flights.values()) {
		    if (f.getOtherPersonal().contains(s) || f.getPilot().equals(s) || f.getCopilot().equals(s)) {
			Date nextDay = (Date) d.clone();
			nextDay.setDate(d.getDate() + 1);
			Date previousDay = (Date) d.clone();
			previousDay.setDate(d.getDate() - 1);


			if ((f.getDate().getDate() == d.getDate()
				&& f.getDate().getMonth() == d.getMonth()
				&& f.getDate().getYear() == d.getYear()) || // staff is already on a plane today
				(f.getDate().getDate() == nextDay.getDate()
				&& f.getDate().getMonth() == nextDay.getMonth()
				&& f.getDate().getYear() == nextDay.getYear()) || // staff is already on a plane tomorrow
				(f.getDate().getDate() == previousDay.getDate()
				&& f.getDate().getMonth() == previousDay.getMonth()
				&& f.getDate().getYear() == previousDay.getYear()) // staff was already on a plane yesterday
				) {

			    dontAdd = true;

			}
		    }
		}
            }
            if (!dontAdd) {
                foundStaff.add(s);
            }

        }
        return foundStaff;
    }

    public ArrayList<Staff> SearchStaffPilotsAvailable(Date d) {

        ArrayList<Staff> foundStaff = new ArrayList<Staff>();
        for (Staff s : staff.values()) {
            if (s.getType() != PersonalType.Pilot) {
                continue; // only looking for pilots, so if this isn't a pilot, continue to the next staff member
            }
            boolean dontAdd = false;
            for (Flight f : flights.values()) {
                if (f.getPilot().equals(s) || f.getCopilot().equals(s)) {
                    Date nextDay = (Date) d.clone();
                    nextDay.setDate(d.getDate() + 1);
                    Date previousDay = (Date) d.clone();
                    previousDay.setDate(d.getDate() - 1);


                    if ((f.getDate().getDate() == d.getDate()
                            && f.getDate().getMonth() == d.getMonth()
                            && f.getDate().getYear() == d.getYear()) || // staff is already on a plane today
                            (f.getDate().getDate() == nextDay.getDate()
                            && f.getDate().getMonth() == nextDay.getMonth()
                            && f.getDate().getYear() == nextDay.getYear()) || // staff is already on a plane tomorrow
                            (f.getDate().getDate() == previousDay.getDate()
                            && f.getDate().getMonth() == previousDay.getMonth()
                            && f.getDate().getYear() == previousDay.getYear()) // staff was already on a plane yesterday
                            ) {

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

    public Staff getStaffById(int staffId) {
        return staff.get(staffId);
    }
    
	public AirMarshall getAirMarshallByID(int staffID){
		return (AirMarshall)staff.get(staffID);
	}
	
    public AirMarshall getAirMarshalByBadgeNumber(int weaponNumber) {
	AirMarshall gezocht = null;
	
	for (Staff s : staff.values()) {
	    if (s instanceof AirMarshall){
		AirMarshall a = (AirMarshall) s;
	    
		if (a.getWeaponNumber() == weaponNumber) {
		    gezocht = a;
		}
	    }
	}
	return gezocht;
    }

    public ArrayList<Airport> SearchAirport(String searchString) {
        ArrayList<Airport> result = new ArrayList<Airport>();

        for (Airport a : airports.values()) {
            if (a.getCity().contains(searchString)) {
                result.add(a);
            } else if (a.getCountry().getName().contains(searchString)) {
                result.add(a);
            } else if (a.getName().contains(searchString)) {
                result.add(a);
            } else if (a.getCode().contains(searchString)) {
                result.add(a);
            }
        }

        return result;
    }

    public Airport getAirportByName(String name) {
        Airport foundAirport = null;

        for (Airport a : airports.values()) {

            if (a.getName().equals(name)) {
                foundAirport = a;
                break;
            }
        }
        return foundAirport;
    }

    public Airport getAirportByCode(String code) {
        Airport foundAirport = null;
        for (Airport a : airports.values()) {

            if (a.getCode().equals(code)) {
                foundAirport = a;
                break;
            }
        }
        return foundAirport;
    }

    public Flight GetFlight(int number) {
        Flight found = null;
        for (Flight f : flights.values()) {
            if (f.getNumber() == number) {
                found = f;
                break;
            }
        }
        return found;
    }

    public Flight getReturnFlight(int number) {
        Flight found = null;
        for (Flight f : flights.values()) {
            Flight rf = f.getReturnFlight();
            if (rf != null) {

                if (f.getReturnFlight().getNumber() == number) {
                    found = f;
                    break;
                }
            }
        }
        return found;
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
    
    public ArrayList<Flight> searchFlight(String search) {
        ArrayList<Flight> result = new ArrayList<Flight>();
        for (Flight f: flights.values()) {
            if(f.getFrom().toString().contains(search) || f.getDestination().toString().contains(search) || ("" + f.getNumber()).contains(search))  {
                result.add(f);
            }
        }
        return result;
    }

    public User getLogedIn() {
        return loggedInUser;
    }

    //public void removeUser(User row) {
      //  Database.DatabaseConnectie.deleteObject(row);

    //}

    public ArrayList<User> SearchUser(String searchString) {
        ArrayList<User> result = new ArrayList<User>();

        for (User u : users.values()) {
            if (u.getUsername().contains(searchString)) {
                result.add(u);
            }
        }
        return result;
    }
}
=======
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Airport;
import Model.Country;
import Model.Flight;
import Model.PersonnelType;
import Model.Staff;
import Model.Plane;
import Model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Observable;
import java.util.Timer;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class Controller extends Observable {

    private static Controller controller = new Controller();
    HashMap<Integer, Plane> planes;
    HashMap<String, Airport> airports;
    HashMap<Integer, Staff> staff;
    HashMap<Integer, Flight> flights;
    HashMap<String, User> users;
    HashMap<String, Country> countries;
    User loggedInUser;

    public void Initialize() {
        users = Database.DatabaseConnection.getUsers();
        airports = Database.DatabaseConnection.getAirports();
        staff = Database.DatabaseConnection.getStaff();
        planes = Database.DatabaseConnection.getPlanes();
        //We need to add flights as last.
        flights = Database.DatabaseConnection.getFlights();
        countries = Database.DatabaseConnection.getCountries();
    }

    public boolean Login(String username, String password) {
        boolean result = false;

        if (users != null) {
            User permittedUser = new User();
            permittedUser.setPassword(password, false);
            permittedUser.setUsername(username);

            User currentUser = users.get(username);

            if (currentUser != null) {
                if (currentUser.getPassword().equals(permittedUser.getPassword())) {
                    this.loggedInUser = currentUser;
                    result = true;
                }
            }
        }
        return result;
    }

    public Controller() {
        planes = new HashMap<Integer, Plane>();
        airports = new HashMap<String, Airport>();
        staff = new HashMap<Integer, Staff>();
        flights = new HashMap<Integer, Flight>();
        users = new HashMap<String, User>();
        countries = new HashMap<String, Country>();
    }

    @Override
    public void notifyObservers(Object o) {
        this.setChanged();
        super.notifyObservers(o);
    }

    public static Controller Instance() {
        return controller;
    }

    public ArrayList<Airport> getAirports() {
        ArrayList<Airport> results = new ArrayList<Airport>();
        airports = Database.DatabaseConnection.getAirports();
        results.addAll(airports.values());

        return results;
    }

    public ArrayList<Country> getCountries() {
        ArrayList<Country> results = new ArrayList<Country>();
        countries = Database.DatabaseConnection.getCountries();
        results.addAll(countries.values());
        return results;
    }

    public ArrayList<Flight> getFlights() {
        ArrayList<Flight> result = new ArrayList<Flight>();
        flights = Database.DatabaseConnection.getFlights();
        result.addAll(flights.values());
        return result;
    }


    public ArrayList<Staff> getStaff() {
        ArrayList<Staff> result = new ArrayList<Staff>();
        staff = Database.DatabaseConnection.getStaff();
        result.addAll(staff.values());
        return result;
    }

    public ArrayList<Plane> getPlanes() {

        ArrayList<Plane> result = new ArrayList<Plane>();
        planes = Database.DatabaseConnection.getPlanes();
        result.addAll(planes.values());
        return result;
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> result = new ArrayList<User>();
        users = Database.DatabaseConnection.getUsers();
        result.addAll(users.values());

        return result;
    }

    public boolean saveObject(Object o) {

        boolean result = false;
        if (Database.DatabaseConnection.saveObject(o)) {
            if (o instanceof User) {
                User u = (User) o;
                users.put(u.getUsername(), u);
                this.notifyObservers(u);
            } else if (o instanceof Staff) {
                Staff s = (Staff) o;
                staff.put(s.getNumber(), s);
                this.notifyObservers(s);
            } else if (o instanceof Plane) {
                Plane p = (Plane) o;
                planes.put(p.getNumber(), p);
                this.notifyObservers(p);
            } else if (o instanceof Airport) {
                Airport a = (Airport) o;
                airports.put(a.getCode(), a);
                this.notifyObservers(a);
            } else if (o instanceof Flight) {
                Flight f = (Flight) o;
                flights.put(f.getNumber(), f);
                this.notifyObservers(f);
            }
            result = true;
        }
        return result;
    }

    public boolean updateObject(Object o) {

        boolean result = false;
        if (Database.DatabaseConnection.updateObject(o)) {
            if (o instanceof User) {
                User u = (User) o;
                this.notifyObservers(u);
            } else if (o instanceof Staff) {
                Staff s = (Staff) o;
                this.notifyObservers(s);
            } else if (o instanceof Plane) {
                Plane p = (Plane) o;
                this.notifyObservers(p);
            } else if (o instanceof Airport) {
                Airport a = (Airport) o;
                this.notifyObservers(a);
            } else if (o instanceof Flight) {
                Flight f = (Flight) o;
                this.notifyObservers(f);
            }
            result = true;
        }
        return result;
    }

    public boolean deleteObject(Object o) {

        boolean result = false;

        if (Database.DatabaseConnection.deleteObject(o)) {

            if (o instanceof User) {
                User u = (User) o;
                users.remove(u.getUsername());
                this.notifyObservers(u);
            } else if (o instanceof Staff) {
                Staff s = (Staff) o;
                staff.remove(s.getNumber());
                this.notifyObservers(s);
            } else if (o instanceof Plane) {
                Plane p = (Plane) o;
                planes.remove(p.getNumber());
                this.notifyObservers(p);
            } else if (o instanceof Airport) {
                Airport a = (Airport) o;
                airports.remove(a.getCode());
                this.notifyObservers(a);
            } else if (o instanceof Flight) {
                Flight f = (Flight) o;
                flights.remove(f.getNumber());
                this.notifyObservers(f);
            }
            result = true;
        }
        return result;
    }

    public ArrayList<Flight> getScheduledFlights() {
        return this.getScheduledFlights(loggedInUser);
    }

    public ArrayList<Flight> getScheduledFlights(User user) {
        ArrayList<Flight> result = new ArrayList<Flight>();
        Staff s = user.getStaffAccount();

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.roll(Calendar.DAY_OF_MONTH, false);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        Date d = c.getTime();
        flights = Database.DatabaseConnection.getFlights();

        for (Flight f : flights.values()) {

            Staff pilot = f.getPilot();
            Staff coPilot = f.getCopilot();


            if ((pilot.getNumber() == s.getNumber() || coPilot.getNumber() == s.getNumber() || f.getOtherPersonnel().contains(s)) && f.getDate().after(d)) {
                result.add(f);
            }
        }

        return result;
    }

    public ArrayList<Plane> SearchPlanes(int number) {
        ArrayList<Plane> foundPlanes = new ArrayList<Plane>();
        for (Plane p : planes.values()) {
            if (p.getNumber() == number) {
                foundPlanes.add(p);
            }
        }
        return foundPlanes;
    }

    public User getUserByUsername(String userName) {
        return users.get(userName);
    }

    public Plane getPlaneByNumber(int number) {
        return planes.get(number);
    }

    public ArrayList<Plane> SearchPlanes(String type) {
        ArrayList<Plane> foundPlanes = new ArrayList<Plane>();
        for (Plane p : planes.values()) {
            if (p.getType().contains(type)) {

                foundPlanes.add(p);
            }
        }
        return foundPlanes;
    }

    public ArrayList<Plane> SearchPlanesAvailable(Date d) {

        ArrayList<Plane> foundPlanes = new ArrayList<Plane>();
        for (Plane p : planes.values()) {
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

    public ArrayList<Staff> SearchStaff(String name) {
        ArrayList<Staff> result = new ArrayList<Staff>();

        for (Staff s : staff.values()) {
            if (s.getName().contains(name)) {
                result.add(s);
            }
        }
        return result;
    }

    public ArrayList<Staff> SearchStaff(PersonnelType st) {
        ArrayList<Staff> result = new ArrayList<Staff>();

        for (Staff s : staff.values()) {
            if (s.getType().equals(st)) {
                result.add(s);
            }
        }
        return result;
    }

    public ArrayList<Staff> SearchStaffPilots(String name) {
        ArrayList<Staff> result = new ArrayList<Staff>();

        for (Staff s : staff.values()) {
            if (s.getName().contains(name) && s.getType().equals(PersonnelType.Pilot)) {
                result.add(s);
            }
        }
        return result;
    }

    public ArrayList<Staff> SearchStaff(int staffId) {
        ArrayList<Staff> result = new ArrayList<Staff>();

        for (Staff s : staff.values()) {
            if (s.getNumber() == staffId) {
                result.add(s);
            }
        }
        return result;
    }

    public int getReturnFlightID(int id) {
        int result = id + 1;

        while (this.GetFlight(result) != null) {

            result++;
        }

        return result;
    }

    public ArrayList<Staff> SearchStaffAvailable(Date d) {

        ArrayList<Staff> foundStaff = new ArrayList<Staff>();
        boolean dontAdd = false;
        for (Staff s : staff.values()) {
            if (s.getType().equals(PersonnelType.Pilot)) {
                dontAdd = true;
            } else {
                dontAdd = false;
                for (Flight f : flights.values()) {
                    if (f.getOtherPersonnel().contains(s) || f.getPilot().equals(s) || f.getCopilot().equals(s)) {
                        Date nextDay = (Date) d.clone();
                        nextDay.setDate(d.getDate() + 1);
                        Date previousDay = (Date) d.clone();
                        previousDay.setDate(d.getDate() - 1);


                        if ((f.getDate().getDate() == d.getDate()
                                && f.getDate().getMonth() == d.getMonth()
                                && f.getDate().getYear() == d.getYear()) || // staff is already on a plane today
                                (f.getDate().getDate() == nextDay.getDate()
                                && f.getDate().getMonth() == nextDay.getMonth()
                                && f.getDate().getYear() == nextDay.getYear()) || // staff is already on a plane tomorrow
                                (f.getDate().getDate() == previousDay.getDate()
                                && f.getDate().getMonth() == previousDay.getMonth()
                                && f.getDate().getYear() == previousDay.getYear()) // staff was already on a plane yesterday
                                ) {

                            dontAdd = true;

                        }
                    }
                }
            }
            if (!dontAdd) {
                foundStaff.add(s);
            }

        }
        return foundStaff;
    }

    public ArrayList<Staff> SearchStaffPilotsAvailable(Date d) {

        ArrayList<Staff> foundStaff = new ArrayList<Staff>();
        for (Staff s : staff.values()) {
            if (s.getType() != PersonnelType.Pilot) {
                continue; // only looking for pilots, so if this isn't a pilot, continue to the next staff member
            }
            boolean dontAdd = false;
            for (Flight f : flights.values()) {
                if (f.getPilot().equals(s) || f.getCopilot().equals(s)) {
                    Date nextDay = (Date) d.clone();
                    nextDay.setDate(d.getDate() + 1);
                    Date previousDay = (Date) d.clone();
                    previousDay.setDate(d.getDate() - 1);

                    if ((f.getDate().getDate() == d.getDate()
                            && f.getDate().getMonth() == d.getMonth()
                            && f.getDate().getYear() == d.getYear()) || // staff is already on a plane today
                            (f.getDate().getDate() == nextDay.getDate()
                            && f.getDate().getMonth() == nextDay.getMonth()
                            && f.getDate().getYear() == nextDay.getYear()) || // staff is already on a plane tomorrow
                            (f.getDate().getDate() == previousDay.getDate()
                            && f.getDate().getMonth() == previousDay.getMonth()
                            && f.getDate().getYear() == previousDay.getYear()) // staff was already on a plane yesterday
                            ) {

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

    public Staff getStaffById(int staffId) {
        return staff.get(staffId);
    }

    public ArrayList<Airport> SearchAirport(String searchString) {
        ArrayList<Airport> result = new ArrayList<Airport>();

        for (Airport a : airports.values()) {
            if (a.getCity().contains(searchString)) {
                result.add(a);
            } else if (a.getCountry().getName().contains(searchString)) {
                result.add(a);
            } else if (a.getName().contains(searchString)) {
                result.add(a);
            } else if (a.getCode().contains(searchString)) {
                result.add(a);
            }
        }

        return result;
    }

    public Airport getAirportByName(String name) {
        Airport foundAirport = null;

        for (Airport a : airports.values()) {

            if (a.getName().equals(name)) {
                foundAirport = a;
                break;
            }
        }
        return foundAirport;
    }

    public Airport getAirportByCode(String code) {
        Airport foundAirport = null;
        for (Airport a : airports.values()) {

            if (a.getCode().equals(code)) {
                foundAirport = a;
                break;
            }
        }
        return foundAirport;
    }

    public Flight GetFlight(int number) {
        Flight found = null;
        for (Flight f : flights.values()) {
            if (f.getNumber() == number) {
                found = f;
                break;
            }
        }
        return found;
    }

    public Flight getReturnFlight(int number) {
        Flight found = null;
        for (Flight f : flights.values()) {
            Flight rf = f.getReturnFlight();
            if (rf != null) {

                if (f.getReturnFlight().getNumber() == number) {
                    found = f;
                    break;
                }
            }
        }
        return found;
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

    public ArrayList<Flight> searchFlight(String search) {
        ArrayList<Flight> result = new ArrayList<Flight>();
        for (Flight f : flights.values()) {
            if (f.getFrom().toString().contains(search) || f.getDestination().toString().contains(search) || ("" + f.getNumber()).contains(search)) {
                result.add(f);
            }
        }
        return result;
    }

    public User getLogedIn() {
        return loggedInUser;
    }

    public ArrayList<User> SearchUser(String searchString) {
        ArrayList<User> result = new ArrayList<User>();

        for (User u : users.values()) {
            if (u.getUsername().contains(searchString)) {
                result.add(u);
            }
        }
        return result;
    }
}
>>>>>>> Release4
