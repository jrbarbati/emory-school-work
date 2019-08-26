import java.util.Iterator;

public class LinkedQueue<Item> implements Iterable<Item>{

	private class Node {
		Item it;
		Node next;
	}
	private Node first = null, last = null;
	private int N = 0;


	public LinkedQueue()
	{
	}
	
	public void enqueue(Item it)
	{	
		Node tmp = new Node();
		tmp.it = it;
		tmp.next = null;
		if (last != null) {
			last.next = tmp;
		} else {
			first = tmp;
			last = tmp;
		}
		last = tmp;
		N++;

	}

	public Iterator<Item> iterator()
	{
		return new LinkedQueueIterator();
	}


	private class LinkedQueueIterator implements Iterator<Item>
	{
		private Node current = first;


		public boolean hasNext()
		{
			return current != null;	
		}

		public Item next() 
		{
			Item it = current.it;
			current = current.next;
			return it;
		}
		public void remove() {
		}
	}

	
	// returns null if no element on list, otherwise returns elements
	public Item dequeue()
	{
		if (first == null)
			throw new IndexOutOfBoundsException ("Dequeue from an empty queue. Idiot");
		Item ontheriver = first.it;
		first = first.next;
		if (first == null)
		    last = null;
		N--;
		return ontheriver;
	}


	public int size()
	{
		return N;	
	}

	public static void main(String[] args)
	{
		LinkedQueue<String> arr = new LinkedQueue<String>();

		for (int i = 0; i < args.length; i++)
		{
			if (args[i].equals ("D"))
				System.out.println (arr.dequeue());
			else
				arr.enqueue(args[i]);
		}

		for (String s : arr)
			System.out.println ("Still remains: " + s)
		
	}
}

