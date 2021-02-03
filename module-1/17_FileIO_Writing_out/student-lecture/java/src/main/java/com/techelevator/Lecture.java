package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {
		
		Scanner userInput = new Scanner(System.in);
		
		/* 
		 * TLDR: when you have a File object instantiated you can do a lot of stuff with it
		 * 
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and 
		 * modify file system objects.
		 * 
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 * 
		 * A new instance of File can be created from a String that contains a file system path 
		 */
		
		System.out.print("Enter the path of a file or directory >>> ");
		String path = userInput.nextLine();
		File f = new File(path);

		/* 
		 * The File class allows us to inspect various attributes of a file system object 
		 * 
		 * The File class provides many methods to allow you to access the file system of your computer
		 * 
		 * Does a file exist?
		 * How long is the file? (how many chars are in the file; 0=file is empty
		 * Create new empty files
		 * Create new directories
		 * Remove or delete files
		 * Remove or delete directories
		 * 
		 * Many of the things you can do from the Command Line, you can do in a program with a File object
		 * 
		 */
		 
		/* ***************************
		 * INSPECTING THE FILESYSTEM 
		 * ***************************/
		
		System.out.println();
		if(f.exists()) { // returns true if a file or directory exists at the file system location, otherwise returns false
			System.out.println("name: "+f.getName());
			System.out.println("absolutePath: "+f.getAbsolutePath());
			if(f.isDirectory()) {
				System.out.println("type: directory");
			} else if(f.isFile()) {
				System.out.println("type: file");
			}
			System.out.println("size : "+f.length());
		} else {
			System.out.println(f.getAbsolutePath()+" does not exist.");
		}
		
		/* 
		 * The File class also allows us to manipulate file system objects 
		 * */
		 
		/* ************************
		 * CREATING A DIRECTORY 
		 * ************************/
		
		System.out.println();
		System.out.println("Let's create a new directory.");
		System.out.print("Enter the path of the new directory >>> ");
		path = userInput.nextLine();
		File newDirectory = new File(path);
		
		if(newDirectory.exists()) {
			System.out.println("Sorry, "+newDirectory.getAbsolutePath()+" already exists.");
			System.exit(1);
		} else {
			if(newDirectory.mkdir()) {
				System.out.println("New directory created at "+newDirectory.getAbsolutePath());
			} else {
				System.out.println("Could not create directory.");
				System.exit(1);
			}
		}
		 
		/* ************************
		 * CREATING A FILE 
		 * ************************/
		
		System.out.println();
		System.out.println("Now let's put a file in the directory.");
		System.out.print("Enter a name for the new file >>> ");
		String fileName = userInput.nextLine();
		File newFile = new File(newDirectory, fileName);	// Define a file object for the directory and file we want to create
															// if directory is omitted, we assume the default directory
															//		which is the same as the project directory
		newFile.createNewFile();							// Create a new empty file specified in the File object
		
		System.out.println();
		System.out.println("name: "+newFile.getName());
		System.out.println("absolutePath: "+newFile.getAbsolutePath());
		System.out.println("size : "+newFile.length());
		
		 
		/* ************************
		 * WRITING TO A FILE 
		 * ************************/
		
		System.out.println();
		System.out.println("Now let's write something in the new file.");
		System.out.print("Enter a message to be stored in the new file >>> ");
		String message = userInput.nextLine();
		
		// Create a PrintWriter object using the File object for the file you want to write to
		try(PrintWriter writer = new PrintWriter(newFile)) {	// Putting the PrintWriter instantiation in a try so we don't have to close it
			writer.println(message);	// Use the same methods as you did with System.out.println, .print, .printf 
		} // When we exit the try block, this cause the file to be closed and an automatic flush of the buffer to trigger
		
		
		System.out.println();
		System.out.println("name: "+newFile.getName());
		System.out.println("absolutePath: "+newFile.getAbsolutePath());
		System.out.println("size : "+newFile.length());
		
	}

