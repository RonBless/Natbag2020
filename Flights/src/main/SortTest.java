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

	@Test
	public void ReadFromFileTest() throws NumberFormatException, IOException {
		Date date = new Date(121, 0, 1);
		Time time = new Time(1, 1, 0);
		flights = new ArrayList<Flight>();
		flights.add(new DepartureFlight("El Al ", "New York ", "001", date, time));
		Date date1 = new Date(121, 1, 2);
		Time time1 = new Time(2, 2, 0);
		flights.add(new DepartureFlight("El Al ", "Amsterdam ", "002", date1, time1));
		flights.add(new LandingsFlight("America AirLines ", "Los Angels ", "003", date, time1));
		ArrayList<Flight> FlightList = new ArrayList<Flight>();
		Main.readFromFile(FlightList);
		assertEquals(Main.showAllFlights(FlightList), Main.showAllFlights(flights)); // Check addFlight.
	}

	@Test
	public void addFlightTest() {
		flights = new ArrayList<Flight>();
		Date date1 = new Date(121, 0, 1);
		Time time1 = new Time(1, 1, 0);
		Date date2 = new Date(121, 1, 2);
		Time time2 = new Time(2, 2, 0);
		String allflight = null;
		flights.add(new DepartureFlight("El Al", "New York", "001", date1, time1));
		flights.add(new DepartureFlight("El Al", "Amsterdam", "002", date2, time2));
		flights.add(new LandingsFlight("America AirLines", "Los Angels", "003", date1, time2));

		allflight = flights.toString().replace('[', ' ').replace(']', ' ');
		assertEquals(Main.showAllFlights(flights), allflight); // Check addFlight.
	}
	
	@Test
	public void searchByMonthTest() {
		String allflight = null;
		flights = new ArrayList<Flight>();
		Date date1 = new Date(121, 0, 1); //1900 + 121 year
		Time time1 = new Time(1, 1, 0);
		Date date2 = new Date(121, 2, 2);
		Time time2 = new Time(2, 2, 0);
		
		flights.add(new DepartureFlight("ElAl", "New York", "001", date1, time1));
		flights.add(new DepartureFlight("ElAl", "Amsterdam", "002", date1, time2));
		LandingsFlight flight1 = new LandingsFlight("America AirLines", "Los Angels", "003", date2, time2);
		flights.add(flight1);
		allflight = flight1.toString().replace('[', ' ').replace(']', ' ');

		assertEquals(Main.SearchByMonth(2, flights),allflight);
	}

	@Test
	public void removeFlightTest() {
		flights = new ArrayList<Flight>();
		Date date = new Date(121,0,1);
		Time time = new Time(1,1,0);
		Date date1 = new Date(121,1,2);
		Time time1 = new Time(2,2,0);
		flights.add(new DepartureFlight("ElAl","Amsterdam" , "002", date1 ,  time1));
		flights.add(new LandingsFlight("America AirLines", "Los Angels" ,"003", date, time1));
		flights.add(new LandingsFlight("America12", "New York" ,"005", date, time1));
		LandingsFlight.add(new LandingsFlight("America12", "New York" ,"005", date, time1));
		assertEquals(Main.removeFlight("005", flights, true), true); // Check removeFlight
	}
}