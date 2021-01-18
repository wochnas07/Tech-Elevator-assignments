package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		String theValue = "";
		String theMeasurment = "";
		
		System.out.println("Please enter the length: "); 
		theValue = userInput.nextLine(); 
		System.out.println("Is the measurement in (m)eter or (f)eet?: ");
		theMeasurment = userInput.nextLine();
		double theNumValue = Double.parseDouble(theValue);
		
			if (theMeasurment.equals("feet") || theMeasurment.equals("f")) {
				double theValueInMeters = theNumValue * 0.3048;
				System.out.println(theValue + theMeasurment + " is " + theValueInMeters + "m.");
				return;
			} if (theMeasurment.equals("meter") || theMeasurment.equals("m")) {
				double theValueInFeet = theNumValue * 3.2808399;
				 System.out.println(theValue + theMeasurment + " is " + theValueInFeet + "f.");
				 return;
		} System.out.println("There was an error with your input");
	}
}
