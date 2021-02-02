package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	
	// This program will validate bank routing numbers stored in a file
	// The file used is called rtn.txt
	
	// Constant of values used to determine if a rtn is valid - has nothing to do with the File I/O
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) throws FileNotFoundException {

		printApplicationBanner();	// Display a polite hello message
		
		// instantiate a File object for the path returned from getInputFileFromUser() method
//		File inputFile = getInputFileFromUser();			// Define a file object for the file
															// We get the path from a method
		
		File inputFile = new File("rtn.txt");	// Identify the path as a String literal
		
//	Instantiating the Scanner object in a try() causes it to be automatically closed a the end of the program
// If you define the Scanner object yourself, you are responsible for closing it at the end of the program
// Leaving a file open at the end of the program, you are causing a resource leak
// A "Resource Leak" is when resources (memory) used by the program are not freed at the end of the program
// "resource leaks" can lead to slower processing, unexpected errors, or a computer just stopping
		
//		try(Scanner fileScanner = new Scanner(inputFile)) {	// Define Scanner object for the file
		
		Scanner fileScanner = new Scanner(inputFile);
		
			// If you try to read more lines than in the file, an Exception is thrown - program terminates with a message
			
			while(fileScanner.hasNextLine()) {				// Loop through the file as long as the file has a line to read
				String line = fileScanner.nextLine();		// 		Get the next line from the file
				// Once the data is in the program, process it as necessary
				String rtn = line.substring(0, 9);			// 		Extract the first 9 chars as the rtn
				
				if(checksumIsValid(rtn) == false) {			// Pass the rtn to the validation method
					System.out.println(line);				// 		if the rtn was not valid, display it
				}
			}
		// before the program ends, close any files that were not instantiated in a try()
		fileScanner.close(); // Close the file to release more resources used to process it
		}	// end of main()


	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	
	@SuppressWarnings("resource")
	// This method will get a path from a user and if a valid file, return a File object for the path
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);					// instantiate an object for keyboard
		System.out.print("Please enter path to input file >>> ");	// display a user prompt for input needed
		String path = userInput.nextLine();							// get a line of input from the user
		
		File inputFile = new File(path);	// Instantiate a File object for the path entered by the user
		
		// Check to be sure what the user entered was a valid, existing path to a file
		
		if(inputFile.exists() == false) { 	// checks for the existence of a file (does the path given NOT exist)
			System.out.println(path+" does not exist");		// if so, display a message
			System.exit(1); // Ends the program				//		and end the program with a return code 1
		} else if(inputFile.isFile() == false) {			// was the path given NOT a file?
			System.out.println(path+" is not a file");		// if so, display a message
			System.exit(1); // Ends the program				//		and end the program with a return code 1
		}
		// If we get here, we know the path given was a valid, existing file
		return inputFile;		// return the File object for the path
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
