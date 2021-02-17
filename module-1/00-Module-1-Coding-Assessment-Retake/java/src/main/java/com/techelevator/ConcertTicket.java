package com.techelevator;

import java.util.Scanner;

public class ConcertTicket {


	/**
	 * @return the ticketType
	 */
	public String getTicketType() {
		return ticketType;
	}



	/**
	 * @param ticketType the ticketType to set
	 */
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}



	/**
	 * @return the shirtPurchased
	 */
	public String getShirtPurchased() {
		return shirtPurchased;
	}



	/**
	 * @param shirtPurchased the shirtPurchased to set
	 */
	public void setShirtPurchased(String shirtPurchased) {
		this.shirtPurchased = shirtPurchased;
	}



	/**
	 * @return the isVip
	 */
	public boolean isVip() {
		return isVip;
	}



	/**
	 * @param isVip the isVip to set
	 */
	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}



	/**
	 * @return the ticketPrice
	 */
	public double getTicketPrice() {
		return ticketPrice;
	}



	/**
	 * @param ticketPrice the ticketPrice to set
	 */
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}



	private String	ticketType;
	private String	shirtPurchased;
	private boolean	isVip;
	private	double	ticketPrice;
	
	public ConcertTicket(String ticketType, String shirtPurchased, boolean isVip) {
		this.ticketType = ticketType;
		this.shirtPurchased = shirtPurchased;
		this.isVip = isVip;
	}
	
//	public double ticketPrice(getTicketType()) {
		if (ticketType = "Orchestra") {
			ticketPrice = 100.00;
		} if (ticketType = "Balcony") {
			ticketPrice = 79.99;
		} if (ticketType = "General") {
			ticketPrice = 50.00;
		} if (ticketType = "Promo") {
			ticketPrice = 0;
		} else
			System.out.println("Selection error. Re-enter your Ticket Type");
}

	
	public void ticketPrice(int daysBefore) {
		if (daysBefore == 0) {
			ticketPrice = ticketPrice;
		}
		if (daysBefore > 0 && daysBefore <= 10) {
			ticketPrice = ticketPrice*0.95;
		}
		if (daysBefore > 10 && daysBefore <= 20) {
			ticketPrice = ticketPrice*0.90;
		}
		if (daysBefore > 20 && daysBefore <= 30) {
			ticketPrice = ticketPrice*0.80;
		}
		else
			ticketPrice = ticketPrice*0.75;
	}

}
