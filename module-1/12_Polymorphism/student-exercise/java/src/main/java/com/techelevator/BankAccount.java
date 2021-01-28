package com.techelevator;

// a BankAccount is a type of Accountable class

public class BankAccount implements Accountable{

    private String accountHolderName;
    private String accountNumber;
    private int balance;

    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolder, String accountNumber, int balance) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {	// required by the Accountable interface
        return balance;
    }

    // Update the balance by using the DollarAmount.Plus method
    public int deposit(int amountToDeposit) {
        balance = balance + amountToDeposit;
        return balance;
    }

    // Update the balance by using the DollarAmount.Minus method
    public int withdraw(int amountToWithdraw) {
        balance = balance - amountToWithdraw;
        return balance;
    }
    
    public int transferTo(BankAccount destinationAccount, int transferAmount) {
    	withdraw(transferAmount);
    	destinationAccount.deposit(transferAmount);
    	return getBalance();
    
// the transferTo method takes the destination-account and amount as parameters
//
//		aBankAccountObject (destination-account, amount)
//
//		transfer the amount from the BankAccountObject in the front of the . to the destination
//
// 		jasonAcct.transferTo(frankAcct, 1000) - this will transfer $1000 from jasonAcct to frankAcct
//												return the balance in jasonAcct - sending account
    
    
    }
}
