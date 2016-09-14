import java.util.ArrayList;

public class Sorttest
{

	ArrayList<Job> list = new ArrayList<Job>();
	public Sorttest()
	{
		Job newest1 = new Job("Homework","Doinghomework",3);
		list.add(newest1);
		Job newest2 = new Job("Reading","Reading",1);
		list.add(newest2);
		Job newest3 = new Job("Writing","writing",2);
		list.add(newest3);
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
