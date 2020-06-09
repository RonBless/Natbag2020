package main;

import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;



public class SortTest {

	@Test
	public void test() {
		ArrayList<Flight> flights = new ArrayList<Flight>();
		Date date = new Date(2020,7,1);
		Time time = new Time(19,30,0);
		String allflight = null;

		flights.add(new LandingsFlight("El Al","New York" , "e15", date ,  time));
		flights.add(new LandingsFlight("El Al","New York" , "e15", date ,  time));
		allflight = flights.toString().replace('[', ' ').replace(']', ' ');
		assertEquals(Main.showAllFlights(flights), allflight); // Check addFlight.
		
		
		


	}

}
