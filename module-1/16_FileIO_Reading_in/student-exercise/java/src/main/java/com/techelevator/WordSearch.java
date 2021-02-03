package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
	
	File theFile = new File("./alices_adventures_in_wonderland.txt");
	Scanner WordSearch = new Scanner(theFile);
	
	Scanner searchInput = new Scanner(System.in);
	System.out.println("What is the search word you are looking for?");
	String searchedWord = searchInput.nextLine();
	System.out.print("Should the search be case sensitive? (Y/N):");
	String caseSensitive = searchInput.nextLine();
	searchInput.close();
	
	
	int counter = 1;
	
	if (caseSensitive.contains("Y") || caseSensitive.contains("y")) {
		while(WordSearch.hasNext()) {
			String aLine = WordSearch.nextLine();
			if (aLine.contains(searchedWord)) {
				System.out.println(counter + ") " + aLine);
				}
			counter++;
			}	
		} else {
			while (WordSearch.hasNext()) {
				String aLine = WordSearch.nextLine();
				if (aLine.toLowerCase().contains(searchedWord.toLowerCase())) {
					System.out.println(counter + ") " + aLine);
				}
				counter++;
			}
	}
	
	WordSearch.close();
			
	}

}
