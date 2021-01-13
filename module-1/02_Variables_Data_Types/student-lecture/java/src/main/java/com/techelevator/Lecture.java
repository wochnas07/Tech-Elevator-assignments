// slash-slash indicates comment in your Java Code
// a comment is information for a human who might read your code
// a comment line is ignored by the compiler

/* start of block comment
 * 	 	slash-asterisk starts a block comment
 *	 	all lines between the slash-asterisk and the asterisk-slash
 *	 	are treated as comment and ignored by the compiler.
 */ // end of block comment

package com.techelevator;		// the package that holds the classes for this application

public class Lecture {			// a class within the application

	public static void main(String[] args) {	// a function in the application class
												// every Java application has at least a main() function
		
		// variables are used to hold data needed for the program
		// Data and understanding the data is fundamental to writing a successful program
		
		// in Java a variable is defined: 	datatype name;
		//									datatype name = initial value;
		//
		// If an initial value is not specified when you define the variable
		// 		its content is unknown which may lead to errors or unpredictable results.
		//
		// It's a good idea to ALWAYS initialize variables
		//
		// variable names must be unique within a block of code (between {})
		//
		// Common Java Data Types Based on what they represent:
		//
		// 	If the value is numeric, without a decimal point: 	int
		// 	If the value is numeric, with a decimal point: 		double
		// 	If the value is a single character:					char
		// 	If the value is multiple characters or words:		String
		// 	If the value is true or false:						boolean
		
		// String is a "special" data type
		
		
		
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises = 26;

		System.out.println("The value in numberOfExercises is " + numberOfExercises); // Display whatever is between ()

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half = .5;

		System.out.println("half contains: " + half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "TechElevator";
		System.out.println("name is: " + name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;
		System.out.println("seasonsOfFirefly: " + seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		System.out.println("myFavoriteLanguage: " + myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		double pi = 3.1416;
		System.out.println("pi: " + pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String myName = "Sammi";
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int buttonsOnMouse = 5;
		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		double pctBatteryLife; // Not initialized because they didn't tell us what to initialize it to
		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int difference = 121 - 27;
		System.out.println(difference);
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double addition = 12.3 + 32.1;
		System.out.println("sum: " + addition); // sum is displayed as 44.4000000006
												// due to converting the internal format of a double
												// to a display format
		/*
		12. Create a String that holds your full name.
		*/
		String fullName = "Sammi Wochna";
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		// + when used with String means concatenation (stick the strings together)
		
		String greeting = fullName + "Hello";
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		fullName = fullName + " Esquire";
		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		fullName += " Esquire"; // now fullName has two " Esquires" at the end
		System.out.println("fullName is now: " + fullName);
		
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String movie = "Saw";
		movie += "2"; // movie = movie + 2
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		movie = movie + 0;
		/*
		18. What is 4.4 divided by 2.2?
		*/
		System.out.println("4.4/2.2 is: " + 4.4 / 2.2);
		/*
		19. What is 5.4 divided by 2?
		*/
		System.out.println("5.4/2 is: " + 5.4 / 2);
		/*
		20. What is 5 divided by 2?
		*/
		System.out.println("5/2 is: " + 5 / 2); // result =2 NOT 2.5
												//  5  /  2
												// int / int - Java does integer divide
												//    int 	 - result is an integer
		/*
		21. What is 5.0 divided by 2?
		*/
		System.out.println("5.0/2 is: " + 5.0 / 2);
		
		System.out.println("(double) 5 / 2 is: " + (double) 5 / 2);
			// (double) is casting the value to a type - tells Java treat value as a double
		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		System.out.println("66.6/100 is: " + 66.6 / 100); // answer is correct, just displayed oddly
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		System.out.println("The remainder of 5/2 is: " + 5 % 2);
		/*
		24. What is 1,000,000,000 * 3?
		*/
		System.out.println("1,000,000,000*3 is: " + 1000000000L * 3);	// L converts the number to a long
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		boolean doneWithExercises = false;
		
		/*
		26. Now set doneWithExercise to true.
		*/
		boolean doneWithExercise = true;
		
	}

}
