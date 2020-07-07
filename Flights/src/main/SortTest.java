package main;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;



public class SortTest {
	ArrayList<Flight> flights;
	Date date;
	Time time;
//	@Test
//	public void test() {
//		flights = new ArrayList<Flight>();
//		Date date = new Date(2020,7,1);
//		Time time = new Time(19,30,0);
//		String allflight = null;
//
//		flights.add(new LandingsFlight("El Al","New York" , "e15", date ,  time));
//		flights.add(new LandingsFlight("El Al","New York" , "e15", date ,  time));
//		allflight = flights.toString().replace('[', ' ').replace(']', ' ');
//		assertEquals(Main.showAllFlights(flights), allflight); // Check addFlight.
//		
//	}
	
	@Test 
	public void ReadFromFileTest() throws NumberFormatException, IOException {
		Date date = new Date(121,0,1);
		Time time = new Time(1,1,0);
		flights = new ArrayList<Flight>();
		flights.add(new DepartureFlight("El Al ","New York " , "001", date ,  time));
		Date date1 = new Date(121,1,2);
		Time time1 = new Time(2,2,0);
		flights.add(new DepartureFlight("El Al ","Amsterdam " , "002", date1 ,  time1));
		flights.add(new LandingsFlight("America AirLines ", "Los Angels " ,"003", date, time1));
		ArrayList<Flight> FlightList = new ArrayList<Flight>();
		Main.readFromFile(FlightList);
		assertEquals(Main.showAllFlights(FlightList), Main.showAllFlights(flights)); // Check addFlight.
	}
	

}
