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
		Date date = new Date(121,0,1);
		Time time = new Time(1,1,0);
		flights.add(new Flight("El-Al","New_York" , "001", date ,  time));
		Date date1 = new Date(121,1,2);
		Time time1 = new Time(2,2,0);
		flights.add(new Flight("El-Al","Amsterdam" , "002", date1 ,  time1));

		
		
		assertEquals(flights.toString(),"[Company: El-Al, Destnaition: New_York, Flight number: 001, Date: 2021-01-01, Time: 01:01:00, " + 
				"Company: El-Al, Destnaition: Amsterdam, Flight number: 002, Date: 2021-02-02, Time: 02:02:00]");


	}

}
