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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Jeroen
 */
public class DatabaseConnectie {

    public static HashMap<String, User> getUsers() {

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

    public static boolean insertUser(User u) {

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

    public static boolean updateUser(User uNew, User uOld) {

        boolean result = true;  // todo: add hibernate exception handling

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        User user = (User) session.load(User.class, uOld.getUsername());
        user.setUsername(uNew.getUsername());
        user.setPassword(uNew.getPassword());
        user.setRank(uNew.getRank());
        user.setStaff(uNew.getStaff());
        session.update(user);
        session.getTransaction().commit();

        return result;
    }

    public static boolean deleteUser(User u) {

        boolean result = true;      //todo: Add hibernate exception

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.load(User.class, u.getUsername());
        session.delete(user);
        session.getTransaction().commit();

        return result;
    }

    public static HashMap<Integer, Plane> getPlanes() {

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

    public static HashMap<String, Airport> getAirports() {

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

    public static boolean insertFlight(Flight f) {

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
        flight.setStaffs(f.getStaffs());
        session.save(flight);
        session.getTransaction().commit();

        return result;
    }

    public static boolean updateFlight(Flight newFlight, Flight oldFlight) {

        boolean result = true;  // todo: add hibernate exception handling

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Flight flight = (Flight) session.load(Flight.class, oldFlight.getFlightnumber());

        flight.setFlightnumber(newFlight.getFlightnumber());
        flight.setDate(newFlight.getDate());
        flight.setAirportByAirportdestination(newFlight.getAirportByAirportdestination());
        flight.setAirportByAirportfrom(newFlight.getAirportByAirportfrom());
        flight.setStaffByPilot(newFlight.getStaffByPilot());
        flight.setStaffByCopilot(newFlight.getStaffByCopilot());
        flight.setPlane(newFlight.getPlane());
        flight.setFlight(newFlight.getFlight());
        session.update(flight);
        session.getTransaction().commit();

        return result;
    }

    public static boolean deleteFlight(Flight f) {

        boolean result = true;      //todo: Add hibernate exception

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Flight flight = (Flight) session.load(Flight.class, f.getFlightnumber());
        session.delete(flight);
        session.getTransaction().commit();

        return result;
    }

    public static boolean insertAirport(Airport a) {

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

    public static boolean updateAirport(Airport airportNew, Airport airportOld) {

        boolean result = true;  // todo: add hibernate exception handling

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Airport airport = (Airport) session.load(Airport.class, airportOld.getAirportcode());

        airport.setAirportcode(airportNew.getAirportcode());
        airport.setName(airportNew.getName());
        airport.setCountry(airportNew.getCountry());
        airport.setCity(airportNew.getCity());
        session.update(airport);
        session.getTransaction().commit();

        return result;
    }

    public static boolean deleteAirport(Airport a) {

        boolean result = true;      //todo: Add hibernate exception

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Airport airport = (Airport) session.load(Airport.class, a.getAirportcode());
        session.delete(airport);
        session.getTransaction().commit();

        return result;
    }

    public static boolean insertStaff(Staff s) {

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

    public static boolean updateStaff(Staff newStaff, Staff oldStaff) {

        boolean result = true;  // todo: add hibernate exception handling

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Staff staff = (Staff) session.load(Staff.class, oldStaff.getStaffnumber());
        staff.setStaffnumber(newStaff.getStaffnumber());
        staff.setName(newStaff.getName());
        staff.setType(newStaff.getType());
        staff.setAirport(newStaff.getAirport());
        session.update(staff);
        session.getTransaction().commit();

        return result;

    }

    public static boolean deleteStaff(Staff s) {

        boolean result = true;      //todo: Add hibernate exception

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Staff staff = (Staff) session.load(Staff.class, s.getStaffnumber());
        session.delete(staff);
        session.getTransaction().commit();

        return result;

    }

    public static boolean insertPlane(Plane p) {

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

    public static boolean updatePlane(Plane newPlane, Plane oldPlane) {

        boolean result = true;  // todo: add hibernate exception handling

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Plane plane = (Plane) session.load(Plane.class, oldPlane.getPlanenumber());
        plane.setPlanenumber(newPlane.getPlanenumber());
        plane.setCapacity(newPlane.getCapacity());
        plane.setType(newPlane.getType());
        session.update(plane);
        session.getTransaction().commit();

        return result;
    }

    public static boolean deletePlane(Plane p) {

        boolean result = true;      //todo: Add hibernate exception

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Plane plane = (Plane) session.load(Plane.class, p.getPlanenumber());
        session.delete(plane);
        session.getTransaction().commit();

        return result;
    }
}
