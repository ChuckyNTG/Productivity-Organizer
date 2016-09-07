import Java.util.ArrayList;

public class HeapPriorityQueue
{
	ArrayList<> heapArray = new ArrayList<>();
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
