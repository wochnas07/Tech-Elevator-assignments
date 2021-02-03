package com.techelevator.exceptions;

// This is an example of a user/programmer defined Exception
// defined because the error we want to find is not a standard system error
//			it is an application defined error

// Define a class that extends the Exception class
public class OverdraftException extends Exception {

// Code what the Exception is supposed to do
	
// In this example, if a withdrawal would result in an over-draft, the application will throw this Exception
// The system and Java don't care or know what at overdraft is or that we consider it a problem
//		so we define an Exception for the Application error
	
	private double overdraftAmount = 0;		// Data member to hold the amount sent when this Exception is thrown
	
	// The ctor for the Exception is where the code for the Exception goes
	// This Exception receives two parameters: a message and the overdraft amount
	public OverdraftException(String message, double overdraftAmount) {
		super(message);		// Call the super class ctor with the message passed in when the Exception was thrown
		this.overdraftAmount = overdraftAmount;	// Save the overdraft amount parameter in this class data member
												// 		in case the Exception handler (catch) needs it
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}
}
