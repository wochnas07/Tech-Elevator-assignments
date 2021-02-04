package com.techelevator.Bowling;

import java.util.ArrayList;

// 1. create a class to hold information about bowlers
public class Bowler {
//------------------------------------------------------------------------------------------------
	// 1a. Attributes to be stored:
	private int teamNumber; 	// Team number the bowler is a member of
	private int bowlerNumber;
	private String bowlerName;
	private ArrayList<Integer> scores;
//------------------------------------------------------------------------------------------------	
	// 1b. Only one constructor is needed that will receive all attributes as parameters
	// 4-arg constructor to initialize the data members with value passed from the user
	public Bowler(int teamNumber, int bowlerNumber, String bowlerName, ArrayList<Integer> scores) {
		this.teamNumber = teamNumber; // We need this. to reference the data member since the parameter name is the same
		this.bowlerNumber = bowlerNumber;
		this.bowlerName = bowlerName;
		this.scores = scores;
	}
//------------------------------------------------------------------------------------------------	
	// 1c. Standard getters and setters should be defined
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	public int getBowlerNumber() {
		return bowlerNumber;
	}
	public void setBowlerNumber(int bowlerNumber) {
		this.bowlerNumber = bowlerNumber;
	}
	public String getBowlerName() {
		return bowlerName;
	}
	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}
	public ArrayList<Integer> getScores() {
		return scores;
	}
	public void setScores(ArrayList<Integer> scores) {
		this.scores = scores;
	}
//------------------------------------------------------------------------------------------------		
// 1e. Methods for deriving the sum of the scores and the average of the scores should be defined
	// method names for derived values are prefixed with the word "get", followed by the derived value
	public int getSum() {	// All the data we need is in the class, so no parameters are needed
		int sum = 0; 		// define a variable for the return value
		// loop through the ArrayList of scores, adding each score to sum
		for (int i = 0; i < scores.size(); i++) {
			sum = sum + scores.get(i);	// add the current element to the sum
		}
		return sum;			// return the variable with the result
	}
	public double getAverage() {
		double avg = 0;		// define a variable to hold the result
		
		avg = this.getSum() / scores.size();	
		
		return avg;			// return the variable with the result
	}
//------------------------------------------------------------------------------------------------	
	// 1d. Standard equals() and toString overrides should be defined
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bowlerName == null) ? 0 : bowlerName.hashCode());
		result = prime * result + bowlerNumber;
		result = prime * result + ((scores == null) ? 0 : scores.hashCode());
		result = prime * result + teamNumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bowler other = (Bowler) obj;
		if (bowlerName == null) {
			if (other.bowlerName != null)
				return false;
		} else if (!bowlerName.equals(other.bowlerName))
			return false;
		if (bowlerNumber != other.bowlerNumber)
			return false;
		if (scores == null) {
			if (other.scores != null)
				return false;
		} else if (!scores.equals(other.scores))
			return false;
		if (teamNumber != other.teamNumber)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bowler [teamNumber=" + teamNumber + ", bowlerNumber=" + bowlerNumber + ", bowlerName=" + bowlerName
				+ ", scores=" + scores + "]";
	}

	
	
	
}
