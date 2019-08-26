public class ListOfStrings
{
	private static class Node {
		String item;
		Node next;
	}
	private Node head;

	public void insertBeginning(String s)
	{
		Node tmp = new Node();
		tmp.next = head;
		tmp.item = s;

		head = tmp;
	}

	public void insertEnd(String s)
	{
		Node last = null; 
		for (Node x = head; x != null; x = x.next)
		{
			last = x;	
		}
		Node tmp = new Node();
		tmp.next = null;
		tmp.item = s;

		if (last == null)
			head = tmp;
		else {
			last.next = tmp;
		}


	}

	public String toString()
	{
		String s = "";
		for (Node x = head; x != null; x = x.next)
			s = s + " " + x.item;
		return s;
	}

	public static void main(String[] args)
	{
		ListOfStrings list = new ListOfStrings();

		list.insertEnd ("Hello");
		list.insertEnd ("there");
		list.insertEnd ("flugeldufel");

		System.out.println (list);
		
		
		

	}
}
