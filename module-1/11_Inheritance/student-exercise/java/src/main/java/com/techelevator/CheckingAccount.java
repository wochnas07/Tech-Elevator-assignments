package com.techelevator;

public class CheckingAccount extends BankAccount {
	
	public CheckingAccount(String accountHolder, String accountNumber, int balance) {
		super (accountHolder, accountNumber, balance);
	}
	
	public CheckingAccount(String accountHolder, String accountNumber) {
		super (accountHolder, accountNumber);
	}
	
	public int withdraw(int amountToWithdraw) {
		int newBalance = getBalance() - amountToWithdraw;
		if (newBalance < 0 && newBalance > -100) {
			super.withdraw(amountToWithdraw);
			return super.withdraw(10);
		}
		if (newBalance <= -100) {
			return getBalance();
		} else {
			super.withdraw(amountToWithdraw);
			return getBalance();
		}
	}

}
