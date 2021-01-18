package com.techelevator;

public class FranksArrayExample {
	
	public static void main(String[] args) {  
		
		System.out.println("Welcome to Frank's Array Example Program"); 
		int score1 = 10;
		int score2 = 20;
		int score3 = 30;
		int score4 = 50; // this was added after the code was written and tested
		
		int sum = 0; 	// this will hold the sum of the scores
		double avg = 0.0;	// this will hold the average of the scores
		
		sum = score1 + score2 + score3 + score4;	// a change in data required a change in code
		avg = sum/4;								// a change in data required a change in code
		
		// This code is tightly coupled because changes to the data require changes to code.
		// Tightly coupled code is considered a bad practice because one might forget to change code in one or more places


		
		// ------------------------------------------------------------------------------------------------------
		// Use an array to hold and process the scores to make the code loosely coupled
		//
		// Loosely coupled means the code is not direct bound to the data
		// Changes to data does not require changes to the code
		//
		int[] scores = new int[5];	// define a new int array with 3 elements
		
		scores[0] = 10;		// set the first element in the array to the value of 10
		scores[1] = 20; 	// set the second element in the array to the value of 20
		scores[2] = 30; 	// set the third element in the array to the value of 30
		scores[3] = 80;
		scores[4] = 120;

//		int[] scores = {10, 20, 30, 80, 120}; 
		
		sum = 0;			// reset sum to 0 to remove previous value of sum
		// use a for-loop to process each element in the array to determine the sum
		//
		// for loop will iterate through a block until a condition is false
		// a loop variable is defined in the for-loop and incremented each time through the loop
		// a condition in the for-loop is tested BEFORE each loop to see if it should loop
		// you will loop as long as the condition is true
		//
		// for(int i=0; i < scores.length; i++)
		//	1. i will be set to 0
		//	2. check to see if i is less than the number of elements in the scores array (i < 3) 
		//										when i = 0, 1, or 2 we loop; when i = 3, we exit loop
		//	3. if #2 is true - continue to step 4; if #2 is false - exit the loop
		//	4. execute the statement in the block
		//	5. increment i (ass 1 to i)
		//	6. go back to step #2
		
		
		//     init      condition    increment
		for(int i=0; i < scores.length; i++) {		// loop while i is a valid index for the scores array
			sum = sum + scores[i];		// add the element in scores[i] to sum; scores[i] is called the current element
		}
		// at the end of the loop sum will contain the total of all the elements
		
		avg = sum / scores.length;		// divide sum by the number of elements in the array to get the average
		
		System.out.println("Sum of the scores: " + sum);
		System.out.println("Average of the scores: " + avg);
	}   
   
}