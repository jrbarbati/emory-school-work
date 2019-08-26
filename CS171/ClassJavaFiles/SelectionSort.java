public class SelectionSort {

	private SelectionSort() { } 

	// SelectionSort sort
	public static <Key extends Comparable<Key>> void sort(Key[] a)
	{
		int minIndex = 0;
		for (int i = 0; i < a.length; i++)
		{
			minIndex = i;
			for (int j = i+1; j < a.length; j++)
			{
				if (less (a[j], a[minIndex]))
				{
					minIndex = j;
				}
			}
			exch (a, minIndex, i);
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
		SelectionSort.sort (args);
		for (int i = 0; i < args.length; i++)
			System.out.println (args[i]);
	}
}
