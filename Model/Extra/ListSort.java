import java.util.ArrayList;

public class ListSort
{
	private ArrayList<Job> list;

	public ListSort()
	{
		list = new ArrayList<Job>();
	}
	
	public void add(Job job)
	{
		list.add(job);
		sort();
	}

	public void remove(int priority)
	{
		list.remove(priority);
		sort();
	}

	public void sort()
	{
		for (int i=1; i<list.size();i++)
		{
			inSort(i,list.get(i));
		}
	}
	
	public void inSort(int position, Job value)
	{
		int j = position -1;
		while(j>=0 && list.get(j).getPriority()>value.getPriority())
		{
			list.set(j+1,list.get(j));
			j=j-1;
		}
		list.set(j+1,value);
	}

	public void printList()
	{
		System.out.println("The details of the list:");
	
		for(Job job:list)
		{
			System.out.println("Priority: " + job.getPriority());
			System.out.println("Name: " + job.getName());
			System.out.println("Description: " + job.getDescription());
			System.out.println(" ");
						
		}
	}			
}
