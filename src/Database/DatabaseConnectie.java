/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import Model.Airport;
import Model.Flight;
import Model.Plane;
import Model.Staff;
import Model.User;
import util.HibernateUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jeroen
 */
public class DatabaseConnectie {

    private static Connection con = null;

    public static boolean Connect(String connection, String user, String password){
        boolean result = false;

        try {

            //String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
            // String url = "jdbc:odbc:northwind";
            //String username = "";
            //String password = "";
            //Class.forName(driver);

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.INFO, "Driver instantiated");

            con = DriverManager.getConnection("jdbc:mysql:" + connection, user, password);
            //con = DriverManager.getConnection("jdbc:odbc:" + connection, "", "");
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.INFO, " Database connection made");
            result = true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }

    public static boolean Disconnect(){
        boolean result = false;

        try{
            con.close();
            result = true;
        }
        catch(SQLException sqlException){
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, sqlException);
        }

        return result;
    }

    public static HashMap<String, User> getUsers() {

	/*HashMap<String, User> users = new HashMap<String, User>();

	 try{
	 PreparedStatement pstmt;

	 pstmt = con.prepareStatement("Select * from user;");

	 ResultSet rs;

	 rs = pstmt.executeQuery();

	 while(rs.next()){
	 User u = new User();

	 u.setUsername(rs.getString("username"));
	 u.setPassword(rs.getString("password"), true);
	 u.setRank(User.Rank.valueOf(rs.getString("rank")));
				
	 u.setStaffAccount(Controller.Controller.Instance().getStaffById(rs.getInt("staff")));
				
	 users.put(u.getUsername(), u);
	 }
	 } catch (SQLException ex) {
	 Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
	 }
	 return users;*/

	HashMap<String, User> users = new HashMap<String, User>();

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	List usersList = session.createQuery("from User").list();

	Iterator itr = usersList.iterator();
	while (itr.hasNext()) {

	    Model.User user = (Model.User) itr.next();
	    User u = new User();

	    u.setUsername(user.getUsername());
	    u.setPassword(user.getPassword(), false); //don't hash the password
	    u.setRank(user.getRank());
	    u.setStaff(user.getStaff());
	    users.put(user.getUsername(), u);
	}
	return users;
    }
	
	public static boolean insertUser(User u){
	/*
		boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Insert into user values (?,?,?,?);");

            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPassword());
            pstmt.setString(3 ,u.getRank().toString());
			if(u.getStaffAccount() == null){
				pstmt.setNull(4, java.sql.Types.NULL);
			}else{
				pstmt.setInt(4, u.getStaffAccount().getNumber());
			}
                       
            int rowCount = pstmt.executeUpdate();
            if(rowCount == 1){
                result = true;
            }
         } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;*/
	
            boolean result = true; // todo: add hibernate exception handling

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            User user = new User();
            user.setUsername(u.getUsername());
            user.setPassword(u.getPassword());
            user.setRank(u.getRank());
            user.setStaff(u.getStaff());
            session.save(user);
            session.getTransaction().commit();

            return result;
        
        }
	
	public static boolean updateUser(User uNew, User uOld){
	
		boolean result = false;
/*
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Update user set username = ?, password = ?, rank = ?, staff = NULL where username = ?;");
            pstmt.setString(1, uNew.getUsername());
            pstmt.setString(2, uNew.getPassword());
            pstmt.setString(3, uNew.getRank().toString());
            pstmt.setString(4, uOld.getUsername());

            int rowCount = pstmt.executeUpdate();
            if(rowCount == 1){
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }

*/
        return result;
	}
	
	public static boolean deleteUser(User u){
	
		/*boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Delete from user where username = ?;");
            pstmt.setString(1, u.getUsername());

            int rowCount = pstmt.executeUpdate();

            if(rowCount == 1){
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;*/
            
            boolean result = true;      //todo: Add hibernate exception

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            User user = (User) session.load(User.class, u.getUsername());
            session.delete(user);
            session.getTransaction().commit();

            return result;
	}
	
	
    public static HashMap<Integer, Plane> getPlanes() {
	/*HashMap<Integer, Plane> planes = new HashMap<Integer, Plane>();

	 try{
	 PreparedStatement pstmt;

	 pstmt = con.prepareStatement("Select * from plane;");

	 ResultSet rs;

	 rs = pstmt.executeQuery();


	 while(rs.next()){
	 Plane p = new Plane();

	 p.setCapacity(rs.getInt("capacity"));
	 p.setNumber(rs.getInt("planenumber"));
	 p.setType(rs.getString("type"));
	 planes.put(p.getNumber(), p);
	 }
	 } catch (SQLException ex) {
	 Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
	 }
	 return planes;*/

	HashMap<Integer, Plane> planes = new HashMap<Integer, Plane>();

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	List planesList = session.createQuery("from Plane").list();

	Iterator itr = planesList.iterator();
	while (itr.hasNext()) {

	    Model.Plane plane = (Model.Plane) itr.next();
	    Plane p = new Plane();

	    p.setPlanenumber(plane.getPlanenumber());
	    p.setCapacity(plane.getCapacity());
	    p.setType(plane.getType());
	    planes.put(plane.getPlanenumber(), p);
	}
	return planes;
    }

    public static HashMap<String, Airport> getAirports(){
        /*HashMap<String, Airport> airports = new  HashMap<String, Airport>();
        try {
            PreparedStatement pstmt;

            pstmt = con.prepareStatement("Select * from airport;");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Airport a = new Airport();
                a.setCity(rs.getString("city"));
                a.setCountry(rs.getString("country"));
                a.setName(rs.getString("name"));
                a.setCode(rs.getString("airportcode"));

                airports.put(a.getName(),a);

            }

        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return airports;*/
	
	HashMap<String, Airport> airports = new HashMap<String, Airport>();
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List airportsList = session.createQuery("from Airport").list();
        
        Iterator itr = airportsList.iterator();
        while (itr.hasNext()) {
            Model.Airport airport = (Model.Airport) itr.next();
            Airport a = new Airport();
          
	    a.setAirportcode(airport.getAirportcode());
	    a.setName(airport.getName());
	    a.setCity(airport.getCity());
	    a.setCountry(airport.getCountry());
            airports.put(airport.getAirportcode(), a);
        }
        return airports;
    }

    public static HashMap<Integer, Staff> getStaff() {
	/*HashMap<Integer, Staff> staff = new HashMap<Integer, Staff>();

	 try{
	 PreparedStatement pstmt = con.prepareStatement("Select * from staff;");

	 ResultSet rs = pstmt.executeQuery();

	 while(rs.next()){
	 Staff s = new Staff();
	 s.setName(rs.getString("name"));
	 s.setNumber(rs.getInt("staffnumber"));
	 s.setType(Staff.PersonalType.valueOf( rs.getString("type")));
	 s.setPrimaryAirport(rs.getString("primaryairport"));

	 staff.put(s.getNumber(), s);
	 }

	 }
	 catch (SQLException ex) {
	 Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
	 }
	 return staff;*/

	HashMap<Integer, Staff> staff = new HashMap<Integer, Staff>();

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	List staffList = session.createQuery("from Staff").list();

	Iterator itr = staffList.iterator();
	while (itr.hasNext()) {
	    Model.Staff aStaff = (Model.Staff) itr.next();
	    Staff s = new Staff();

	    s.setName(aStaff.getName());
	    s.setStaffnumber(aStaff.getStaffnumber());
	    s.setAirport(aStaff.getAirport());
	    s.setType(aStaff.getType());
	    staff.put(aStaff.getStaffnumber(), s);
	}
	return staff;
    }

    public static HashMap<Integer, Flight> getFlights() {
        /*HashMap<Integer, Flight> flights = new HashMap<Integer, Flight>();

        try {
            PreparedStatement pstmt = con.prepareStatement("Select * from flight;");
           
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Flight f = new Flight();
                f.setNumber(rs.getInt("flightnumber"));
				f.setDate(rs.getDate("date"));
				
//BSC                SimpleDateFormat sdf = new SimpleDateFormat(Flight.FlightDateFormat);
//BSC                try {
//BSC                    f.setDate(sdf.parse(rs.getString("date")));
//BSC                } catch (ParseException ex) {
//BSC                    Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
//BSC                    continue;
//BSC                }
				
                Airport destination = Controller.Controller.Instance().getAirportByCode(rs.getString("airportdestination"));
                Airport from = Controller.Controller.Instance().getAirportByCode(rs.getString("airportfrom"));

                Staff[] pilots = new Staff[2];
                pilots[0] = Controller.Controller.Instance().getStaffById(rs.getInt("pilot"));
                pilots[1] = Controller.Controller.Instance().getStaffById(rs.getInt("copilot"));
                Plane plane = Controller.Controller.Instance().getPlaneByNumber(rs.getInt("plane"));

                if (destination != null && from != null && pilots[0] != null && pilots[1] != null && plane != null) {
                    f.setDestination(destination);
                    f.setFrom(from);
                    f.setPilots(pilots);
                    f.setPlane(plane);
				}
				
                ArrayList<Staff> otherPersonal = new ArrayList<Staff>();

                pstmt = con.prepareStatement("Select * from flightstaff where flight = ?;");
                pstmt.setInt(1, f.getNumber());

                ResultSet rs2 = pstmt.executeQuery();
                while (rs2.next()) {

                    Staff s = Controller.Controller.Instance().getStaffById(rs2.getInt("staff"));
                    if (s != null) {
                        otherPersonal.add(s);
                    }
                }
                f.setOtherPersonal(otherPersonal);

                ArrayList<Airport> airports = new ArrayList<Airport>();
                
                pstmt = con.prepareStatement("Select airport from flightstops where flight = ?;");
                pstmt.setInt(1, f.getNumber());

                ResultSet rs3 = pstmt.executeQuery();
                while (rs3.next()) {

                    Airport a = Controller.Controller.Instance().getAirportByCode(rs3.getString("airport"));
                    if (a != null) {
                        airports.add(a);
                    }
                }
                f.setStops(airports);

                
                flights.put(f.getNumber(), f);
				
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		try{
			PreparedStatement pstmt = con.prepareStatement("Select * from flight;");
           
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
				
				Flight f = flights.get(rs.getInt("flightnumber"));

				Flight rf = flights.get(rs.getInt("returnflight"));
				if(rf != null){
					f.setReturnFlight(rf);
				}		
		}
		
		}catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
		
        return flights;*/
		
	HashMap<Integer, Flight> flights = new HashMap<Integer, Flight>();
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List flightssList = session.createQuery("from Flight").list();
        
        Iterator itr = flightssList.iterator();
        while (itr.hasNext()) {
            
            Model.Flight flight = (Model.Flight) itr.next();
            Flight f = new Flight();
	    
            f.setFlightnumber(flight.getFlightnumber());
	    f.setDate(flight.getDate());
	    f.setAirportByAirportdestination(flight.getAirportByAirportdestination());
	    f.setAirportByAirportfrom(flight.getAirportByAirportfrom());
	    f.setFlight(flight.getFlight());
	    f.setStaffByPilot(flight.getStaffByPilot());
	    f.setStaffByCopilot(flight.getStaffByCopilot());
	    f.setFlight(flight.getFlight());
	    f.setPlane(flight.getPlane());
	    
            flights.put(flight.getFlightnumber(), f);
        }
        return flights;
    }

    public static boolean insertFlight(Flight f){
        /*boolean result = false;

        PreparedStatement pstmt;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String date = sdf.format(f.getDate());

            pstmt = con.prepareStatement("INSERT INTO flight (flightnumber, airportfrom, airportdestination, pilot, copilot, `date`, plane, returnflight) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");

            pstmt.setInt(1, f.getNumber());
            pstmt.setString(2, f.getFrom().getCode());
            pstmt.setString(3, f.getDestination().getCode());


            pstmt.setInt(4, f.getPilots()[0].getNumber());
            pstmt.setInt(5, f.getPilots()[1].getNumber());
            
            pstmt.setString(6, date);
            pstmt.setInt(7, f.getPlane().getNumber());
			if(f.getReturnFlight() != null){
				pstmt.setInt(8, f.getReturnFlight().getNumber());
			}else{
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}
			

            int x = pstmt.executeUpdate();
            if (x == 1) {
                result = true;
            }

            pstmt = con.prepareStatement("SELECT LAST_INSERT_ID();");
            int id = f.getNumber();


            pstmt = con.prepareStatement("INSERT INTO `flightstaff` VALUES(?, ?);");
            pstmt.setInt(1, id);

            for(Staff s : f.getOtherPersonal()){
                pstmt.setInt(2, s.getNumber());
                pstmt.executeUpdate();
            }


            pstmt = con.prepareStatement("INSERT INTO `flightstops` VALUES(?, ?);");
            pstmt.setInt(1, id);

            for(Airport a : f.getStops()){
                pstmt.setString(2, a.getCode());
                pstmt.executeUpdate();
            }
            
         } catch (SQLException ex) {
             System.out.println(""+ex.getMessage());
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        return result;*/
        
        boolean result = true; // todo: add hibernate exception handling
	
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Flight flight = new Flight();
        flight.setFlightnumber(f.getFlightnumber());
        flight.setDate(f.getDate());
        flight.setAirportByAirportdestination(f.getAirportByAirportdestination());
        flight.setAirportByAirportfrom(f.getAirportByAirportfrom());
        flight.setStaffByPilot(f.getStaffByPilot());
        flight.setStaffByCopilot(f.getStaffByCopilot());
        flight.setPlane(f.getPlane());
        flight.setFlight(f.getFlight());
        session.save(flight);
        session.getTransaction().commit();
	
	return result;
    }

    /*public static boolean updateFlight(Flight newFlight, Flight oldFlight){
        boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Update flight set flightnumber = ?, airportfrom = ?, airportdestination = ?, pilot = ?, copilot = ?, `date` = ?, plane = ?, returnflight = ? where flightnumber = ? ;");

            pstmt.setInt(1, newFlight.getNumber());
            pstmt.setString(2, newFlight.getFrom().getCode());
            pstmt.setString(3, newFlight.getDestination().getCode());

            pstmt.setInt(4, newFlight.getPilots()[0].getNumber());
            pstmt.setInt(5, newFlight.getPilots()[1].getNumber());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String date = sdf.format(newFlight.getDate());
            pstmt.setString(6, date);
            pstmt.setInt(7, newFlight.getPlane().getNumber());
			if(newFlight.getReturnFlight() == null){
				pstmt.setNull(8, java.sql.Types.INTEGER);
			}else{
				pstmt.setInt(8, newFlight.getReturnFlight().getNumber());
			}
            pstmt.setInt(9, oldFlight.getNumber());

           
            int x = pstmt.executeUpdate();

            if(x == 1){
                result = true;
            }

            pstmt = con.prepareStatement("DELETE FROM `flightstaff` WHERE `flight` = " + newFlight.getNumber() + ";");
            pstmt.executeUpdate();

            pstmt = con.prepareStatement("INSERT INTO `flightstaff` VALUES(?, ?);");
            pstmt.setInt(1, newFlight.getNumber());

            for(Staff s : oldFlight.getOtherPersonal()){
                pstmt.setInt(2, s.getNumber());
                pstmt.executeUpdate();
            }

            pstmt = con.prepareStatement("DELETE FROM `flightstops` WHERE `flight` = " + newFlight.getNumber() + ";");
            pstmt.executeUpdate();

            pstmt = con.prepareStatement("INSERT INTO `flightstops` VALUES(?, ?);");
            pstmt.setInt(1, newFlight.getNumber());

            for(Airport a : oldFlight.getStops()){
                pstmt.setString(2, a.getCode());
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
*/
    public static boolean deleteFlight(Flight f){
        /*boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Delete from flight where `flightnumber` = ?");
            pstmt.setInt(1, f.getNumber());
            int records = pstmt.executeUpdate();

//            pstmt = con.prepareStatement("DELETE FROM `flightstaff` WHERE `flight` = ?;");
//            pstmt.setInt(1, f.getNumber());
//            pstmt.executeUpdate();
//
//            pstmt = con.prepareStatement("DELETE FROM `flightstops` WHERE `flight` = ?;");
//            pstmt.setInt(1, f.getNumber());
//
//            pstmt.executeUpdate();

            if (records == 1) {
                result = true;
            }
          } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;*/

        boolean result = true;      //todo: Add hibernate exception

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Flight flight = (Flight) session.load(Flight.class, f.getFlightnumber());
        session.delete(flight);
        session.getTransaction().commit();

        return result;
    }

    public static boolean insertAirport(Airport a){
        /*boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Insert into airport values (?,?,?,?);");

            pstmt.setString(1, a.getCode());
            pstmt.setString(2, a.getName());
            pstmt.setString(3 ,a.getCountry());
            pstmt.setString(4, a.getCity());
            
            

            int rowCount = pstmt.executeUpdate();
            if(rowCount == 1){
                result = true;
            }
         } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;*/
        
        boolean result = true; // todo: add hibernate exception handling
	
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Airport airport = new Airport();
	airport.setAirportcode(a.getAirportcode());
        airport.setName(a.getName());
        airport.setCountry(a.getCountry());
        airport.setCity(a.getCity());
        session.save(airport);
        session.getTransaction().commit();
	
	return result;
    }
    
    /*public static boolean updateAirport(Airport airportNew, Airport airportOld) {
        boolean result = false;

        PreparedStatement pstmt;

        try {

            pstmt = con.prepareStatement("update airport set name = ?, city = ?, country = ?, airportcode = ? where airportcode = ?;");

            pstmt.setString(1, airportNew.getName());
            pstmt.setString(2, airportNew.getCity());
            pstmt.setString(3, airportNew.getCountry());
            pstmt.setString(4, airportNew.getCode());
            pstmt.setString(5, airportOld.getCode());

            int rows = pstmt.executeUpdate();

            if (rows == 1) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
*/
    public static boolean deleteAirport(Airport a){
        /*boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Delete from airport where name = ?; ");
            pstmt.setString(1, a.getName());
            int rowcount = pstmt.executeUpdate();

            if(rowcount == 1){
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;*/
        boolean result = true;      //todo: Add hibernate exception

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Airport airport = (Airport) session.load(Airport.class, a.getAirportcode());
        session.delete(airport);
        session.getTransaction().commit();

        return result;
    
    }
    
    public static boolean insertStaff(Staff s){
        /*boolean result = false;
        
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Insert into staff values(?, ?, ?, ?);");
            pstmt.setInt(1, s.getNumber());
            pstmt.setString(2, s.getName());
            pstmt.setString(3, s.getType().toString());
            pstmt.setString(4, s.getPrimaryAirport());

            int rowCount = pstmt.executeUpdate();

            if (rowCount == 1) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;*/
        
        boolean result = true; // todo: add hibernate exception handling
	
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Staff staff = new Staff();
	staff.setStaffnumber(s.getStaffnumber());
        staff.setName(s.getName());
        staff.setAirport(s.getAirport());
        staff.setType(s.getType());
        session.save(staff);
        session.getTransaction().commit();
	
	return result;
    }

    public static boolean updateStaff(Staff newStaff, Staff oldStaff){
        boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Update staff set staffnumber = ?, type = ?, name = ? where staffnumber = ?;");
            pstmt.setInt(1, newStaff.getStaffnumber());
            pstmt.setString(2, newStaff.getType().toString());
            pstmt.setString(3, newStaff.getName());
            pstmt.setInt(4, oldStaff.getStaffnumber());

            int rowCount = pstmt.executeUpdate();

            if(rowCount == 1){
                result = true;
            }            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }


        return result;

    }

    public static boolean deleteStaff(Staff s){
        /*boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Delete from staff where staffnumber = ?;");
            pstmt.setInt(1, s.getStaffnumber());

            int rowCount = pstmt.executeUpdate();

            if(rowCount == 1){
                result = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }


        return result;*/
        
        boolean result = true;      //todo: Add hibernate exception

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Staff staff = (Staff) session.load(Staff.class, s.getStaffnumber());
        session.delete(staff);
        session.getTransaction().commit();

        return result;
        
    }
    
    public static boolean insertPlane(Plane p){
        /*boolean result = false;
        
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Insert into Plane (`capacity`, `planeNumber`, `type`) values (?,?,?);");
            pstmt.setInt(1, p.getCapacity());
            pstmt.setInt(2, p.getNumber());
            pstmt.setString(3, p.getType());
            
            int rowCount = pstmt.executeUpdate();
            
            if(rowCount == 1){
                result = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return result;*/

	
	boolean result = true; // todo: add hibernate exception handling
	
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Plane plane = new Plane();
	plane.setPlanenumber(p.getPlanenumber());
	plane.setCapacity(p.getCapacity());
	plane.setType(p.getType());
        session.save(plane);
        session.getTransaction().commit();
	
	return result;
    }

    public static boolean updatePlane(Plane newPlane, Plane oldPlane){
        /*boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Update Plane set capacity = ?, planenumber = ?, type = ? where planenumber = ?;");
            pstmt.setInt(1, newPlane.getCapacity());
            pstmt.setInt(2, newPlane.getPlanenumber());
            pstmt.setString(3, newPlane.getType());
            pstmt.setInt(4, oldPlane.getPlanenumber());

            int rowCount = pstmt.executeUpdate();
            if(rowCount == 1){
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }


        return result;*/
        
        boolean result = true;
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Plane plane = (Plane)session.load(Plane.class, oldPlane.getPlanenumber());
	//System.out.println("Plane: " + oldPlane.getPlanenumber() + " updated");
        plane.setPlanenumber(newPlane.getPlanenumber());
        plane.setCapacity(newPlane.getCapacity());
        plane.setType(newPlane.getType());
	session.update(plane);
	session.getTransaction().commit();
        
        return result;
    }

    public static boolean deletePlane(Plane p){
        /*boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Delete from Plane where planeNumber = ?;");
            pstmt.setInt(1, p.getNumber());

            int rowCount = pstmt.executeUpdate();

            if(rowCount == 1){
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;*/
        
        boolean result = true;      //todo: Add hibernate exception
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
	Plane plane = (Plane)session.load(Plane.class, p.getPlanenumber());
	session.delete(plane);
	session.getTransaction().commit();
	
        return result;
    }

}
