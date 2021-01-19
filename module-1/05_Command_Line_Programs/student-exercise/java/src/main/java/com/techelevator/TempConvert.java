package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		
		String theValue = "";
		String theMeasurment = "";
		
		System.out.println("Please enter the temperature: "); 
		theValue = userInput.nextLine(); 
		double theNumValue = Double.parseDouble(theValue);

		
		System.out.println("Is temperature in (C)elsius or (F)ahrenheit: ");
		theMeasurment = userInput.nextLine();
		
		
			if (theMeasurment.equals("Celsius") || theMeasurment.equals("C")) {
				double theValueInFahr = (theNumValue * (9/5) + 32);
				System.out.println(theValue + theMeasurment + " is " + theValueInFahr + "F.");
				return;
			} if (theMeasurment.equals("Fahrenheit") || theMeasurment.equals("F")) {
				 double theValueInCels = ((theNumValue - 32) * 0.5555556);
				 System.out.println(theValue + theMeasurment + " is " + theValueInCels + "C.");
				 return;
		} System.out.println("There was an error with your input");
	}

}
