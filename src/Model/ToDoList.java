package Model;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Calendar.Builder;

public class ToDoList
{
	Model _model = new Model();
		
	Scanner kbd1 = new Scanner(System.in);

	public void add()
	{
		System.out.print("Enter the name of the job: ");
		String name = kbd1.nextLine();
		System.out.print("Enter the description of the job: ");
		String description = kbd1.nextLine();
		System.out.print("Enter the priority of the job (low,medium,high): ");
		String priorityString = kbd1.next();
		System.out.println("Enter the date: ");
		String date = kbd1.next();
		
		kbd1.nextLine();

		Job newest = new Job(name,description,priorityString,date);
		_model.add(newest);
		System.out.println("Job successfully added.");
	}

	public void remove()
	{
		//Question: If job is static and removed from one datastructure (arraylist i.e.)
		//then would the java garbage collector delete and remove it from the other 
		//data structure?

		System.out.print("Enter the postion of the job you want removed: ");
		int index = kbd1.nextInt();
		Job j = _model.getTasks().get(index);
		_model.remove(j);
		System.out.println("The job has been removed.");
		
	}
	//Used to change one of a jobs fields
	public void change()
	{
		
		System.out.print("Enter the position of the job you wanna change: ");
		int position = kbd1.nextInt();
		kbd1.nextLine();
		
		System.out.print("Enter the field you wanna change: ");
		String textField = kbd1.nextLine(); 	
		
		System.out.print("Enter the new text: ");
		String newText = kbd1.nextLine();

		switch(textField)
		{
			case "name":
				_model.getTasks().get(position).setName(newText);
				break;
			case "description":
				_model.getTasks().get(position).setDescription(newText);
				break;
			case "priority":
				_model.getTasks().get(position).setPriority(newText);
				break;
			default:
				System.out.println("Change could not be made due to invalid field name.");
				break;
		}

	}	
	public void sort()
	{
		System.out.println("Enter the parameter you want to sort by: ");
		String sortParameter = kbd1.nextLine();
		_model.sort(sortParameter);
	}
/**
	public void filter(){
		System.out.println("Enter the parameter you want to filter based on: ");
		String filterParameter = kbd1.nextLine();
		System.out.println("Enter the minimum value");
		Comparable minimum = kbd1.nextLine();
		try{
			minimum = Integer.parseInt((String) minimum);
		}
		catch(Exception e){};

		System.out.println("Enter the maximum value");
		Comparable maximum = kbd1.nextLine();
		try{
			maximum = Integer.parseInt((String) maximum);
		}
		catch(Exception e){};

		System.out.println("Enter the parameter to sort the results by:");
		String sortParameter = kbd1.nextLine();

		System.out.println("Smallest first or largest first? (Enter smallest or largest)");
		Comparator comparator = kbd1.nextLine().equalsIgnoreCase("largest") ? ListSort.LARGESTFIRST : ListSort.SMALLESTFIRST;

		ArrayList<Job> out = _model.sort(sortParameter,  new Filter.RangeFilter(filterParameter, minimum, maximum), comparator);
		for(int i = 0; i < out.size(); i ++)
			System.out.println(out.get(i));

	}
*/
	public void print()
	{
		_model.printList();
	}
	/*
	public Calendar dateSetup(int year, int month, int day,int hour,int minute,int second)
	{
		System.out.print("Enter the due date of the task(year,month,day): ");
		int year = kbd1.nextInt();
		int month = kbd1.nextInt();
		int day = kbd1.nextInt();
		month = month -1;
		Calendar date = new Calendar.Builder()
				.setCalendarType("gregory")
				.setDate(year,month,day)
				.setTimeOfDay(hour,minute,second)
				.build();
	
		return date;
	}
	*/	
	public Calendar dateSetup()
	{
		System.out.print("Enter the due date of the task(year,month,day): ");
		int year = kbd1.nextInt();
		int month = kbd1.nextInt();
		int day = kbd1.nextInt();

		month = month -1;
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
			System.out.print("Please enter the operation you'd like to perform(add,remove,change,print,sort,filter,quit): ");
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
				case "change":
					toDoList.change();
					running=true;
					break;
				case "sort":
					toDoList.sort();
					running=true;
					break;	
				case "print":
					toDoList.print();
					running=true;
					break;
				case "filter":
					
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
