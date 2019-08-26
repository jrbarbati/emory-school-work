public class LinkedListQueue<Item>
{
	private class Node {
		Item item;
		Node next;
	}
	private int N = 0;
	private Node first;

	public LinkedListQueue()
	{
		first = null;
	}

	public void enqueue(Item it)
	{
		Node node = new Node();
		node.item = it;
		node.next = first;
		first = node;
	}

	public Item dequeue()
	{
		if (N == 0)
			throw new ArrayOutOfBoundsException("dequeue on empty queue");

		for (Node x = first; x.next != null; x = x.next)
			 ;
			
			Item it = last.item;
		}
	}


	public int size() {
		return N;
	}

	public static void main(String[] args)
	{
		LinkedListQueue<String> arr = new LinkedListQueue<String>(20);

		for (int i = 0; i < args.length; i++)
		{
			if (args[i].equals ("D"))
				System.out.println (arr.dequeue());
			else
				arr.enqueue(args[i]);
		}
	}
}
