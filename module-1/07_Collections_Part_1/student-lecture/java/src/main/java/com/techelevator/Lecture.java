package com.techelevator;

// The import statement includes Java code into your code that you need for what you are doing
// Usually this is code for Classes you use, but have defined yourself in this code
//
//		format of import statement:	package-name.ClassName
//		package.Class

import java.util.ArrayList;		// Give me access to the code that supports ArrayList
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		
// ArrayList is a type of list that acts similar to an array
//			ArrayList has elements that are stored in the order in which they are added to the ArrayList
//
//		Two ways to define a new ArrayList:
//		
//		ArrayList<data-type-it-holds> name = new ArrayList();
//			List<data-type-it-holds> name = new ArrayList();
//
// 		Define a new ArrayList to hold Strings representing people's names
		
		ArrayList<String> names = new ArrayList();		// new, empty ArrayList of Strings
		
		// the.add() method is used to add elements to an ArrayList
		names.add("Frank");
		names.add("Jason");
		names.add("Sam");
		names.add("Avery");
		names.add("Daniel");
		names.add("D");
		names.add("Joel");
//		names.add(1); 		// error because we are trying to add an int to an ArrayList of Strings
		
		// .size() method returns the number of elements in an ArrayList
		
		System.out.println("Our ArrayList contains " + names.size() + " elements");


		System.out.println("####################");
		System.out.println("Lists are ordered in the order they are entered");
		System.out.println("####################");

		// .get(index) - will retrieve the element at the index specified
		
		for (int i=0; i < names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));	// display the element at index i
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("Avery");		// We can add "Avery" even though it is already in the ArrayList
		
		for (int i=0; i < names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		// .add(index, object) - index is the index where you want the object to be inserted
		
		names.add(3, "Anne");
		
		for (int i=0; i < names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		
		// .remove(index) - remove the element at the index and move all elements up one
		
		names.remove(0);		// remove the element at index 0
		
		for (int i=0; i < names.size(); i++) {
			System.out.println("Element #" + i + ": " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		// .contains(object) - return true if the object is in the ArrayList, false if not
		
		System.out.println("Is Joel in the ArrayList? " + names.contains("Joel"));
		System.out.println("Is Frank in the ArrayList? " + names.contains("Frank"));
		
		if (names.contains("Anne")) {
			System.out.println("Anne is in our list");
		} else {
			System.out.println("Anne is not in the list");
		}
		

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		// .indexOf(object) - return the index of the first occurrance of the object in the ArrayList
		System.out.println("the first time Avery appears in the list is at index " + names.indexOf("Avery"));
		
		// .lastindex(object) - return the index of the last occurrance of the object in the ArrayList
		System.out.println("the last time Avery appears in the list is at index " + names.lastIndexOf("Avery"));


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// .toArray(new datatype[0]) - convert an ArrayList into an array and return array
		
		// Convert the ArrayList<Strings> into a String[]
		
		String[] namesArray = names.toArray(new String[0]);
		
		// Note: .length for an array does not have () - because it's a property of array
		//		.size() for an ArrayList HAS () - because size() is method in the ArrayList class
		//										methods always have ()
		//		a property is a value automatically associated with a data structure
		//		
		//		Whenever you see a word, that is not IF or FOR followed by (), its a method name
		
		for (int i=0; i < namesArray.length; i++) {
			System.out.println("Element #" + i + ": " + namesArray[i]); // display the element at index i
		}

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		// Collections.sort(ArrayListName) - the Collections class provides a sort() method
		//									that can be used with any type of Collection class object
		
		Collections.sort(names);	// Use the Collections class sort() method to sort the ArrayList
									// 		Since the datatype of the ArrayList is String, it will sort alphabetically
		
		for (int i=0; i < names.size(); i++) {
			System.out.println("Element # " + i + ": " + names.get(i));	// display the element at index i
		}
		

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(names);	// Use the Collections class reverse() to reverse the order of the list
		for (int i=0; i < names.size(); i++) {
			System.out.println("Element # " + i + ": " + names.get(i));	// display the element at index i
		}

		System.out.println("####################");
		System.out.println("       FOREACH");
	System.out.println("####################");
		System.out.println();

		// for-each loop is shorthand for-loop when you need to go through the entire array/ArrayList
		//
		// for-each loop always goes from the beginning to the end of array/ArrayList
		//					- cannot start and stop anywhere else
		// Cannot skip elements with a for-each loop - ALL elements are always processed
		// You don't know which element is being processed in the loop - there is no index
		
		// format of the for-each loop: 	for(datatype element-name : array/ArrayList-name)
		//
		//									each time through the loop, the elem-name is assigned the current element
		//									use the elem-name in the loop to reference current element being processed
		
		// Use a for-each loop to display all the elements in the names ArrayList
		
		//	 curr-elem	  ArrayList
		for(String aName : names) {		// Similar to for(int=0; i < names.size(); i++)
			System.out.println("Current element is: " + aName);
		}

	}
}
