/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import Model.Airport;
import Model.Flight;
import Model.Plane;
import Model.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static HashMap<Integer, Plane> getPlanes(){
        HashMap<Integer, Plane> planes = new HashMap<Integer, Plane>();

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
        return planes;
    }

    public static HashMap<String, Airport> getAirports(){
        HashMap<String, Airport> airports = new  HashMap<String, Airport>();
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
        return airports;
    }

    public static HashMap<Integer, Staff> getStaff(){
       HashMap<Integer, Staff> staff = new HashMap<Integer, Staff>();

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
        return staff;
    }

    public static HashMap<Integer, Flight> getFlights() {
        HashMap<Integer, Flight> flights = new HashMap<Integer, Flight>();

        try {
            PreparedStatement pstmt = con.prepareStatement("Select * from flight;");
           
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Flight f = new Flight();
                f.setNumber(rs.getInt("flightnumber"));
                SimpleDateFormat sdf = new SimpleDateFormat(Flight.FlightDateFormat);
                try {
                    f.setDate(sdf.parse(rs.getString("date")));
                } catch (ParseException ex) {
                    Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
                    continue;
                }

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
        return flights;
    }

    public static boolean insertFlight(Flight f){
        boolean result = false;

        PreparedStatement pstmt;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(Flight.FlightDateFormat);
            String date = sdf.format(f.getDate());
//            String query = "INSERT INTO flight (flightnumber, airportNameFrom, airportNameDestination, pilotNumber, copilotNumber, `Date`, planeNumber) VALUES ("+ f.getNumber()+", \""+ f.getFrom().getName() + "\", \""+ f.getDestination().getName()+ "\","+ f.getPilots()[0].getNumber() + ", "+ f.getPilots()[1].getNumber() +", \""+ date +"\", "+ f.getPlane().getNumber() +");";
//            System.out.println(""+query);
//            pstmt = con.prepareStatement(query);

            pstmt = con.prepareStatement("INSERT INTO flight (flightnumber, airportNameFrom, airportNameDestination, pilotNumber, copilotNumber, `Date`, planeNumber) VALUES (?, ?, ?, ?, ?, ?, ?);");

            pstmt.setInt(1, f.getNumber());
            pstmt.setString(2, f.getFrom().getName());
            pstmt.setString(3, f.getDestination().getName());


            pstmt.setInt(4, f.getPilots()[0].getNumber());
            pstmt.setInt(5, f.getPilots()[1].getNumber());
            
            pstmt.setString(6, date);
            pstmt.setInt(7, f.getPlane().getNumber());

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

        return result;
    }

    public static boolean updateFlight(Flight newFlight, Flight oldFlight){
        boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Update flight set flightnumber = ?, airportNameFrom = ?, airportNameDestination = ?, pilotNumber = ?, copilotNumber = ?, `Date` = ?, planeNumber = ? where flightnumber = ? ;");

            pstmt.setInt(1, newFlight.getNumber());
            pstmt.setString(2, newFlight.getFrom().getName());
            pstmt.setString(3, newFlight.getDestination().getName());

            pstmt.setInt(4, newFlight.getPilots()[0].getNumber());
            pstmt.setInt(5, newFlight.getPilots()[1].getNumber());
            SimpleDateFormat sdf = new SimpleDateFormat(Flight.FlightDateFormat);
            String date = sdf.format(newFlight.getDate());
            pstmt.setString(6, date);
            pstmt.setInt(7, newFlight.getPlane().getNumber());
            pstmt.setInt(8, oldFlight.getNumber());

           
            int x = pstmt.executeUpdate();

            if(x == 1){
                result = true;
            }

            pstmt = con.prepareStatement("DELETE FROM `flightstaff` WHERE `flightNumber` = " + newFlight.getNumber() + ";");
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

    public static boolean deleteFlight(Flight f){
        boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Delete from flight where `flight` = ?");
            pstmt.setInt(1, f.getNumber());
            int records = pstmt.executeUpdate();

            pstmt = con.prepareStatement("DELETE FROM `flightstaff` WHERE `flight` = ?;");
            pstmt.setInt(1, f.getNumber());
            pstmt.executeUpdate();

            pstmt = con.prepareStatement("DELETE FROM `flightstops` WHERE `flightnumber` = ?;");
            pstmt.setInt(1, f.getNumber());

            pstmt.executeUpdate();

            if (records == 1) {
                result = true;
            }
          } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;

    }

    public static boolean insertAirport(Airport a){
        boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Insert into airport values (?,?,?,?);");

            pstmt.setString(1, a.getName());
            pstmt.setString(2, a.getCity());
            pstmt.setString(3,a.getCountry());
            pstmt.setString(4, a.getCode());

            int rowCount = pstmt.executeUpdate();
            if(rowCount == 1){
                result = true;
            }
         } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static boolean updateAirport(Airport airportNew, Airport airportOld) {
        boolean result = false;

        PreparedStatement pstmt;

        try {

            pstmt = con.prepareStatement("update airport set name = ?, city = ?, country = ?, code = ? where name = ?;");

            pstmt.setString(1, airportNew.getName());
            pstmt.setString(2, airportNew.getCity());
            pstmt.setString(3, airportNew.getCountry());
            pstmt.setString(4, airportNew.getCode());
            pstmt.setString(5, airportOld.getName());

            int rows = pstmt.executeUpdate();

            if (rows == 1) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static boolean deleteAirport(Airport a){
        boolean result = false;

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
        return result;
    }
    
    public static boolean insertStaff(Staff s){
        boolean result = false;
        
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Insert into staff values(?, ?, ?);");
            pstmt.setInt(1, s.getNumber());           
            pstmt.setString(2, s.getType().toString());
             pstmt.setString(3, s.getName());

             int rowCount = pstmt.executeUpdate();

             if(rowCount == 1){
                 result = true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }

    public static boolean updateStaff(Staff newStaff, Staff oldStaff){
        boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Update staff set staffnumber = ?, type = ?, name = ? where staffnumber = ?;");
            pstmt.setInt(1, newStaff.getNumber());
            pstmt.setString(2, newStaff.getType().toString());
            pstmt.setString(3, newStaff.getName());
            pstmt.setInt(4, oldStaff.getNumber());

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
        boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Delete from staff where staffnumber = ?;");
            pstmt.setInt(1, s.getNumber());

            int rowCount = pstmt.executeUpdate();

            if(rowCount == 1){
                result = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }


        return result;
    }
    
    public static boolean insertPlane(Plane p){
        boolean result = false;
        
        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Insert into Plane (`capacity`, `planeNumber`, `type`) values (?,?,?);");
            pstmt.setInt(1, p.getCapacity());
            pstmt.setInt(2, p.getCapacity());
            pstmt.setString(3, p.getType());
            
            int rowCount = pstmt.executeUpdate();
            
            if(rowCount == 1){
                result = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return result;        
    }

    public static boolean updatePlane(Plane newPlane, Plane oldPlane){
        boolean result = false;

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement("Update Plane set capacity = ?, planenumber = ?, type = ? where planenumber = ?;");
            pstmt.setInt(1, newPlane.getCapacity());
            pstmt.setInt(2, newPlane.getNumber());
            pstmt.setString(3, newPlane.getType());
            pstmt.setInt(4, oldPlane.getNumber());

            int rowCount = pstmt.executeUpdate();
            if(rowCount == 1){
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectie.class.getName()).log(Level.SEVERE, null, ex);
        }


        return result;
    }

    public static boolean deletePlane(Plane p){
        boolean result = false;

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
        return result;
    }

}
