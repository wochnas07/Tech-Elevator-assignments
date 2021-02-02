package com.techelevator;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestWordCount {

	WordCount testCode = new WordCount();	//Define an object with the methods to be tested
	
	@Test
	public void test_getCount_to_return_the_correct_map() {
	// Define a String Array to use in the test and needs to have some duplicates
	// Arrange 
	String[] stringArray = {"Jeff", "Aiden", "Avery", "Sam", "Sam", "Avery"};
	
	// Define a Map with my expected result using the test data
	Map<String, Integer> expectedResultMap = new HashMap<String, Integer>();
	
	
	expectedResultMap.put("Jeff", 1);
	expectedResultMap.put("Aiden", 1);
	expectedResultMap.put("Avery", 2);
	expectedResultMap.put("Sam", 2);
	
	// Run the method to be tested and check that it returns what we expect
	assertEquals(expectedResultMap, testCode.getCount(stringArray));
	}
}
