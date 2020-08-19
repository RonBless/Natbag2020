package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.Comparator;


public class Main {

	public static void main(String[] args) throws IOException {
		File f = new File("All Flights.txt");
		ArrayList<Flight> FlightList = new ArrayList<Flight>();
		Scanner s = new Scanner(System.in);
		Comparator<Flight> ComparFlights = new Comparator <Flight>(){

			public int compare(Flight f1, Flight f2) {
				return f1.compare(f2);
			}
		};
		Date date = new Date(121,0,1);
		Time time = new Time(1,1,0);
		Date date1 = new Date(121,1,2);
		Time time1 = new Time(2,2,0);
		FlightList.add(new DepartureFlight("El Al","Amsterdam" , "002", date1 ,  time1));
		DepartureFlight.add(new DepartureFlight("El Al","Amsterdam" , "002", date1 ,  time1));
		FlightList.add(new LandingsFlight("America AirLines", "Los Angels" ,"003", date, time1));
		LandingsFlight.add((new LandingsFlight("America AirLines", "Los Angels" ,"003", date, time1)));

		if(args.length>0) {
			boolean isHtml = args[0].equalsIgnoreCase("html");
			boolean isDepartures = args.length > 1 && args[1].equalsIgnoreCase("departures");
			if (isDepartures) {
				System.out.println("Departure 1");
				if (isHtml) System.out.println("<br>");
				System.out.println("Departure 3");
				if (isHtml) System.out.println("<br>");
			}
			else {
				System.out.println("Arrival 1");
				if (isHtml) System.out.println("<br>");
				System.out.println("Arrival 2");
				if (isHtml) System.out.println("<br>");
			}
		}
		else {

			while(Menu(s, FlightList, ComparFlights, f)) {

			}
		}

	}





	public static boolean Menu (Scanner s, ArrayList<Flight> FlightList, Comparator<Flight> ComparFlights, File f) throws IOException {
		String flightnum; //for remove flight.
		System.out.println("Please enter your choice: ");
		System.out.println("1- Add a new flight\n2- Remove a flight\n3- Show all flight\n4- save to file\n5- read from file\n6- Search by month \n7- Show flights by destination\n8- exit");
		String input = s.next();
		switch(input){
		case "1": // add new flight
			System.out.println("Is it a landing or a departure ");
			switch(s.next()) {
			case "landing":
				addNewFlight(s, FlightList, ComparFlights, true); // true = landing
				break;
			case "departure":
				addNewFlight(s, FlightList, ComparFlights, false); // false = departure
				break;
			default:
				System.out.println("Wrong input");
				break;
			}
			return true;
		case "2": // Remove flight
			System.out.println("Is it a Landing or a Departure ");
			switch (s.next()) {
			case "landing":
				System.out.println("Enter the flight number");
				flightnum = s.next();
				removeFlight(flightnum,FlightList, true);
				break;
			case "departure":
				System.out.println("Enter the flight number");
				flightnum = s.next();
				removeFlight(flightnum, FlightList, false);
				break;
			default:
				System.out.println("Wrong input");
				break;
			}
		case "3": // show all flights
			System.out.println(showAllFlights(FlightList));
			return true;
		case "4": // save to file
			saveToFile(FlightList, f);
			return true;
		case "5": // read from file
			readFromFile(FlightList);
			return true;
		case "6": // search by month
			System.out.println("Enter the month number you want to see");
			int month = s.nextInt()-1;
			System.out.println(SearchByMonth (month,FlightList)+"\n");
			return true;
		case "7": //show flights by destination
			System.out.println(showByDestination(s, FlightList));
			return true;
		case "8":
			return false;
		default:
			System.out.println("Please enter a vaild option\n");
			return true;

		}
	}

	public static void addNewFlight(Scanner s, ArrayList<Flight> FlightList, Comparator<Flight> ComparFlights, boolean check) {
		System.out.println("Please Enter the flight time: (hours, min)");
		Time time = new Time(s.nextInt(), s.nextInt(), 0);
		System.out.println("Please Enter the flight date: (year, month and then day)");
		Date date = new Date(s.nextInt() - 1900, s.nextInt()-1, s.nextInt()); // year is +1901 in the date constractour
		s.nextLine(); // must do because of the s.nextint() 
		if(check) {
			System.out.println("Now please enter the Air Line name, Origin and  flight number");
			LandingsFlight f = new LandingsFlight(s.nextLine(), s.nextLine(),s.next(), date, time);
			LandingsFlight.add(f);
			LandingsFlight.sort(ComparFlights);
			System.out.println(f + "\nFlight has been added\n");
			FlightList.add(f);
		}
		else {
			System.out.println("Now please enter the Air Line name, Destination and  flight number");
			DepartureFlight f = new DepartureFlight(s.nextLine(), s.nextLine(),s.next(), date, time);
			DepartureFlight.add(f);
			DepartureFlight.sort(ComparFlights);
			System.out.println(f + "\nFlight has been added\n");
			FlightList.add(f);
		}

		FlightList.sort(ComparFlights);


	}

