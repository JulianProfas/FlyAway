/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import HibernateUtil.HibernateUtil;
import Model.Airport;
import Model.Country;
import Model.Flight;
import Model.Plane;
import Model.Staff;
import Model.User;
import java.util.HashMap;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class DatabaseConnectie {

    public static boolean saveObject(Object o) {

        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        

        try {
			
			session.beginTransaction();
            session.save(o);

            if (session.contains(o)) {
                result = true;
            }

            session.getTransaction().commit();

        } catch (HibernateException he) {
			
            System.out.println(he);
        }
        return result;
    }

    public static boolean updateObject(Object o) {

        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        

        try {

			session.beginTransaction();
            session.update(o);

            if (session.contains(o)) {
                result = true;
            }
			
            session.getTransaction().commit();

        } catch (HibernateException he) {
			
            System.out.println(he);
        }
        return result;
    }

    public static boolean deleteObject(Object o) {

        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {

			session.beginTransaction();
            session.delete(o);

            session.getTransaction().commit();

			if (!session.contains(o))
            {
                result = true;
            }
			
        } catch (HibernateException he) {
            System.out.println(he);
        }
        return result;
    }

    public static HashMap<String, User> getUsers() {

        List<User> userList;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        userList = session.createQuery("from User").list();

        HashMap<String, User> users = new HashMap<String, User>();
        for (User i : userList) {
            users.put(i.getUsername(), i);
        }
        return users;
    }

    public static HashMap<String, Country> getCountries() {
        List<Country> countryList;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        countryList = session.createQuery("from Country").list();

        HashMap<String, Country> countries = new HashMap<String, Country>();
        for (Country i : countryList) {
            countries.put(i.getCountryCode(), i);
        }
        return countries;
    }

    public static HashMap<Integer, Plane> getPlanes() {

        List<Plane> planesList;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        planesList = session.createQuery("from Plane").list();

        HashMap<Integer, Plane> planes = new HashMap<Integer, Plane>();
        for (Plane i : planesList) {
            planes.put(i.getNumber(), i);
        }
        return planes;
    }

    public static HashMap<String, Airport> getAirports() {

        List<Airport> airportList;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        airportList = session.createQuery("from Airport").list();

        HashMap<String, Airport> airports = new HashMap<String, Airport>();
        for (Airport i : airportList) {
            airports.put(i.getCode(), i);
        }
        return airports;
    }

    public static HashMap<Integer, Staff> getStaff() {
        List<Staff> staffList;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        staffList = session.createQuery("from Staff").list();

        HashMap<Integer, Staff> staff = new HashMap<Integer, Staff>();
        for (Staff i : staffList) {
            staff.put(i.getNumber(), i);
        }
        return staff;
    }

    public static HashMap<Integer, Flight> getFlights() {
        List<Flight> flightList;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        flightList = session.createQuery("from Flight").list();

        HashMap<Integer, Flight> flights = new HashMap<Integer, Flight>();
        for (Flight i : flightList) {
            flights.put(i.getNumber(), i);
        }
        return flights;
    }
}
