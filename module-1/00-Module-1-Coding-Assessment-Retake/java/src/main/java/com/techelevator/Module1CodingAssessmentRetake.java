package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Module1CodingAssessmentRetake {
	
    private static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	public void run() throws IOException {			
		File lastLog = new File("TicketInput.csv");
			
	System.out.println("Select Orchestra, Balcony, General, or Promo: ");
    String ticketType = userInput.nextLine();


    System.out.println("Ticket Type: " + ticketType);
    
    System.out.println("Would you like a t-shirt? (Y/N): ");
    String shirtPurchased = userInput.nextLine();
    
    System.out.println("Is the ticket VIP? (Y/N): ");
    if (userInput == "Y") {
    	boolean isVip = true;
    }
    else
    	isVip = false;
	}

}
