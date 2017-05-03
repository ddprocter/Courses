package Homework2;

import java.math.BigDecimal;

public class TestSavingsAccount {

	public static void main(String[] args) {
		
		BigDecimal balance = new BigDecimal(1000.0);
		SavingsAccount acct1 = new SavingsAccount(balance, (float) .025);
		BigDecimal yearlyInterest1 = acct1.computeInterest();
		BigDecimal twelve = new BigDecimal(12);
		yearlyInterest1.multiply(twelve);
		System.out.println("Yearly Interest for Acct 1: " + yearlyInterest1.floatValue());
		
		
		BigDecimal balance2 = new BigDecimal(24000.0);
		SavingsAccount acct2 = new SavingsAccount(balance2, (float) .015);
		BigDecimal yearlyInterest2 = acct2.computeInterest();
		yearlyInterest2.multiply(twelve);
		System.out.println("Yearly Interest for Acct 2: " + yearlyInterest2.floatValue());
	}

}
