package Homework2;

import java.lang.Math;
import java.util.Scanner;

public class MortgageCalculator extends FinancialCalculator {
	
	private double amountBorrowed = 0;
	private double interestRate = 0;
	private int numberOfPaymentsPerYear = 12; 
	private int term = 0;
	
	private double monthlyPayment = 0 ;
	private double totalInterestPaid = 0; 
	

	public MortgageCalculator() {
		// TODO Auto-generated constructor stub
	}

	
	protected void getUserInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter total amount borrowed:\n");
		amountBorrowed = scanner.nextDouble();
		System.out.print("Enter interest rate:\n");
		interestRate = scanner.nextDouble() / 100.0;
		System.out.print("Enter loan term in years:\n");
		term = scanner.nextInt();
		scanner.close();
		
		
		

	}

	
	protected void compute() {
		
	
		monthlyPayment = 
				(this.amountBorrowed * this.interestRate / (double) this.numberOfPaymentsPerYear) /
				(1.0 - ( 1.0 / Math.pow( 
						( 1.0 + this.interestRate / this.numberOfPaymentsPerYear), 
						this.numberOfPaymentsPerYear * (double) this.term   )
						)
				);
		totalInterestPaid = monthlyPayment * numberOfPaymentsPerYear * term;
		
		System.out.printf("Total Interest Paid for the lifetime of this mortgage will be:\n%.2f", totalInterestPaid);

	}

	public static void main(String[] args) {
		MortgageCalculator calc = new MortgageCalculator();
		calc.getUserInput();
		calc.compute();

	}

}
