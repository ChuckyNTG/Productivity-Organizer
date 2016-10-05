import java.util.Scanner;

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
		System.out.print("Enter the priority of the job: ");
		String priority = kbd1.next();
		kbd1.nextLine();
		
		Job newest = new Job(name,description,priority);
		list.add(newest);
		System.out.println("Job successfully added.");
	}

	public void remove()
	{
		System.out.print("Enter the priority of the job you want removed: ");
		int priority = kbd1.nextInt();
		list.remove(priority);
		System.out.println("The job has been removed.");
		
	}

	public void print()
	{
		list.printList();
	}
	public static void main(String[] args)
	{
		ToDoList toDoList = new ToDoList();
		Scanner kbd2 = new Scanner(System.in);
			
		boolean running = true;
		while(running)
		{
			System.out.print("Please enter the operation you'd like to perform: ");
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
