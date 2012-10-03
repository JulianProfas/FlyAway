/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.ArrayList;
import Model.PersonalType;
import Model.Country;
import HibernateUtil.HibernateUtil;


import Model.Airport;
import Model.Flight;
import Model.Plane;
import Model.Rank;
import Model.Staff;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tom
 */
public class MappingTest {
	
	public MappingTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}
	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	// @Test
	// public void hello() {}
	
//	@Test
//	public void saveAndRetrieveCountry(){
//	
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		
//		Country c = new Country("AA", 111, "Country Test");
//		
//		List<Country> result =null;
//		boolean victory = true;
//		Country test = null;
//		
//		try{
//			
//			session.save(c);
//			result = session.createQuery("from Country c where c.countryCode = 'AA'").list();
//			session.getTransaction().commit();
//			
//			if(result == null || result.size() != 1){
//				victory = false;
//			}else{
//				test = result.get(0);
//				if(!test.getCountryCode().equals("AA") && !test.getName().equals("Country Test") && test.getRegionCode() != 111){
//					victory = false;
//				}
//			}
//			
//		}catch(HibernateException he){
//			session.getTransaction().rollback();
//			assertTrue(false);
//		}
//		assertTrue(victory);
//	}
//	
//	
//	@Test
//	public void saveAndRetrievePlane(){
//	
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		
//		Plane p = new Plane(1, "ufo", 3);
//		
//		List<Plane> result;
//		Plane test = null;
//		boolean victory = true;
//		
//		try{
//		
//			session.save(p);
//			result = session.createQuery("from Plane p where p.number = 1").list();
//			session.getTransaction().commit();
//			
//			if(result == null || result.size() != 1){
//				victory = false;
//			}else{
//				test = result.get(0);
//				if(test.getNumber() != 1){
//					victory = false;
//				}
//			}
//			
//		}catch(HibernateException he){
//			session.getTransaction().rollback();
//			assertTrue(false);
//		}
//		
//		assertTrue(victory);
//		
//	}
//	
//	@Test
//	public void saveAndRetrieveAirport(){
//	
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		
//		Country c = new Country("BB", 222, "Country Test");
//		Airport a = new Airport("AAA", "Test Airport", c, "Test City");
//		
//		List<Airport> result = null;
//		Airport test = null;
//		boolean victory = true;
//		
//		System.out.println(a.toString());
//		try{
//		
//			session.save(a);
//			result = session.createQuery("from Airport a where a.code = 'AAA'").list();
//			session.getTransaction().commit();
//			
//			if(result == null || result.size() != 1){
//				victory = false;
//			}else{
//				test = result.get(0);
//				if(!test.getCode().equals("AAA") || !test.getName().equals("Test Airport") || !test.getCountry().getCountryCode().equals("BB") || !test.getCity().equals("Test City")){
//					victory = false;
//				}
//			}
//			
//		}catch(HibernateException he){
//			session.getTransaction().rollback();
//			assertTrue(false);
//		}
//		
//		assertTrue(victory);
//		
//	}
	
//	@Test
//	public void saveAndRetrieveStaff(){
//	
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		
//		Country c = new Country("CC", 333, "Country Test");
//		Airport a = new Airport("BBB", "Test Airport", c, "Test City");
//		Staff s = new Staff(1, PersonalType.Pilot, "Piet", a);
//		
//		List<Staff> result = null;
//		Staff test = null;
//		boolean victory = true;
//		
//		try{
//		
//			session.save(s);
//			result = session.createQuery("from Staff s where s.number = 1").list();
//			session.getTransaction().commit();
//			
//			if(result == null || result.size() != 1){
//				System.out.println("1");
//				victory = false;
//			}else{
//				test = result.get(0);
//				if(test.getNumber() != 1 || !test.getName().equals("Piet") || !test.getPrimaryAirport().getCode().equals("BBB") || !test.getType().equals(PersonalType.Pilot)){
//					System.out.println("2");
//					victory = false;
//				}
//			}
//			
//		}catch(HibernateException he){
//			session.getTransaction().rollback();
//			assertTrue(false);
//		}
//		
//		assertTrue(victory);
//		
//	}
	
//	@Test
//	public void saveAndRetrieveUser(){
//	
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		
//		User u = new User("test", "test", Rank.user);
//		
//		List<User> result = null;
//		User test = null;
//		boolean victory = true;
//		
//		try{
//		
//			session.save(u);
//			result = session.createQuery("from User u where u.username = 'test'").list();
//			session.getTransaction().commit();
//			
//			if(result == null || result.size() != 1){
//				System.out.println("1");
//				victory = false;
//			}else{
//				test = result.get(0);
//				if(!test.getUsername().equals("test") || !test.getPassword().equals("test") || !test.getRank().equals(Rank.user)){
//					System.out.println("2");
//					victory = false;
//				}
//			}
//			
//		}catch(HibernateException he){
//			session.getTransaction().rollback();
//			assertTrue(false);
//		}
//		
//		assertTrue(victory);
//		
//	}
	
	@Test
	public void saveAndRetrieveFlight(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Country c = new Country("CC", 333, "Country Test");
		Airport a1 = new Airport("BBB", "Test Airport", c, "Test City");
		Airport a2 = new Airport("CCC", "Test Airport", c, "Test City");
		Airport a3 = new Airport("DDD", "Test Airport", c, "Test City");
		Airport a4 = new Airport("EEE", "Test Airport", c, "Test City");
		Staff s1 = new Staff(1, PersonalType.Pilot, "Piet", a1);
		Staff s2 = new Staff(2, PersonalType.Pilot, "Henk", a2);
		Staff s3 = new Staff(3, PersonalType.Stewardess, "Arie", a3);
		Staff s4 = new Staff(4, PersonalType.Stewardess, "Loes", a2);
		Plane p = new Plane(1, "ufo", 8);
		//List<Staff> staff = new ArrayList<Staff>();
		//staff.add(s3);
		//staff.add(s4);
		//List<Airport> stops = new ArrayList<Airport>();
		//stops.add(a3);
		//stops.add(a4);
		
		Flight f = new Flight(a1, a2, 1, s1, s2, p);
		
		List<Flight> result = null;
		Flight test = null;
		boolean victory = true;
		
//		try{
//		
			session.save(f);
			//result = session.createQuery("from User u where u.username = 'test'").list();
			session.getTransaction().commit();
			
//			if(result == null || result.size() != 1){
//				System.out.println("1");
//				victory = false;
//			}else{
//				test = result.get(0);
//				if(!test.getUsername().equals("test") || !test.getPassword().equals("test") || !test.getRank().equals(Rank.user)){
//					System.out.println("2");
//					victory = false;
//				}
//			}
//			
//		}catch(HibernateException he){
//			session.getTransaction().rollback();
//			assertTrue(false);
//		}
//		
//		assertTrue(victory);
		
	}
	
}
