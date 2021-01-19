package com.techelevator;
// If we use something that is not part of the standard Java language we need to import the code that supports it
import java.util.Scanner; 		// Give me access to the Scanner stuff provided by Java

public class CommandLineSampleProgram {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Frank's Command Line Sample Program");
		
		// This code will read input from the keyboard and process it
		
		// Define an object to represent the keyboard in our program
		// Scanner is the class that Java provides for us to define keyboard objects
		// Since Java provides the name System.in to represent the actual keyboard
		// 			we need to associate our program keyboard object with System.in
		
		Scanner userInput = new Scanner(System.in); // Create a Scanner object for the keyboard called userInput
		
		String aLine = ""; // Will hold the line of input from the keyboard
		
		System.out.println("Please enter a line: "); // Send a prompt to the user so they know to type something
		aLine = userInput.nextLine(); // Go to the userInput object and get the nextLine
		
		System.out.println("You entered the line: " + aLine); // displays the line entered by the user
		
		System.out.println("Please enter a whole number: ");
		int aNumber = userInput.nextInt();			// Get an int from the keyboard
		userInput.nextLine(); 	// remove the enter left in the keyboard buffer by nextInt
								// so subsequent keyboard requests all the user to type input for the program
		System.out.println("You entered the number: "+ aNumber);
		
		// We want to divide what the user entered by 2 to get half the value
		// We stored what they entered as a String which cannot be used in arithmetic
		// We need to convert the value in the String to a numeric value so we can do arithmetic
		// We can use the Integer.parseInt() or Double.parseDouble() to convert a String to a numeric
		
		// int theNumber = Integer.parseInt(aLine); // Convert what is in aLine to an int and store it in theNumber
		
		System.out.println("Half of that number is: " + aNumber/2);
		
		
		// Get a series of values from a user and determine the sum and average
		// 1. Ask the user to enter a value or indicate they are done ("N" = done)
		// 2. If they are not done:
		//		a. convert the value entered into a numeric
		//		b. add the converted value to a sum
		//		c. count that they entered a number so we can calculate the average
		//	3. Once they are done - display the sum and the average
		
		String theValue = ""; 	// hold the value entered by the user
		double sum = 0; 		// hold the sum of the values they enter - double because we are allowing decimal values
		int numNums = 0; 		// hold the number of values they enter
		
		// We are using a while loop because we don't know how many values the user will enter
		// The while loop will loop while a condition is true - will end when the condition is false
	
		// In this case we will specify a never-ending loop by looping while true
		// We will use break to end the loop when we decide it needs to end
		
		while(true) {	//loop until the end of time or we break out of the loop
			System.out.println("Enter a value of 'N' to end");	// Prompt the user for input
			theValue = userInput.nextLine(); 		// Get input from the user
			
			// to test a String for equals we CANNOT use the normal == or !=
			// us the .equals() method to check a String for a value
			if(theValue.equals("N")) { 					// if they entered "N"
				break;								// end the loop
			}
			double valueEntered = Double.parseDouble(theValue); // Convert what they entered from a string to a double
			sum = sum + valueEntered; 		// Add the value entered as a number to sum
			numNums++;
		}
		// This is the end of the loop - we get here when we exit the loop
		System.out.println("The sum of the numbers is: " + sum);
		System.out.println("You entered " + numNums + " numbers");
		System.out.println("The average of the numbers: " + (sum/numNums));
	}
}


// To avoid issues when reading the keyboard:
//		Use nextLine() to read the input as a String
//		Convert the String to numeric value if needed using Integer.parseInt() or Double.parseDouble(), etc
// 		-OR-
//		if you use nextInt(), nextDouble(), or any other next with a numeric type,
// 		do a nextLine() immediately afterwards to clear the keyboard buffer of the enter key that was left in it.



