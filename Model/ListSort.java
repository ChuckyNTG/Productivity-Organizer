import java.util.Array;

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

	public void remove(Job job)
	{
		

	public void sort()
	{
		for (int i=1; i<list.size()-1;i++)
		insert(i,list.get(i));
	}
	
	public void insert(int position, int value)
	{
		i = pos -1;
		while(i>=0 && list.get(i)>value)
		{
			list.set(i+1,list.get(i));
			i=i-1;
		}
		list.set(i+1,value);
	}

	public void printList()
	{
		for(Job job:list)
		{
				
				
