package main;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Comparator;

public class LandingsFlight extends Flight {
	private static ArrayList <LandingsFlight> landingList;
	private String origin;
	public LandingsFlight(String company, String destination, String flightNum, Date date, Time time) {
		super(company, "Tel Aviv", flightNum, date, time);
		origin = destination;
	}

	public static boolean add(LandingsFlight a) {
		try {
			landingList.add(a);
			return true;
		}
		catch(Exception e) {
			landingList = new ArrayList<LandingsFlight>();
			add(a);
			return true;
		}
	}

	public static boolean sort(Comparator<Flight> c) {
		try {
			landingList.sort(c);
			return true;
		}
		catch(Exception e) {
			System.out.println("List is empty cannot sort");
			return false;
		}
		
		
	}

	public static String show() {
		return(landingList.toString().replace('[', ' ').replace(']', ' '));

	}

	public String toString() {
		return "\nCompany: " + company +" , Origin: " + origin +" , Flight number: " + flightNum + 
				" , Date: " + date +" , Time: " + time;
	}	


}
