import java.util.ArrayList;
import java.util.Comparator;

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

	public void remove(int entry) 
	{
		list.remove(entry-1);
		sort();
	}

	public void sort()
	{
		sort("date");
	}

	public void sort(String attribute)
	{
		list.sort(new Comparator<Job>() {
			@Override
			public int compare(Job job, Job t1) {
				return job.getAtrribute(attribute).compareTo(t1.getAtrribute(attribute));
			}
		});
	}
	/*
	public void inSort(int position, Job value)
	{
		int j = position -1;

		while(j>=0 && list.get(j).getDate().getTime().compareTo(value.getDate().getTime())>0)
		{
			list.set(j+1,list.get(j));
			j=j-1;
		}
		list.set(j+1,value);
	}
	*/
	public void printList()
	{
		System.out.println("The details of the list:");
	
		for(Job job:list)
		{
			System.out.println(job.toString());				
		}
	}

	@Override
	public String toString(){
		String out = "";
		for(Job job : list){
			if(out.length() >= 1)
				out += '\n';
			out += job.toString();
		}
		return out;
	}
}
