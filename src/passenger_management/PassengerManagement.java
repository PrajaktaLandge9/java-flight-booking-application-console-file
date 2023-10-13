package passenger_management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PassengerManagement {
	static ArrayList<Passenger> al = new ArrayList<>();
	static {
		try {
			loadDataFromFileToArrayList();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void passengerManagement() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		boolean CanIKeepRunningTheProgram = true;
		while(CanIKeepRunningTheProgram == true) 
		{
			System.out.println("\n Welcome to passenger management !");
			System.out.println("\n Select one of the options given below :");
			System.out.println("1. Add passenger : ");
			System.out.println("2. Edit passenger : " );
			System.out.println("3. Delete passenger : ");
			System.out.println("4. Search passenger : ");
			System.out.println("5. Exit");
			int OptionSelectedByPassenger = sc.nextInt();
			if(OptionSelectedByPassenger == PassengerOptions.EXIT)
			{
				File file = new File("\\Users\\PRAJAKTA\\eclipse-workspace\\FlightBookingApplication\\src\\passenger_management\\PassengerData.csv");
				FileWriter fileWriter = new FileWriter(file, false); 
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				for(Passenger passenger: al)
				{
					bufferedWriter.write(passenger.PassengerName+","+passenger.PassengerId+","+passenger.LoginName+","+passenger.Password+","+passenger.PassengerEmail+","+passenger.PassengerPhoneNumber+","+passenger.FlightBookedByPassenger+","+passenger.PassengerReservationNumber+"\n");
				}
				bufferedWriter.close(); 
				fileWriter.close();
				file = null;
				System.out.println("\n Passenger management application closed !");
				CanIKeepRunningTheProgram = false;
			}
			else if(OptionSelectedByPassenger == PassengerOptions.ADD_PASSENGER) 
			{
				addpassenger();
			}
			else if(OptionSelectedByPassenger == PassengerOptions.SEARCH_PASSENGER) 
			{
				System.out.println("\n Enter name of the passenger to be searched : \n"); 
				sc.nextLine();                                         
				String SearchPassengerName = sc.nextLine();
				searchpassenger(SearchPassengerName);
			}
			else if(OptionSelectedByPassenger == PassengerOptions.DELETE_PASSENGER) 
			{
				System.out.println("\n Enter name of the passenger to be deleted : \n");
				sc.nextLine();                                      
				String DeletePassengerName = sc.nextLine();
				deletepassenger(DeletePassengerName);
			}
			else if(OptionSelectedByPassenger == PassengerOptions.EDIT_PASSENGER)
			{
				System.out.println("\n Enter name of the passenger to be edited : ");
				sc.nextLine();                                    
				String EditPassengerName = sc.nextLine();
				editpassenger(EditPassengerName);
				System.out.println("\n Passenger edited successfully !");
			}
		}
	}
	public static void addpassenger()
	{
		Passenger PassengerObject = new Passenger();
		Scanner sc = new Scanner(System.in);

		System.out.println("\n PassengerName : ");
		PassengerObject.PassengerName = sc.nextLine();

		System.out.println(" PassengerId : ");
		PassengerObject.PassengerId = sc.nextLine();

		System.out.println(" LoginName : ");
		PassengerObject.LoginName = sc.nextLine();

		System.out.println(" Password : ");
		PassengerObject.Password = sc.nextLine();

		System.out.println(" ConfirmPassword : ");
		PassengerObject.ConfirmPassword = sc.nextLine();

		System.out.println(" PassengerEmail : ");
		PassengerObject.PassengerEmail = sc.nextLine();

		System.out.println(" PassengerPhoneNumber : ");
		PassengerObject.PassengerPhoneNumber = sc.nextLine();

		System.out.println(" FlightBookedByPassenger : ");
		PassengerObject.FlightBookedByPassenger = sc.nextLine();

		System.out.println(" PassengerReservationNumber : ");
		PassengerObject.PassengerReservationNumber = sc.nextLine();

		if(PassengerObject.Password.equals(PassengerObject.ConfirmPassword))
		{
			System.out.println("\n!! Passenger details !!\n");
			System.out.println("Passenger name is                  : "+PassengerObject.PassengerName);
			System.out.println("Passenger id is                    : "+PassengerObject.PassengerId);
			System.out.println("Login name is                      : "+PassengerObject.LoginName);
			System.out.println("Password is                        : "+PassengerObject.Password);
			System.out.println("Passenger email is                 : "+PassengerObject.PassengerEmail);
			System.out.println("Passenger phone number is          : "+PassengerObject.PassengerPhoneNumber);
			System.out.println("Flight booked by passenger is      : "+PassengerObject.FlightBookedByPassenger);
			System.out.println("Reservation number of passenger is : "+PassengerObject.PassengerReservationNumber);
			al.add(PassengerObject);
		}
		else
		{
			System.out.println("\nPassword and ConfirmPassword did not match.Try again.");
		}
	}
	public static void searchpassenger(String SearchPassengerName)
	{
		for(Passenger passenger :al)
		{
			if(passenger.PassengerName.equalsIgnoreCase(SearchPassengerName))
			{
				System.out.println("\nPassenger name                  : "+passenger.PassengerName);
				System.out.println("Passenger id is                   : "+passenger.PassengerId);
				System.out.println("Login name is                     : "+passenger.LoginName);
				System.out.println("Password is                       : "+passenger.Password);
				System.out.println("Passenger email is                : "+passenger.PassengerEmail);
				System.out.println("Passenger phone number is         : "+passenger.PassengerPhoneNumber);
				System.out.println("Flight booked by passenger is     : "+passenger.FlightBookedByPassenger);
				System.out.println("Resevation number of passenger is : "+passenger.PassengerReservationNumber);
				return;
			}
		}
		System.out.println("\n Passenger not found.Please enter correct passenger name. ");
	}
	public static void deletepassenger(String DeletePassengerName)
	{
		Iterator<Passenger> PassengerIterator = al.iterator();
		while(PassengerIterator.hasNext())
		{
			Passenger passenger = PassengerIterator.next();
			if(passenger.PassengerName.equalsIgnoreCase(DeletePassengerName))
			{
				PassengerIterator.remove();
				System.out.println("\n Passenger : "+passenger.PassengerName+" has been deleted.");
				break;
			}
		}
	}
	public static void editpassenger(String EditPassengerName)
	{
		for(Passenger passenger :al)
		{
			if(passenger.PassengerName.equalsIgnoreCase(EditPassengerName))
			{
				Scanner sc = new Scanner(System.in);
				System.out.println("\nEditing passenger : "+passenger.PassengerName);
				System.out.println(" New passenger name : ");
				passenger.PassengerName = sc.nextLine();
				System.out.println(" New passenger id : ");
				passenger.PassengerId = sc.nextLine();
				System.out.println(" New login name : ");
				passenger.LoginName = sc.nextLine();
				System.out.println(" New password : ");
				passenger.Password = sc.nextLine();
				System.out.println(" Confirm password : ");
				passenger.ConfirmPassword = sc.nextLine();
				System.out.println(" New passenger email : ");
				passenger.PassengerEmail = sc.nextLine();
				System.out.println(" New passenger phone number : ");
				passenger.PassengerPhoneNumber = sc.nextLine();
				System.out.println("Flight booked by new passenger : ");
				passenger.FlightBookedByPassenger = sc.nextLine();
				System.out.println(" New passenger resevation number : ");
				passenger.PassengerReservationNumber = sc.nextLine();
				return;
			}
		}
		System.out.println("\n passenger not found. Please enter correct name of the passenger.");
	}
	public static boolean validatePassengerAndPassword( String LoginName, String Password ) 
	{
		Iterator<Passenger> passengerIterator = al.iterator();
		while(passengerIterator.hasNext())
		{
			Passenger passenger = passengerIterator.next();
			if(passenger.LoginName.equalsIgnoreCase(LoginName) && passenger.Password.equalsIgnoreCase(Password))
			{
				return true;
			}
		}
		return false;
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("\\Users\\PRAJAKTA\\eclipse-workspace\\FlightBookingApplication\\src\\passenger_management\\PassengerData.csv");
		FileReader fr = new FileReader(file);         
		BufferedReader br = new BufferedReader(fr); 
		String line = " ";
		while((line = br.readLine())!= null)      
		{
			Passenger passenger = new Passenger();
			String[] passengerDataArray = line.split(",");
			if(passengerDataArray.length>7)
			{
				passenger.PassengerName              = passengerDataArray[0];
				passenger.PassengerId                = passengerDataArray[1];
				passenger.LoginName                  = passengerDataArray[2];
				passenger.Password                   = passengerDataArray[3];
				passenger.PassengerEmail             = passengerDataArray[4];
				passenger.PassengerPhoneNumber       = passengerDataArray[5];
				passenger.FlightBookedByPassenger    = passengerDataArray[6];
				passenger.PassengerReservationNumber = passengerDataArray[7];
				al.add(passenger);
			}
		}
		fr.close();
		br.close();
		file = null;
	}
}


