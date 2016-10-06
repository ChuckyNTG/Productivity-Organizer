import java.util.Calendar.Builder;
import java.util.Calendar;
import java.util.Scanner;

public class Calendartest
{
	

	public static void main(String[] args)
	{
		Calendar date = new Calendar.Builder().setCalendarType("gregory")
				.setDate(2016,1,29)
				.build();	
		System.out.println("The date is: " + date.getTime());
	}
}
		

