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
	}

	public void remove(String jobName)
	{
		
		int index=list.indexOf(job);	
		list.remove(index);
	}

	public void sort()
	{
		for (int i=1; i<list.size()-1;i++)
		inSort(i,list.get(i));
	}
	
	public void inSort(int position, Job value)
	{
		int i = position -1;
		while(i>=0 && list.get(i).getPriority()>value.getPriority())
		{
			list.set(i+1,list.get(i));
			i=i-1;
		}
		list.set(i+1,value);
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
