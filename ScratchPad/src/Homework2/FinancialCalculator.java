package Homework2;

import java.util.*;

public abstract class FinancialCalculator {
	
	// calendar 
	protected Calendar calendar;
	
	// returns number of days for the current month set on the calendar
	protected int getDaysInMonth() {
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	protected int getDaysInYear() {
		return calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
		
	}
	
	protected abstract void getUserInput();
	protected abstract void compute();
	

}
