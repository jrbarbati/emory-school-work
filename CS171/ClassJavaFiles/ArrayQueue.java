@SuppressWarnings("unchecked")
public class ArrayQueue<Item>
{
	// items is a queue that grows with increasing memory addresses
	private Item[] items;
	// N is the number of items on the queue
	private int N = 0;
	// first is the index of the first available item on the queue
	private int first = 0;
	// last is the index of the first available empty spot at the back of the queue
	private int last = 0;

	public ArrayQueue(int len)
	{
		items = (Item[]) new Object[len];
	}

	public void enqueue(Item it)
	{
		if (N >= items.length)
			throw new ArrayIndexOutOfBoundsException("enqueue to a full array");
		items[last] = it;
		last = (last + 1) % items.length;
		N++;
	}

	public Item dequeue()
	{
		if (N <= 0)
			throw new ArrayIndexOutOfBoundsException("dequeue of an empty array");
		Item it = items[first];
		// make sure we don't leave old items behind to facilitate garbage collection
		items[first] = null;
		first = (first + 1) % items.length;
		N--;
		return it;
	}


	public int size() {
		return N;
	}

	public static void main(String[] args)
	{
		ArrayQueue<String> arr = new ArrayQueue<String>(20);

		for (int i = 0; i < args.length; i++)
		{
			if (args[i].equals ("D"))
				System.out.println (arr.dequeue());
			else
				arr.enqueue(args[i]);
		}
	}
}
