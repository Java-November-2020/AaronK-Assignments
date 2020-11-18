package com.bankaccount;
import java.util.Random;

public class BankAccountClass {
	public String accountnumber;
	public double checkingbalance;
	public double savingsbalance;
	public static int numOfAccounts = 0;
	public double totalMoney = 0;
		
	
	public void myAccount(String accnum, double chkbal, double savbal) {
		accnum = createAccount();
		accountnumber = accnum;
		checkingbalance = chkbal;
		savingsbalance = savbal;
		numOfAccounts++;
		totalMoney = chkbal + savbal;
		System.out.println("my account number is..." + accountnumber);
		System.out.println(checkingbalance + " dollars in checking.");
		System.out.println(savingsbalance + " dollars in savings.");
		System.out.println("number of active accounts: " + numOfAccounts);
		System.out.println("My account total: " + totalMoney);
		
	}
	
	
	public static String createAccount() {
		String subst = "";
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			subst += r.nextInt(10);

		}
		return subst;
	}
	
	
	public void getBalance() {
		System.out.println("My checking account has: " + this.checkingbalance);
		
	}
	
	public void getSavings() {
		System.out.println("My savings account has: " + this.savingsbalance);
		
	}
	
	public void getTotal() {
		System.out.println("My account total is: " + this.totalMoney);
		
	}
	
	public void depositMoney(double amount, String account) {
		if(account.equals("savings"))
			this.savingsbalance += amount;
		else if(account.equals("checking"))
			this.checkingbalance += amount;
		totalMoney += amount;
		System.out.println("my total money is: " + this.totalMoney);
	}
	
	
	public BankAccountClass withdrawMoney(double amount, String account) {
			
		if(account == "savings") {
			if (amount > this.savingsbalance) {
				System.out.println("sorry, insufficient funds!");
			
			} else {
				this.savingsbalance -= amount;
				this.totalMoney -= amount;
				System.out.println("You have withdrawn " + amount + " dollars from your savings account.");
				System.out.println("current savings amount is " + this.savingsbalance);
			}
		
		
		}else if(account == "checking") { 
			if (amount > this.checkingbalance) 
				System.out.println("sorry, insufficient funds!");
			
		  	} else {
				this.checkingbalance -= amount;
				this.totalMoney -= amount;
				System.out.println("You have withdrawn " + amount + " dollars from your checking account.");
				System.out.println("current checking amount is " + this.checkingbalance);

			}
	return this;
	}
	
	
	
}
