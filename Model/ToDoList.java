import java.util.Scanner;
import java.util.Calendar;
import java.util.Calendar.Builder;

public class ToDoList
{
	ListSort list = new ListSort();
		
	Scanner kbd1 = new Scanner(System.in);

	public void add()
	{
		System.out.print("Enter the name of the job: ");
		String name = kbd1.nextLine();
		System.out.print("Enter the description of the job: ");
		String description = kbd1.nextLine();
		System.out.print("Enter the priority of the job (low,medium,high): ");
		String priority = kbd1.next();
		System.out.print("Enter the due date of the task(year,month,day): ");
		int year = kbd1.nextInt();
		int month = kbd1.nextInt();
		int day = kbd1.nextInt();

		month = month -1;

		Calendar date = dateSetup(year,month,day); 
		kbd1.nextLine();
		
				
		Job newest = new Job(name,description,priority,date);
		list.add(newest);
		System.out.println("Job successfully added.");
	}

	public void remove()
	{
		System.out.print("Enter the order of the job you want removed: ");
		int priority = kbd1.nextInt();
		list.remove(priority);
		System.out.println("The job has been removed.");
		
	}

	public void print()
	{
		list.printList();
	}

	public Calendar dateSetup(int year, int month, int day,int hour,int minute,int second)
	{
		Calendar date = new Calendar.Builder()
				.setCalendarType("gregory")
				.setDate(year,month,day)
				.setTimeOfDay(hour,minute,second)
				.build();
	
		return date;
	}
	
	public Calendar dateSetup(int year, int month, int day)
	{
		Calendar date = new Calendar.Builder()
				.setCalendarType("gregory")
				.setDate(year,month,day)
				.build();

		return date;
	}
	public static void main(String[] args)
	{
		ToDoList toDoList = new ToDoList();
		Scanner kbd2 = new Scanner(System.in);
			
		boolean running = true;
		while(running)
		{
			System.out.print("Please enter the operation you'd like to perform(add,remove,print,quit): ");
			String choice=kbd2.next();
			
			switch (choice)
			{
				case "add":
					toDoList.add();
					running = true;
					break;
				case "remove":
					toDoList.remove();
					running=true;
					break;
				case "print":
					toDoList.print();
					running=true;
					break;
				case "quit":
					running=false;
					break;
				default:
					System.out.println("Invalid operation.");
					running=true;
					break;	
			}
		}
	}	
}
