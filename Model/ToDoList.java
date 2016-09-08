import java.util.Scanner;

public class ToDoList
{
	HeapPriorityQueue heap = new HeapPriorityQueue();
	
	Scanner kbd1 = new Scanner(System.in);

	public void add()
	{
		System.out.println("Enter the name of the job: ");
		String name = kbd1.nextLine();
		System.out.print("Enter the description of the job: ");
		String description = kbd1.nextLine();
		System.out.print("Enter the priority of the job: ");
		int priority = kbd1.nextInt();
		
		heap.insert(name,description,priority); 
		System.out.println("Job successfully added.");
	}

	public void remove()
	{
		System.out.println("Please enter the job you'd like to remove.");


	public static void main(String[] args)
	{
		Scanner kbd2 = new Scanner(System.in);
			
		boolean running = 1;
		while(running)
		{
			System.out.print("Please enter the operation you'd like to perform: ");
			String choice=kbd2.next();
			
			switch (choice)
			{
				case "add":
					running = 1;
					break;
				case "remove":
					running=1;
					break;
				case "list":
					running=1;
					break;
				case "quit":
					running=1;
					break;
				default:
					System.out.println("Invalid operation.");
					running=1;
					break;	
			}
		}
	}	

