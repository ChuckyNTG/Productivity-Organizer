import java.util.Calendar.Builder;
import java.util.Calendar;
import java.util.Scanner;

public class Calendartest
{
	

	public static void main(String[] args)
	{
		Calendar date = new Calendar.Builder().setCalendarType("gregory")
				.setDate(2016,8,29)
				.setTimeOfDay(11,43,30)
				.build();
		
		System.out.println("The date is: " + date.getTime());
	}
}
		

