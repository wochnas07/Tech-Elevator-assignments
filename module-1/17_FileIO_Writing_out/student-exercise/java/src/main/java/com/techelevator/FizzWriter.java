package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) throws IOException {

		File FizzBuzz = new File("./FizzBuzz.txt");
		
		FizzBuzz.createNewFile();
		
		PrintWriter fizzPrinter = new PrintWriter(FizzBuzz);
		
		for (Integer i =1; i < 301; i++) {
			
			if((i % 5 == 0) && (i % 3 == 0)) {
				fizzPrinter.write(i + ": " + "FizzBuzz\n");
			} if ((i % 5 == 0) || (i.toString().contains("5"))) {
				fizzPrinter.write(i + ": " + "Buzz\n");
			} if ((i % 3 == 0) || (i.toString().contains("3"))) {
				fizzPrinter.write(i + ": " + "Fizz\n");
			} else {
				fizzPrinter.write(i + ": \n");
			}
	
	}
	fizzPrinter.close();
	}

}
