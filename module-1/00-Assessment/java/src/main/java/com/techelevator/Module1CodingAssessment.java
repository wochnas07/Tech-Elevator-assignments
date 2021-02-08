package com.techelevator;

import java.util.Scanner;

// This is the application program for the assessment

public class Module1CodingAssessment {

	public static void main(String[] args) {
		
		System.out.println("Module 1 Coding Assessment\n");
		
		// Put the code to test your assessment classes here
		
		boolean isValid(String numbersEntered) {
			Scanner numebersEntered = new Scanner(System.in);
			
			System.out.println("Enter card numeber: ");
			String cardNumber = numbersEntered.nextLine();
			
			
			if (cardNumber.startsWith("5") && cardNumber.length()==16) {
				return true;
			} if (cardNumber.startsWith("4") && (cardNumber.length()==13 || cardNumber.length()==16)) {
				return true;
			}

		}
	} // I don't know why I'm so lost right now...
		// I'm sorry I swear I know this stuff

}
