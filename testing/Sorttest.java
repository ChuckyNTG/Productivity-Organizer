import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Sorttest
{

	ArrayList<Job> list = new ArrayList<Job>();
	public Sorttest()
	{
		Job newest1 = new Job("Homework","Doinghomework", "Low", Calendar.getInstance());
		list.add(newest1);
		Job newest2 = new Job("Reading","Reading", "medium", Calendar.getInstance());
		list.add(newest2);
		Job newest3 = new Job("Writing","writing", "High", Calendar.getInstance());
		list.add(newest3);
	}

	public void sort()
	{
		sort("date");
	}

	public void sort(String attribute)
	{
		list.sort(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o1.getAtrribute(attribute).compareTo(o2.getAtrribute(attribute));
			}
		});
	}

	
	public void print()
	{
		for(Job job:list)
		{
			System.out.println("The priority of the job is: " + job.getPriority());
		}
	}
	public static void main(String[] args)
	{
		Sorttest test = new Sorttest();
		test.sort();
		test.print();
	}

}
