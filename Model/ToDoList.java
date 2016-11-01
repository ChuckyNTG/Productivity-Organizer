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
		String priorityString = kbd1.next();
		System.out.print("Enter the due date of the task(year,month,day): ");
		int year = kbd1.nextInt();
		int month = kbd1.nextInt();
		int day = kbd1.nextInt();

		month = month -1;

		Calendar date = dateSetup(year,month,day); 
		kbd1.nextLine();

		static Job newest = new Job(name,description,priorityString,date);
		list.add(newest);
		System.out.println("Job successfully added.");
	}

	public void remove()
	{
		//Question: If job is static and removed from one datastructure (arraylist i.e.)
		//then would the java garbage collector delete and remove it from the other 
		//data structure?

		System.out.print("Enter the postion of the job you want removed: ");
		int position = kbd1.nextInt();
		int id = kbd1.nextInt();
		list.remove(position, id);
		System.out.println("The job has been removed.");
		
	}
	//Used to change one of a jobs fields
	public void change()
	{
		
		System.out.print("Enter the id you wanna change: ");
		int id = kbd1.nextInt();
		
		System.out.print("Enter the field you wanna change: ");
		String textField = kbd1.nextLine(); 	
		
		System.out.print("Enter the new text: "):
		String newText = kbd1.nextLine();

		switch(textField){
			case "name":
				list.getJob(id).setName(newText);
				break;
			case "description":
				list.getJob(id).setDescription(newText);
				break;
			case "priority":
				list.getJob(id).setPriority(newText);
			default:
				System.out.println("Change could not be made due to invalid field name.");
				break;
		}

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
			System.out.print("Please enter the operation you'd like to perform(add,remove,change,print,quit): ");
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
