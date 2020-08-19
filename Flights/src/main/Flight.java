package main;

import java.sql.Date;
import java.sql.Time;

public class Flight {
	protected int day;
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
		day = date.getDay();

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

	public String getCompany() {
		return company;
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

	public String getDayInString() {
		switch(day) {
		case 0:
			return "Sunday";
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";
		default:
			return "error";
		}
	}

	public String toString() {
		return "\nCompany: " + company + " , Destination: " + Destination + " , Flight number: " + flightNum
				+ " , Date: " + date + " , Time: " + time;

	}
}
