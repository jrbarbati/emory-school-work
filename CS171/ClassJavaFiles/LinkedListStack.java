public class LinkedListStack<Item> {

	private static class Node<Item> {
		public Item it;
		public Node<Item> prev;
		public Node<Item> next;
	}
	private int N = 0;
	private Node<Item> head, tail;

	public LinkedListStack() {
		head = null;
		tail = null;
	}

	/* Insert a new item onto the stack */
	public void push(Item s) {
		Node<Item> x = new Node<Item>();
		x.it = s;
		x.next = null;
		x.prev = tail;

		if (tail != null)
			tail.next = x;
		tail = x;
		N++;
		if (head == null)
			head = tail;	
	}

	/* Remove and return the item most recently added */
	public Item pop() {
		Item s = tail.it;
		if (head == tail)
			head = null;
		if (tail.prev != null)
			tail.prev.next = null;
		tail = tail.prev;
		N--;
		return s;
	}

	/* Returns true if the stack is empty, false otherwise */
	public boolean isEmpty() {
		return (N == 0);	
	}

	/* Numer of items on the stack (optional) */
	public int size() {
		return N;
	}


	
	/* Reverse strings */
	public static void main(String[] args)
	{
		LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
		
		while (!StdIn.isEmpty()) {
			Integer item = StdIn.readInt();
			if (item.equals (0)) /* Pop off the stack */
				System.out.println (stack.pop());
			else
				stack.push (item);
		}
	}
	

};
