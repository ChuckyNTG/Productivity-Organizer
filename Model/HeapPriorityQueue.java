import java.util.ArrayList;

public class HeapPriorityQueue
{
	ArrayList<Job> heapArray = new ArrayList<Job>();

	public static int compareInt(int a, int b)
	{
		if(a<b)
		{
			return -1;
		}
		else if (a>b)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
		
	public boolean isEmpty()
	{
		return heapArray.size() == 0;
	}

	public int parent(int j)
	{
		return (j-1)/2;
	}

	public int left(int j)
	{
		return 2*j +1;	
	}

	public int right(int j)
	{
		return 2*j+2;
	}
	
	public boolean hasLeft(int j)
	{
		return left(j)<heapArray.size();
	}
	
	public boolean hasRight(int j)
	{
		return right(j)<heapArray.size();
	}
	
	public void swap(int i, int j,ArrayList heaplist)
	{
		Job temp = heaplist.get(i);
		heaplist.set(i, heaplist.get(j));
		heaplist.set(j, temp);
	}
	
	public void upheap(int j, ArrayList heaplist)
	{
		while(j>0)
		{
			int p = parent(j);
			if(compareInt(heaplist.get(j).getPriority(),heaplist.get(p).getPriority()) >=0)
			{
				break;
			}
			else
			{
				swap(j,p);
				j = p;
			}
		}
	}

	public void downheap(int j, ArrayList heaplist)
	{
		while(hasLeft(j))
		{
			int leftIndex = left(j);
			int childIndex = leftIndex;
			if(hasRight(j))
			{
				int rightIndex = right(j);
				if(compareInt(heaplist.get(leftIndex).getPriority(),heaplist.get(rightIndex).getPriority()) > 0)
				{
					childIndex = rightIndex;
				}
			}
			if(compareInt(heaplist.get(childIndex).getPriority(), heaplist.get(j).getPriority()) >=0)
			{
				break;
			}
			
			swap(j,childIndex);
			j = childIndex;

		}
	}

	public void insert(String name, String description,int priority)
	{
		Job newest = new Job(name,description,priority);
		heapArray.add(newest);

		upheap(heapArray.size()-1,heapArray);
	}

	public Job min()
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			return heapArray.get(0);
		}
	}

	public Job removeMin(ArrayList heaplist)
	{	
		if(isEmpty())
		{
			return null;
		}
		else
		{
			Job first = heaplist.get(0);
			swap(0, heaplist.size()-1);	
			heaplist.remove(heaplist.size()-1);
			downheap(0);
			return first;
		}
	}

	public ArrayList<Job> getHeap()
	{
		ArrayList<Job> heap2 = heapArray;
		return heap2;
	}
			


}
