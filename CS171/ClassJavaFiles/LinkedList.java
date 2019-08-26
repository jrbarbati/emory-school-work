public class LinkedList<Item> 
{
	private class Node {
		Item item;
		Node next;
	}

	Node first;

	public LinkedList<Item>()
	{
		first = null;			
	}

	public void insertFirst(Item it)
	{
		Node node = new Node();
		node.item = it;
		node.next = first;
		first = node;
	}

	public Item removeFirst()
	{
		Item it = first.item;
		first = first.next;
		return it;
	}

	public 


	public static void main(String[] args)
	{
		// tests
	}
}