	public static boolean removeFlight(String flightNum, ArrayList<Flight> FlightList,boolean check) {
		ArrayList<DepartureFlight> flightListDeparture = DepartureFlight.getArry();
		ArrayList<LandingsFlight> flightListLanding = LandingsFlight.getArry();
		if (check) {
			for (int i = 0; i < flightListLanding.size(); i++) {
				if (flightListLanding.get(i).getFlightNum().equals(flightNum)) {
					FlightList.remove(flightListLanding.get(i));
					flightListLanding.remove(i);
					System.out.println(flightNum+ " Flight has been removed\n");
					return true;
				}
			}
			System.out.println("No landing flight with this number");
			return false;
		}
		else {
			for (int j = 0; j < FlightList.size(); j++) {
				if (flightListDeparture.get(j).getFlightNum().equals(flightNum)) {
					FlightList.remove(flightListDeparture.get(j));
					flightListDeparture.remove(j);
					System.out.println(flightNum+ " Flight has been removed\n");
					return true;
				}
			}
			System.out.println("No departure flight with this number");
			return false;
		}
	}



	public static String showAllFlights(ArrayList<Flight> FlightList) {
		return (FlightList.toString().replace('[', ' ').replace(']', ' '));

	}

	public static void saveToFile(ArrayList<Flight> FlightList, File f) throws IOException {
		f.createNewFile();
		PrintWriter pw = new PrintWriter(f);
		pw.print(FlightList.toString().replace('[', ' ').replace(']', ' '));
		pw.close();
		System.out.println("Saved Successfully");
	}

	public static void readFromFile(ArrayList<Flight> FlightList) throws NumberFormatException, IOException {
		File f = new File("ReadTest.txt");
		String company= null;
		String flightNum= null;
		String destination = null;
		Date date = null;
		Time time = null;
		boolean check=false;
		if(f.exists()) {
			Scanner s = new Scanner(f);
			while(s.hasNext()) {
				String temp = s.next();
				switch(temp){
				case "Company:":
					String stop = s.next();
					StringBuffer sb = new StringBuffer();
					while(!stop.equals(",")) { // works with
						sb.append(stop);
						sb.append(" ");
						stop = s.next();
					}
					company = sb.toString();
					break;
				case "Destination:":
					stop = s.next();
					sb = new StringBuffer();
					while(!stop.equals(",")) { // works with
						sb.append(stop);
						sb.append(" ");
						stop = s.next();
					}
					destination = sb.toString();
					break;
				case "Origin:":
					stop = s.next();
					sb = new StringBuffer();
					while(!stop.equals(",")) { // works with
						sb.append(stop);
						sb.append(" ");
						stop = s.next();
						check = true; // check for departure or landing.

					}
					destination = sb.toString();
					break;
				case "number:":
					flightNum = s.next();
					break;
				case "Date:":
					String dataAsString = s.next();
					String [] data = dataAsString.split("-");
					date = new Date(Integer.parseInt(data[0]) - 1900, Integer.parseInt(data[1])-1, Integer.parseInt(data[2])); // year is +1901 in the date constractour
					break;
				case "Time:":
					dataAsString = s.next();
					data = dataAsString.split(":");
					time = new Time(Integer.parseInt(data[0]), Integer.parseInt(data[1]), 0);
					break;
				default:
					break;
				}

				if(temp.equals("Time:")) {
					if(check){
						LandingsFlight flight = new LandingsFlight(company, destination, flightNum, date, time);
						LandingsFlight.add(flight);
						FlightList.add(flight);
						check = false;

					}
					else {
						DepartureFlight flight = new DepartureFlight(company, destination, flightNum, date, time);
						DepartureFlight.add(flight);
						FlightList.add(flight);
					}

				}
			}
			s.close();
			System.out.println("\nData transferd successfully\n");
		}
	}
	

	public static String SearchByMonth (int month,ArrayList<Flight> FlightList) {
		StringBuffer sb = new StringBuffer();
		for(int j=0;j<FlightList.size();j++) {
			if(FlightList.get(j).getMonth()<=month) {
				if (FlightList.get(j).getMonth()==month) {
					sb.append(FlightList.get(j).toString());
				}
			}
		}
		return sb.toString();
	}

	public static String showByDestination(Scanner s, ArrayList<Flight> FlightList) {
		StringBuffer sb = new StringBuffer();
		System.out.println("Hello, please enter your flight destination");
		String dest = s.next();
		for (int i = 0; i < FlightList.size(); i++) {
			if (dest.equals(FlightList.get(i).getDestination())) {
				sb.append(FlightList.get(i));
			}
		}
		return sb.toString();
	}

}

