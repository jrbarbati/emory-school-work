public class StackOfStrings {

	private String[] arr; 
	private int N = 0;

	public StackOfStrings() {
		arr = new String[10];
	}

	private void resize(int newSize)
	{
		String[] newArr = new String[newSize];
		for (int i= 0; i < N; i++)
			newArr[i] = arr[i];
		arr = newArr;
	}

	/* Insert a new item onto the stack */
	public void push(String s) {
		if (N == arr.length)
			resize (arr.length*2);	
		arr[N++] = s;
	}

	/* Remove and return the item most recently added */
	public String pop() {
		if (N < arr.length/4)
			resize (arr.length/2);
		String s = arr[--N];
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
		StackOfStrings stack = new StackOfStrings(100);
		
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals ("-")) /* Pop off the stack */
				System.out.println (stack.pop());
			else
				stack.push (item);
		}
	}
	

};
