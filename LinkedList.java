public class LinkedList<E>
{
	public class Node<E>
	{
		private E element;
		private Node<E> next;

		public Node(E e, Node<E> n)
		{
			element = e;
			next = n;	
		}
		
		public E getElement()
		{
			return element;
		}

		public Node<E> getNext()
		{
			return next;
		}

		public void setNext(Node<E> n)
		{
			next = n;
		}
	}
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	public E first()
	{
		if(size != 0)
		{
			return null;
		}
	
		return head.getElement();
	
	}
		
	public E last()
	{
		if(size !=0)
		{
			return null;
		}
		
		return tail.getElement();
	}

	public void addFirst(E e)
	{
		Node<E> newest = new Node<E>(e,head);	
		head = newest;

		if(size == 0)
		{
			tail = head;
		}
		
		size++;
	}

	public void addLast(E e)
	{
		Node<E> newest = new Node<E>(e,null);
		
		if(size == 0)
		{
			head = newest;
		}
		else
		{
			tail.setNext(newest);
		}

		tail = newest;
		size++;

	}		

	public E removeFirst()
	{
		if(size == 0)
		{
			return null;
		}
		
		E removed=head.getElement();
		head=head.getNext();

		size--;
		if (size == 0)
		{
			tail = null;
		}
		
		return removed;
	}
}
			
