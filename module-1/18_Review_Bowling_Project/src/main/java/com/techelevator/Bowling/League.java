package com.techelevator.Bowling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

// 2. Create a class to hold information about a bowling league
public class League {
//------------------------------------------------------------------------------------------------			
	// 2a. Attributes to be stored
	private String leagueName;
	private Map<Integer, ArrayList<Bowler>> leagueMembers;	// key=teamNumber, value=Bowler
//------------------------------------------------------------------------------------------------	
// 2b.Two constructors need to be defined
// Default constructor that initializes all data members to null
	public League() {
		leagueName = null;
		leagueMembers = null;
	}
// 2-arg constructor 
	public League(String leagueName, String dataFileName) throws FileNotFoundException {
		this.leagueName = leagueName;
	// Load the data from the file given into our leagueMembers
	// Call a member function to load the file 
		loadFile(dataFileName);	// run the loadFile method, sending the file to be loaded	
	}
// method to load the file given into leagueMembers - it's private because we don't want users to run it
// Only members of the class can call this method
	private void loadFile(String fileNameToLoad) throws FileNotFoundException {
		File aFile = new File(fileNameToLoad);	// Define a File object for the file
		Scanner inputDataFile = new Scanner(aFile);	// Define a Scanner for the file object
		
		//Define variables to hold data from file
		int teamNumber = 0;
		int bowlerNumber = 0;
		String bowlerName = null;
		ArrayList<Integer> scores = new ArrayList<Integer>();	// Define a place to hold a set of scores
		
		while(inputDataFile.hasNext()) {		// Loop while the file has lines to read
			String aLine = inputDataFile.nextLine();	// Read a line from the file
			String[] valuesInLine = aLine.split(",");	// Separate the values at the commas
			
			// Assign the values from the file into the variable we will use to create a Bowler
			teamNumber = Integer.parseInt(valuesInLine[0]);	// convert the first value to an int and store it
			bowlerNumber = Integer.parseInt(valuesInLine[1]);
			bowlerName = valuesInLine[2];
			
			scores.add(Integer.parseInt(valuesInLine[3]));	// convert the first score to an int and add to ArrayList
			scores.add(Integer.parseInt(valuesInLine[4]));	// convert the second score to an int and add to ArrayList
			scores.add(Integer.parseInt(valuesInLine[5]));	// convert the third score to an int and add to ArrayList
			
			// We have all the data from the file stores in variables
			// We can define a Bowler
			Bowler aBowler = new Bowler(teamNumber, bowlerNumber, bowlerName, scores);
			
			// Create an ArrayList and add it to Map using the teamNumber
		}
	}
	
	
	
	
	
}
