package main;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Comparator;

public class DepartureFlight extends Flight {
	private static ArrayList <DepartureFlight> departureList;

	public DepartureFlight(String company, String destination, String flightNum, Date date, Time time) {
		super(company, destination, flightNum, date, time);
	}

	public static boolean add(DepartureFlight a) {
		try {
			departureList.add(a);
			return true;
		}
		catch(Exception e) {
			departureList = new ArrayList<DepartureFlight>();
			add(a);
			return true;
		}
	}

	public static boolean sort(Comparator<Flight> c) {
		try {
			departureList.sort(c);
			return true;
		}
		catch(Exception e) {
			System.out.println("Cannot sort no flights");
			return false;
		}
	}

	public static String show() {
		return(departureList.toString().replace('[', ' ').replace(']', ' '));

	}
}
