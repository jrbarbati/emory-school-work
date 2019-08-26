@SuppressWarnings("unchecked")

public class Stack<Item> {

	private Item[] arr; 
	private int N = 0;

	public Stack() {
		arr = (Item[]) new Object[10];
	}

	private void resize(int newSize)
	{
		Item[] newArr = (Item[]) new Object[newSize];
		for (int i= 0; i < N; i++)
			newArr[i] = arr[i];
		arr = newArr;
	}

	/* Insert a new item onto the stack */
	public void push(Item s) {
		if (N == arr.length)
			resize (arr.length*2);	
		arr[N++] = s;
	}

	/* Remove and return the item most recently added */
	public Item pop() {
		if (N < arr.length/4)
			resize (arr.length/2);
		Item s = arr[--N];
		arr[N] = null;
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
		Stack<Integer> stack = new Stack<Integer>();
		
		while (!StdIn.isEmpty()) {
			Integer item = StdIn.readInt();
			if (item.equals (0)) /* Pop off the stack */
				System.out.println (stack.pop());
			else
				stack.push (item);
		}
	}
	

};
