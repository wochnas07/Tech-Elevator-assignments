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
	private Accountable[]	accounts;

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

	private List<Accountable> accountArray = new ArrayList<>();   // List of Accountable objects
    					// convert ArrayList to array
    					// create getter for accounts to return ArrayList
    
    public Accountable[] getAccounts() {
    	return accountArray.toArray(new Accountable[accountArray.size()]);	// replace null with the normal array containing Accounts
    }
    
    public void addAccount(Accountable newAccount) {
    	accountArray.add(newAccount);
    	
    }
    
    public boolean isVip() {
    	int totalMoney = 0;
    	for (Accountable i : accountArray) {
    	totalMoney = (totalMoney + i.getBalance());
    	}
    	if (totalMoney >= 25000) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
