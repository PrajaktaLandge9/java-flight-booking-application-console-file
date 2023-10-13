package flight_management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FlightManagement {
	static ArrayList<Flight> al = new ArrayList<>();
	public static void flightManagement() throws IOException
	{
		loadDataFromFileToArrayList();
		Scanner sc = new Scanner(System.in);
		boolean CanIKeepRunningTheProgram = true;
		while(CanIKeepRunningTheProgram == true) 
		{
			System.out.println("\n Welcome to AERO FLY !");
			System.out.println("\n Select one of the options given below :");
			System.out.println("1. Book a flight : ");
			System.out.println("2. Edit a flight : " );
			System.out.println("3. Cancel booked flight : ");
			System.out.println("4. Search a flight : ");
			System.out.println("5. Exit \n ");
			int OptionSelected = sc.nextInt();
			if(OptionSelected == FlightOptions.EXIT)
			{
				File file = new File("\\Users\\PRAJAKTA\\eclipse-workspace\\FlightBookingApplication\\src\\flight_management\\FlightsAllData.csv");
				FileWriter fileWriter = new FileWriter(file, false); 
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				for(Flight flight: al)
				{
					bufferedWriter.write(flight.DepartureAirport+","+flight.DestinationAirport+","+flight.FlightDate+","+flight.FlightTime+","+flight.TravelClass+","+flight.FlightPrice+","+flight.FlightName+","+flight.Airline+","+flight.NumberOfSeatsToBook+","+flight.CheckinBaggage+"\n");
				}
				bufferedWriter.close(); 
				fileWriter.close();
				file = null;
				System.out.println("\n Flight management application closed !");
				CanIKeepRunningTheProgram = false;
			}
			else if(OptionSelected == FlightOptions.BOOK_FLIGHT) 
			{
				bookflight();
			}
			else if(OptionSelected == FlightOptions.SEARCH_FLIGHT) 
			{
				System.out.println("\n Enter name of the flight to be searched : \n"); 
				sc.nextLine();                                          
				String SearchFlightName = sc.nextLine();
				searchflight(SearchFlightName);
			}
			else if(OptionSelected == FlightOptions.CANCEL_FLIGHT) 
			{
				System.out.println("\n Enter name of the flight to be canceled : \n");
				sc.nextLine();                                      
				String CancelFlightName = sc.nextLine();
				cancelflight(CancelFlightName);
			}
			else if(OptionSelected == FlightOptions.EDIT_FLIGHT) 
			{
				System.out.println("\n Enter name of the flight to be edited : ");
				sc.nextLine();                                     
				String EditFlight = sc.nextLine();
				editflight(EditFlight);
			}
		}
	}
	public static void bookflight()
	{
		Flight FlightObject = new Flight();
		Scanner sc = new Scanner(System.in);

		System.out.println("\n DepartureAirport : ");
		FlightObject.DepartureAirport = sc.nextLine();

		System.out.println(" DestinationAirport : ");
		FlightObject.DestinationAirport = sc.nextLine();

		System.out.println(" FlightDate : ");
		FlightObject.FlightDate = sc.nextLine();

		System.out.println(" FlightTime : ");
		FlightObject.FlightTime = sc.nextLine();

		System.out.println("\n Select one of the class below : \n Economy  \n Premium Economy  \n Business ");
		FlightObject.TravelClass = sc.nextLine();

		System.out.println(" Please enter the flight price as per the travel location and travel class selected : "); 
		System.out.println("\n Mumbai    to  Delhi      ( Economy : 10,000 Rs, Premium Economy : 13,000 Rs, Business : 15,000 Rs )");
		System.out.println("\n Delhi     to  Mumbai     ( Economy : 10,000 Rs, Premium Economy : 13,000 Rs, Business : 15,000 Rs )");
		System.out.println("\n Pune      to  Delhi      ( Economy : 12,000 Rs, Premium Economy : 14,000 Rs, Business : 16,000 Rs )");
		System.out.println("\n Bangalore to  Delhi      ( Economy : 6,000 Rs, Premium Economy : 7,000 Rs, Business : 9,000 Rs )");
		System.out.println("\n Delhi     to  Bangalore  ( Economy : 6,000 Rs, Premium Economy : 7,000 Rs, Business : 9,000 Rs )");
		System.out.println("\n Jaipur    to  Pune       ( Economy : 6,000 Rs, Premium Economy : 7,000 Rs, Business : 9,000 Rs )");
		System.out.println("\n Pune      to  Jaipur     ( Economy : 6,000 Rs, Premium Economy : 7,000 Rs, Business : 9,000 Rs )");
		System.out.println("\n Mumbai    to  Bangalore  ( Economy : 3,000 Rs, Premium Economy : 5,000 Rs, Business : 7,000 Rs )");
		System.out.println("\n Bangalore to  Mumbai     ( Economy : 3,500 Rs, Premium Economy : 7,500 Rs, Business : 9,500 Rs )");
		System.out.println("\n Hyderabad to  Delhi      ( Economy : 8,000 Rs, Premium Economy : 10,000 Rs, Business : 12,000 Rs )");
		System.out.println("\n Delhi     to  Hyderabad  ( Economy : 6,000 Rs, Premium Economy : 7,000 Rs, Business : 9,000 Rs )");
		System.out.println("\n Delhi     to  Pune       ( Economy : 12,000 Rs, Premium Economy : 14,000 Rs, Business : 15,000 Rs");

		System.out.println("\n Flight price : ");
		FlightObject.FlightPrice = sc.nextLine();

		System.out.println("\n Available flights are as belows,Please select one of the flight:\n");
		System.out.println("1. AirIndia Express - Ar-102");
		System.out.println("2. AirIndia Express - Ar-103");
		System.out.println("3. AirIndia Express - Ar-104");
		System.out.println("4. AirIndia Express - Ar-105");
		System.out.println("5. AirIndia Express - Ar-106");
		System.out.println("6. IndiGo - Id-102");
		System.out.println("7. IndiGo - Id-103");
		System.out.println("8. IndiGo - Id-108");
		System.out.println("9. IndiGo - Id-109");
		System.out.println("10.IndiGo - Id-110");
		System.out.println("11.IndiGo - Id-118");
		System.out.println("12.IndiGo - Id-120");

		System.out.println("\n Enter FlightName : ");
		FlightObject.FlightName = sc.nextLine();

		System.out.println("\n Airline selected : ");
		FlightObject.Airline = sc.nextLine();

		System.out.println("\n NumberOfSeatsToBook : ");
		FlightObject.NumberOfSeatsToBook = sc.nextLine();

		System.out.println("\n Checkin Baggage ( The maximum weight permissible for a single piece of baggage is 31 kg/70 lb ) : ");
		FlightObject.CheckinBaggage = sc.nextLine();

		System.out.println("\n Flight details are : \n");
		System.out.println("Departure airport is       : "+FlightObject.DepartureAirport);
		System.out.println("Destination airport is     : "+FlightObject.DestinationAirport);
		System.out.println("Flight date is             : "+FlightObject.FlightDate);
		System.out.println("Flight time is             : "+FlightObject.FlightTime);
		System.out.println("Flight travel class is     :  "+FlightObject.TravelClass);
		System.out.println("Flight price is            : "+FlightObject.FlightPrice);
		System.out.println("Flight name is             : "+FlightObject.FlightName);
		System.out.println("Airline selected is        : "+FlightObject.Airline);
		System.out.println("Number of seats booked are : "+FlightObject.NumberOfSeatsToBook);
		System.out.println("Checkin baggage is         : "+FlightObject.CheckinBaggage);
		System.out.println("\n Congratulations ! Your Reservation for the flight "+FlightObject.FlightName+" is confirmed ! Thankyou !!");

		al.add(FlightObject);
	}
	public static void searchflight(String SearchFlightName)
	{
		for(Flight flight :al)
		{
			if(flight.FlightName.equalsIgnoreCase(SearchFlightName))
			{
				System.out.println("\n Welcome ! Your flight details are given below : \n");
				System.out.println("Departure airport is       : "+flight.DepartureAirport);
				System.out.println("Destination airport is     : "+flight.DestinationAirport);
				System.out.println("Flight date is             : "+flight.FlightDate);
				System.out.println("Flight time is             : "+flight.FlightTime);
				System.out.println("Flight Travel class is     :  "+flight.TravelClass);
				System.out.println("Flight price is            : "+flight.FlightPrice);
				System.out.println("Flight name is             : "+flight.FlightName);
				System.out.println("Airline selected is        : "+flight.Airline);
				System.out.println("Number of seats booked are : "+flight.NumberOfSeatsToBook);
				System.out.println("Checkin baggage is         : "+flight.CheckinBaggage);
				return;
			}
		}
		System.out.println("\n Flight not found.Please enter correct flight name ");
	}
	public static void cancelflight(String CancelFlightName)
	{
		Iterator<Flight> FlightIterator = al.iterator();
		while(FlightIterator.hasNext())
		{
			Flight flight = FlightIterator.next();
			if(flight.FlightName.equalsIgnoreCase(CancelFlightName))
			{
				FlightIterator.remove();
				System.out.println("\n Flight"+flight.FlightName+" has been canceled.");
				break;
			}
		}
	}
	public static void editflight(String EditFlight) 
	{
		for(Flight flight : al)
		{
			if(flight.FlightName.equalsIgnoreCase(EditFlight))
			{
				Scanner sc = new Scanner(System.in);
				System.out.println("\n Editing flight : "+flight.FlightName);
				System.out.println("\n New flight departure airport : ");
				flight.DepartureAirport= sc.nextLine();
				System.out.println("\n New flight destination airport : ");
				flight.DestinationAirport = sc.nextLine();
				System.out.println("\n New flight date : ");
				flight.FlightDate = sc.nextLine();
				System.out.println("\n New flight time : ");
				flight.FlightTime = sc.nextLine();
				System.out.println("\n New flight travel class is :  ");
				flight.TravelClass = sc.nextLine();
				System.out.println("\n New flight price is : ");
				flight.FlightPrice = sc.nextLine();
				System.out.println("\n New flight name : ");
				flight.FlightName = sc.nextLine();
				System.out.println("\n New flight airline : ");
				flight.Airline = sc.nextLine();
				System.out.println("\n New flight number of seats : ");
				flight.NumberOfSeatsToBook = sc.nextLine();
				System.out.println("\n New flight checkin baggage : ");
				flight.CheckinBaggage = sc.nextLine();
				System.out.println("\n Congratulations ! Reservation for the edited flight "+flight.FlightName+" is confirmed \n");
				return;
			}
		}
		System.out.println("\n Flight not found.Please enter correct flight name.");
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("\\Users\\PRAJAKTA\\eclipse-workspace\\FlightBookingApplication\\src\\flight_management\\FlightsAllData.csv");
		FileReader fr = new FileReader(file);         
		BufferedReader br = new BufferedReader(fr); 
		String line = " ";
		while((line = br.readLine())!= null)      
		{
			Flight flight = new Flight();
			String[] flightDataArray = line.split(",");
			if(flightDataArray.length>9)
			{
				flight.DepartureAirport    = flightDataArray[0];
				flight.DestinationAirport  = flightDataArray[1];
				flight.FlightDate          = flightDataArray[2];
				flight.FlightTime          = flightDataArray[3];
				flight.TravelClass         = flightDataArray[4];
				flight.FlightPrice         = flightDataArray[5];
				flight.FlightName          = flightDataArray[6];
				flight.Airline             = flightDataArray[7];
				flight.NumberOfSeatsToBook = flightDataArray[8];
				flight.CheckinBaggage      = flightDataArray[9];
				al.add(flight);
			}

		}
		fr.close();
		br.close();
		file = null;
	}
}
