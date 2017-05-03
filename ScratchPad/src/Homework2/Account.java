package Homework2;

import java.math.BigDecimal;

public class Account {
	private int number;
	private String name;
	private BigDecimal balance;
	private float interestRate;
	
	public Account(){
	
	}
	
	public Account(BigDecimal balance, float interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
		
	}
	
	public Account(int number, String name, BigDecimal balance, float interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.name = name;
		this.number = number;
		
		
	}
	
	
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	
	
	
	
	

}
