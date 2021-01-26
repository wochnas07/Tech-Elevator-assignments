package com.techelevator;

public class ItalianCard extends PlayingCard { // This is a subclass of PlayingCard
	
	// Every class needs at least one ctor
	public ItalianCard() {		// Default constructor
	// Because this is a subclass, we need to run a constructor for the superclass
	// the superclass has only one 3-arg constructor that takes a value, suit, and color
	//
	// Default Italian card: 1, SWORDS, RED
	super(1, "SWORDS", "RED");		// call the superclass ctor to initialize the data it knows about
		
	}
}


