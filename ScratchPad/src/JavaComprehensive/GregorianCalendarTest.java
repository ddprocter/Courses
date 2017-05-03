package JavaComprehensive;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarTest {

	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();
		calendar.set(2008,06,16);
		calendar.add(Calendar.MONTH, 1);
		System.out.println("Month " + calendar.get(Calendar.MONTH));
		
		calendar.add(Calendar.DATE, -10);
		System.out.println("Day= " + calendar.get(Calendar.DATE));
		
		System.out.println("Max days in a mo:" + calendar.getMaximum(Calendar.DAY_OF_MONTH));
		
		calendar.set(Calendar.YEAR, 2016);
		calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		System.out.println("Max days in Feb is " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		
	}

}
