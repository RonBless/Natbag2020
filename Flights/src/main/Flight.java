package main;

import java.sql.Date;
import java.sql.Time;

public class Flight {
	private String company;
	private String flightNum;
	private String Destnaition;
	private Date date;
	private Time time;
	
	public Flight(String company, String Destnaition,String flightNum, Date date, Time time ) {
		this.company = company;
		this.Destnaition = Destnaition;
		this.flightNum = flightNum;
		this.date = date;
		this.time = time;
		
	}
	
	public Date getDate() {
		return date;
	}
	
	public Time getTime() {
		return time;
	}
	
	public int compare(Flight f2) {
		if(date.after(f2.getDate())) 
			return 1;
		if(date.before(f2.getDate())) 
			return -1;
		if(time.after(f2.getTime()))
			return 1;
		if(time.before(f2.getTime())) 
			return -1;
		return 0;
		
	
	}
	
    @SuppressWarnings("deprecation")
	public int getMonth() {
        return this.date.getMonth();
    }
    
	
	public String toString() {
		return "\nCompany: " + company +" , Destnaition: " + Destnaition +" , Flight number: " + flightNum + 
				" , Date: " + date +" , Time: " + time;
		
	}
}
