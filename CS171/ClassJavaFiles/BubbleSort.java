public class BubbleSort {

	private BubbleSort() { } 

	// BubbleSort sort
	public static <Key extends Comparable<Key>> void sort(Key[] a)
	{
		// array [0, ..., i] is unsorted, [i,...N-1] is sorted
		// furthermore, [i,...,N-1] has the biggest elements
		for (int i = a.length-1; i >= 0; i--)
		{
			for (int j = 1; j <= i; j++)
			{
				if (less (a[j], a[j-1]))
					exch (a, j, j-1);
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
		BubbleSort.sort (args);
		for (int i = 0; i < args.length; i++)
			System.out.println (args[i]);
	}
}
