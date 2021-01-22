package com.techelevator;

public class HomeworkAssignment {
	
	private int 	earnedMarks;
	private int 	possibleMarks;
	private String	submitterName;
	
// -------------------------------------------------------------------------------------------------------------
// Getters and Setters
	public int getEarnedMarks() {
		return earnedMarks;
	}
	public void setEarnedMarks(int earnedMarks) {
		this.earnedMarks = earnedMarks;
	}
	public int getPossibleMarks() {
		return possibleMarks;
	}
	public String getSubmitterName() {
		return submitterName;
	}
// --------------------------------------------------------------------------------------------------------------
//	Constructor:
public HomeworkAssignment(int possibleMarks, String submitterName) {
		this.possibleMarks = possibleMarks; 	// Set the data member to the parameter
		this.submitterName = submitterName;		// Set the data member to the parameter
	}
	
// A derived attribute/value is one that a method determines and returns
// method to determine the derived value letterGrade
// we make it public so anyone with an object of this class can access the method
public String getLetterGrade() {
	String letterGrade = ""; 	// Hold the letter grade to be returned
	
	double grade = (double) earnedMarks / possibleMarks;	// We are allowed to use the data members
												//		because this method is members of the class
	
	if(grade >= 0.90) {
		letterGrade = "A";
	}
	else if (grade >= 0.80) {
		letterGrade = "B";
	}
	else if (grade >= 0.70) {
		letterGrade = "C";
	}
	else if (grade >= 0.60) {
		letterGrade = "D";
	}
	else {
		letterGrade = "F";
}
	return letterGrade;			// return the letter grade
}
		

}
