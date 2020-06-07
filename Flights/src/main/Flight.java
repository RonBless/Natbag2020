package main;

import java.sql.Date;
import java.sql.Time;
import java.util.Comparator;

public class Flight {
	protected String company;
	protected String flightNum;
	protected String Destination;
	protected Date date;
	protected Time time;

	public Flight(String company, String Destination, String flightNum, Date date, Time time) {
		this.company = company;
		this.Destination = Destination;
		this.flightNum = flightNum;
		this.date = date;
		this.time = time;

	}

	public String getFlightNum() {
		return flightNum;
	}

	public Date getDate() {
		return date;
	}

	public Time getTime() {
		return time;
	}

	public String getDestination() {
		return Destination;
	}

	public int compare(Flight f2) {
		if (date.after(f2.getDate()))
			return 1;
		if (date.before(f2.getDate()))
			return -1;
		if (time.after(f2.getTime()))
			return 1;
		if (time.before(f2.getTime()))
			return -1;
		return 0;

	}

	@SuppressWarnings("deprecation")
	public int getMonth() {
		return this.date.getMonth();
	}

	public String toString() {
		return "\nCompany: " + company + " , Destination: " + Destination + " , Flight number: " + flightNum
				+ " , Date: " + date + " , Time: " + time;

	}
}
