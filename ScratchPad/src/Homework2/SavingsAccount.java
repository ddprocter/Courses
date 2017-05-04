package Homework2;

import java.math.BigDecimal;
import java.math.MathContext;

public class SavingsAccount extends Account {
	
	private int day;
	private int month;
	private int year;
	
	public SavingsAccount(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
		
		
	}
	
	public SavingsAccount(BigDecimal balance, float interestRate){
		super(balance, interestRate);
		
		
	}
	
	public void deposit(BigDecimal amount) {
		setBalance(amount.add(getBalance()));	
		
	}
	
	public boolean withdraw(BigDecimal amount) {
		
		BigDecimal zero = new BigDecimal(0);
		BigDecimal balance = getBalance();
		if (balance.subtract(amount).compareTo(zero) >= 0) {
			setBalance(balance);
			return true;
		} else {
			return false;
		}

	}
	
	public BigDecimal computeInterest(){
		
			BigDecimal monthlyInterest;
			BigDecimal balance = getBalance();
			BigDecimal interestRate = new BigDecimal(getInterestRate());
			BigDecimal twelve = new BigDecimal(12);
			
			monthlyInterest = balance.multiply(interestRate);
			monthlyInterest.divide(twelve, MathContext.DECIMAL32);
			
			return monthlyInterest;
						
	}
	

}
