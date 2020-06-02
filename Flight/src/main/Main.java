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
		FlightList.add(new Flight("El Al","New York" , "001", date ,  time));
		Date date1 = new Date(121,1,2);
		Time time1 = new Time(2,2,0);
		FlightList.add(new Flight("El Al","Amsterdam" , "002", date1 ,  time1));

		while(Menu(s, FlightList, ComparFlights, f)) {

		}

	}





	public static boolean Menu (Scanner s, ArrayList<Flight> FlightList, Comparator<Flight> ComparFlights, File f) throws IOException {
		System.out.println("Please enter your choice: ");
		System.out.println("1- Add a new flight\n2- Remove a flight\n3- Show all flight\n4- save to file\n5- read from file\n6- exit");
		String input = s.next();
		switch(input){
		case "1": // add new flight
			addNewFlight(s, FlightList);
			return true;
		case "2": // remove flight
			System.out.println("Removed flight\n");
			return true;
		case "3": // show all flights
			showAllFlights(FlightList, ComparFlights);
			return true;
		case "4":
			saveToFile(FlightList, f, ComparFlights);
			return true;
		case "5":
			readFromFile(FlightList);
			return true;
		case "6":
			System.out.println("Thank you for doing something simple as typing 6... twat...\n");
			return false;
		default:
			System.out.println("Please enter a vaild option\n");
			return true;

		}
	}

	public static void addNewFlight(Scanner s, ArrayList<Flight> FlightList) {
		System.out.println("Please Enter the flight time: (hours, min)");
		Time time = new Time(s.nextInt(), s.nextInt(), 0);
		System.out.println("Please Enter the flight date: (year, month and then day)");
		Date date = new Date(s.nextInt() - 1900, s.nextInt()-1, s.nextInt()); // year is +1901 in the date constractour
		System.out.println("Now please enter the AirLine name, Destnaition and  flight number");
		s.nextLine(); // must do because of the s.nextint() 
		Flight f = new Flight(s.nextLine(), s.nextLine(),s.next(), date, time);
		System.out.println(f + "\nFlight has been added\n");
		FlightList.add(f);

	}

	public static void showAllFlights(ArrayList<Flight> FlightList, Comparator<Flight> ComparFlights) {
		FlightList.sort(ComparFlights);
		System.out.println(FlightList.toString().replace('[', ' ').replace(']', ' '));

	}

	public static void saveToFile(ArrayList<Flight> FlightList, File f, Comparator<Flight> ComparFlights) throws IOException {
		f.createNewFile();
		PrintWriter pw = new PrintWriter(f);
		FlightList.sort(ComparFlights);
		pw.print(FlightList.toString().replace('[', ' ').replace(']', ' '));
		pw.close();
		System.out.println("Saved Successfully");
	}

	public static void readFromFile(ArrayList<Flight> FlightList) throws FileNotFoundException {
		File f = new File("E:\\AFEKA\\First Year\\B\\Developing tools\\Flights\\ReadTest.txt");
		String company= null;
		String flightNum= null;
		String Destnaition = null;
		Date date = null;
		Time time = null;
		boolean check=false;
		if(f.exists()) {
			Scanner s = new Scanner(f);
			while(s.hasNext()) {
				String temp = s.next();
				switch(temp){
				case "Company:":
					company = s.next();
					break;
				case "Destnaition:":
					Destnaition = s.next();
					break;
				case "Flight number:":
					flightNum = s.next();
					break;
				case "Date:":
					date = new Date(s.nextInt() - 1900, s.nextInt()-1, s.nextInt()); // year is +1901 in the date constractour
					break;
				case "Time:":
					time = new Time(s.nextInt(), s.nextInt(), 0);
					check = true;
					break;
				default:
					break;
				}

				if(check) {
					Flight flight = new Flight(company, Destnaition, flightNum, date, time);
					FlightList.add(flight);
					check = false;
				}

			}
			s.close();
		}
	}

	public void OneMonth (ArrayList<Flight> FlightList) {
		for(int i=1;i<=12;i++) {
			for(int j=0;j<FlightList.size();j++) {
		if (FlightList.get(j).getTime().getMonth()==i) {
			System.out.println(FlightList.get(j).toString());
		}
			}
		}
	}
		public static  void month (int month,ArrayList<Flight> FlightList) {
			
			for(int j=0;j<FlightList.size();j++) {
		if (FlightList.get(j).getTime().getMonth()==month) {
			System.out.println(FlightList.get(j).toString());
		}
			}
		}

}