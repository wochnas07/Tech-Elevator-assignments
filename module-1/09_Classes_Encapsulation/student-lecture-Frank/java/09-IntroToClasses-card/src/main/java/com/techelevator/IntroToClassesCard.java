package com.techelevator;

public class IntroToClassesCard {
        //------------------------------------------------------------------------------------------------------------
        // Application program for the Intro To Classes App
        //------------------------------------------------------------------------------------------------------------
		//
		// Every Java application must have one method called main()
		//
		// main() is where execution starts for any Java application
		//
		// main() is the Application Program
		//
		// Application Program instantiates and manipulates objects to get it's work done
		//
        public static void main(String[] args) {
        /*
        *  This program will demonstrate several concepts presented in the Java cohort
        *  in the topic Introduction to Classes 		
        */
        	
// to instantiate an object :
// 			ClassName	objName=new ClassName(); the () after the class name causes a constructor for the class to be run
//														if no constructor for the class is found a default constructor
        	PlayingCard aCard = new PlayingCard();	// Instantiated a PlayingCard object
        	
        	System.out.println(aCard);	// display aCard
        								// System.out.println - displays Strings
        								// Whatever you give it inside () must be convertible to a String
        								// aCard is a PlayCard type - not a String
        								// System.out.println looks for a method to convert aCard to a String
        								// A class may provide a method called toString() to return a String 
        								//				String representation of an object of the class
        								// If a toString() is not provided for the class an ERROR occurs when a String is needed
        								// System.out.println looks for a toString method for the PlayingCard class
        								// If a toString() is NOT found for the class of an object, it looks to any class
        								//		in the family of classes the object belongs to
        								// PlayingCard does not have a toString() method, but it's ancestor, the object class does
        								// Object class toString() method returns: package-name.class-name@location
        	
        	PlayingCard anotherCard = new PlayingCard(1, "Black", "Clubs");
        	System.out.println("anotherCard is: " + anotherCard);
        	
        	PlayingCard card3 = new PlayingCard(9, "Red", "Hearts");
        	System.out.println("card3 is: " + card3);
	
//        	System.out.println("The value in card3: " + card3.cardValue);	// error because cardValue is private in PlayingCard
        	System.out.println("The value in card3: " + card3.getCardValue());
        	
//        	card3.cardValue=1; 		// error because cardValue is private in PlayingCard
        	card3.setCardValue(1); 	// Change the cardValue in card3 to 1 using the setter method
        	System.out.println("The value in card3: " + card3.getCardValue());
        	
	}
}
		 

