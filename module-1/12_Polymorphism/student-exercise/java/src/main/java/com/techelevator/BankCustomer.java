package com.techelevator;

import java.util.ArrayList;
import java.util.List;

/**
 * BankCustomer
 */
public class BankCustomer {
	
	private String			name;
	private String			address;
	private String			phoneNumber;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	private List<Accountable> accounts = new ArrayList<>();   // List of Accountable objects
    					// convert ArrayList to array
    					// create getter for accounts to return ArrayList
    
    public Accountable[] getAccounts() {
    	return null;	// replace null with the normal array containing Accounts
    }
    
    public addAccount(Accountable newAccount) // didnt finish this line? not sure

    
}

//the transferTo method takes the destination-account and amount as parameters
//
//		aBankAccountObject (destination-account, amount)
//
//		transfer the amount from the BankAccountObject in the front of the . to the destination
//
//		jasonAcct.transferTo(frankAcct, 1000) - this will transfer $1000 from jasonAcct to frankAcct
//												return the balance in jasonAcct - sending account
 