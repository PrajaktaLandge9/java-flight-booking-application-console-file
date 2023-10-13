package flight_booking_application_main;

import java.io.IOException;
import java.util.Scanner;
import passenger_management.PassengerManagement;
import flight_management.FlightManagement;

public class ApplicationMain {
	public static void main (String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		boolean CanIKeepRunningTheProgram = true;
		System.out.println("\n ! Welcome to AERO FLY ! \n");
		System.out.println("\n Login ");
		System.out.println("\n Enter login name : ");
		String LoginName = sc.nextLine();
		System.out.println("\n Enter password : ");
		String Password = sc.nextLine();

		if(! PassengerManagement.validatePassengerAndPassword(LoginName, Password)) 
		{
			System.out.println("\n Login failed. Closing the application !);");
			return;
		}
		else
		{
			System.out.println("\n Login Successful !");
		}

		while(CanIKeepRunningTheProgram == true)
		{
			System.out.println("\n What would you like to do ?");
			System.out.println("\n 1. Flight Management");
			System.out.println("\n 2. Passenger Management");
			System.out.println("\n 3. Exit");

			int OptionSelectedByPassenger = sc.nextInt();

			if(OptionSelectedByPassenger == 1)
			{
				FlightManagement.flightManagement();
			}

			else if(OptionSelectedByPassenger == 2)
			{
				PassengerManagement.passengerManagement();
			}

			else if(OptionSelectedByPassenger == 3)
			{
				System.out.println("\n Application closed.Thankyou for visiting AERO FLY !");
				break;
			}
		}
	}
}


