public class Bubble {

	private Bubble() { } 

	// Bubble sort
	public static <Key extends Comparable<Key>> void sort(Key[] a)
	{
		for (int i = a.length-1; i >= 0; i--)
		{
			for (int j = 0; j < i; j++)
			{
				if (less (a[j+1], a[j]))
					exch (a, j, j+1);
			}
		}
	}


	// is v < w?
	private static <Key extends Comparable<Key>> boolean less(Key v, Key w) 
	{
		return (v.compareTo (w) < 0);
	}

	// exchange a[i] and a[j]
	private static <Key extends Comparable<Key>> void exch(Key[] a, int i, int j)
	{
		Key tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args)
	{
		Bubble.sort (args);
		for (int i = 0; i < args.length; i++)
			System.out.println (args[i]);
	}
}
