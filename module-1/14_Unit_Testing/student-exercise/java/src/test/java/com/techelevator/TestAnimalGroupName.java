package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAnimalGroupName {
	
// First we need to define an object with the methods we want to test
	
//	object			name
	AnimalGroupName testCode = new AnimalGroupName();	// Object with the methods to be tested
	
@Test 	// Here's a JUnit Test
		// Always public - void - test name
	public void test_correct_aniaml_group_returned_based_upon_animal() {	// JUnit test method
	// methods in the class were testing are:
	//
	// String getHerd(String animalName)
	//
	// The method returns a String - assertEquals
	//
	// Test 1 - send it "Elephant" and expect "Herd"
	// Test 2 - send it "Walrus" and expect "unknown"
	// Test 3 - send it "elephant" and expect "Herd"
	// Test 4 - send it "ELEPHANT" and expect "Herd"
	// Test 5 - send it "ElEpHaNt" and expect "Herd"
	
	assertEquals("Wrong animal group returned", "Herd", testCode.getHerd("Elephant"));
	assertEquals("Wrong animal group returned", "unknown", testCode.getHerd("Walrus"));
	assertEquals("Wrong animal group returned", "Herd", testCode.getHerd("elephant"));
	assertEquals("Wrong animal group returned", "Herd", testCode.getHerd("ELEPHANT"));
	assertEquals("Wrong animal group returned", "Herd", testCode.getHerd("ElEpHaNt"));
}

}
