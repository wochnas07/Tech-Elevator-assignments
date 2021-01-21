package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercises {

	/*
	 Note, for-each is preferred, and should be used when possible.
	 */

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 array2List( {"Apple", "Orange", "Banana"} )  ->  ["Apple", "Orange", "Banana"]
	 array2List( {"Red", "Orange", "Yellow"} )  ->  ["Red", "Orange", "Yellow"]
	 array2List( {"Left", "Right", "Forward", "Back"} )  ->  ["Left", "Right", "Forward", "Back"]
	 */
	public List<String> array2List(String[] stringArray) {
		ArrayList<String> result = new ArrayList();		// what is being returned from the function
		
		// go through the array that is passed in, one element at a time
		// Assign each element in the array to the ArrayList
		
		for(int i=0; i < stringArray.length; i++) {
			result.add(stringArray[i]); // add the current element to the ArrayList
		}
		return result;		// return the result
	}

	/*
	 Given a list of Strings, return an array containing the same Strings in the same order
	 list2Array( ["Apple", "Orange", "Banana"] )  ->  {"Apple", "Orange", "Banana"}
	 list2Array( ["Red", "Orange", "Yellow"] )  ->  {"Red", "Orange", "Yellow"}
	 list2Array( ["Left", "Right", "Forward", "Back"] )  ->  {"Left", "Right", "Forward", "Back"}
	 */
	public String[] list2Array(List<String> stringList) {
		String[] result = new String[(stringList.size())];
		
		for(int i=0; i < result.length; i++) {
			result[i] = stringList.remove(0);
			System.out.println(result[i]);
		}	
		return result;
	}

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 except for any words that contain exactly 4 characters.
	 no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
	 no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
	 no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
	 */
	public List<String> no4LetterWords(String[] stringArray) {
		List<String> no4LetterWords = new ArrayList<String>();
		
		for (String words : stringArray) {
			if (words.length() != 4) {
				no4LetterWords.add(words);
			}
		}
		return no4LetterWords;
	}

	/*
	 Given an array of ints, divide each int by 2, and return an ArrayList of Doubles.
	 arrayInt2ListDouble( {5, 8, 11, 200, 97} ) -> [2.5, 4.0, 5.5, 100, 48.5]
	 arrayInt2ListDouble( {745, 23, 44, 9017, 6} ) -> [372.5, 11.5, 22, 4508.5, 3]
	 arrayInt2ListDouble( {84, 99, 3285, 13, 877} ) -> [42, 49.5, 1642.5, 6.5, 438.5]
	 */
	public List<Double> arrayInt2ListDouble(int[] intArray) {
		List<Double> result = new ArrayList();
			for (Integer i : intArray) {
				double intsDivided = i * 0.5;
				result.add(intsDivided);
			}
		return result;
	}

	/*
	 Given a List of Integers, return the largest value.
	 findLargest( [11, 200, 43, 84, 9917, 4321, 1, 33333, 8997] ) -> 33333
	 findLargest( [987, 1234, 9381, 731, 43718, 8932] ) -> 43718
	 findLargest( [34070, 1380, 81238, 7782, 234, 64362, 627] ) -> 64362
	 */
	public Integer findLargest(List<Integer> integerList) {
		return Collections.max(integerList);
	}

	/*
	 Given an array of Integers, return a List of Integers containing just the odd values.
	 oddOnly( {112, 201, 774, 92, 9, 83, 41872} ) -> [201, 9, 83]
	 oddOnly( {1143, 555, 7, 1772, 9953, 643} ) -> [1143, 555, 7, 9953, 643]
	 oddOnly( {734, 233, 782, 811, 3, 9999} ) -> [233, 811, 3, 9999]
	 */
	public List<Integer> oddOnly(Integer[] integerArray) {
		List<Integer> result = new ArrayList();
		for (Integer i : integerArray) {
			if (i % 2 != 0) {
				result.add(i);
			}
		}
		return result;
	}

	/*
	 Given a List of Integers, and an int value, return true if the int value appears two or more times in
	 the list.
	 foundIntTwice( [5, 7, 9, 5, 11], 5 ) -> true
	 foundIntTwice( [6, 8, 10, 11, 13], 8 -> false
	 foundIntTwice( [9, 23, 44, 2, 88, 44], 44) -> true
	 */
	public boolean foundIntTwice(List<Integer> integerList, int intToFind) {
		return false;
	}

	/*
	 Given an array of Integers, return a List that contains the same Integers (as Strings). Except any multiple of 3
	should be replaced by the String "Fizz", any multiple of 5 should be replaced by the String "Buzz",
	and any multiple of both 3 and 5 should be replaced by the String "FizzBuzz"
	** INTERVIEW QUESTION **
	
	fizzBuzzList( {1, 2, 3} )  ->  [1, 2, "Fizz"]
	 fizzBuzzList( {4, 5, 6} )  ->  [4, "Buzz", 6]
	 fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} )  ->  [7, 8, "Fizz", "Buzz", 11, "Fizz", 13, 14, "FizzBuzz"]
	
	 HINT: To convert an integer x to a string you can call x.toString() in your code (e.g. if x = 1 then x.ToString()
	 equals "1")
	 */
	public List<String> fizzBuzzList(Integer[] integerArray) {
		return null;
	}

	/*
	 Given two lists of Integers, interleave them beginning with the first element in the first list followed
	 by the first element of the second. Continue interleaving the elements until all elements have been interwoven.
	 Return the new list. If the lists are of unequal lengths, simply attach the remaining elements of the longer
	 list to the new list before returning it.
	 interleaveLists( [1, 2, 3], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
	 */
	public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {
		// Define what needs to be returned
		List<Integer> newList = new ArrayList();
		
		// Code the "happy path" first - the lists are the same size
		// Code for the "edge case" where lists are different lengths
		//		Interleave for the length of the shorter list
		// 				We need to determine what is the shorter one and it's length
		boolean firstShorter = listOne.size() <listTwo.size(); 		// figure out if first list is shorter
		int sizeOfShorter = 0;
		
		if (firstShorter) {
			sizeOfShorter = listOne.size();
		} else {
			sizeOfShorter = listTwo.size();
		}
		// sizeOfShorter contains the number of elements in the shorter list
		
		
		// Loop through all the elements in both lists one at a time for the length of the shorter list
		// Add the current element in listOne to the newList then add current elem in listTwo to the newList
		for (int i=0; i < sizeOfShorter; i++) {	// Loop for the length of the shorter
			newList.add(listOne.get(i));			// Add the current element in listOne to newList
			newList.add(listTwo.get(i));			// Add the current element in listTwo to newList
			
		}
		// add the remaining elements from the longer list to the new list
		
		// We start adding elements from the longer list from the element # that matches the length of the shorter
		if (firstShorter) {		// if the first was shorter - add the remaining elements from the second
			for (int i = sizeOfShorter; i < listTwo.size(); i++) {	// loop from where we left off to the end of the second list
				newList.add(listTwo.get(i));		// Add the current element to the new list
				
			}
		}
		else { 		// if the second one was shorter - add the remaining element from the first
			for (int i = sizeOfShorter; i < listOne.size(); i++) {	// loop from where we left off to the end of the first list
				newList.add(listOne.get(i));		// Add the current element to the new list
		}
		return newList;
	}
		return newList;
	}
}

