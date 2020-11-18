package com.bankaccount;

public class BankAccountTest {
	public static void main(String[] args) {
		
		
		BankAccountClass account1 = new BankAccountClass();
		BankAccountClass account2 = new BankAccountClass();
		BankAccountClass account3 = new BankAccountClass();
		
		
		
				
		account1.myAccount("", 875.45, 24.33);
		account2.myAccount("", 76.22, 227);
		account3.myAccount("", 200.45, 1000);
		
		account1.getBalance();
		account1.getSavings();
		account1.getTotal();
		
		account2.depositMoney(35.56, "savings");
		account3.depositMoney(100.00, "checking");
		
		account3.withdrawMoney(40, "savings");
		account3.withdrawMoney(2000, "checking");
		account3.withdrawMoney(20, "checking");

		
		
		
		
	}

}
