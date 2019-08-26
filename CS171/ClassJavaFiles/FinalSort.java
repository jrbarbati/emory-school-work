public class FinalSort {

	private FinalSort() { } 

	// Bubble sort
	public static <Key extends Comparable<Key>> void bubbleSort(Key[] a)
	{
		return;
	}

	// Selection sort
	public static <Key extends Comparable<Key>> void selectionSort(Key[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			/* Elements 0, 1, ..., i-1 are sorted */
			int minIndex = i;
			for (int j = i; j < a.length; j++)
			{
				if (less (a[j], a[minIndex]))
					minIndex = j;
			}
			exch (a, i, minIndex);
		}
	}

	// Selection sort
	public static <Key extends Comparable<Key>> void insertionSort(Key[] a)
	{
		for (int i = 1; i < a.length; i++)
		{
			int j = i;
			while (j > 0 && less (a[j], a[j-1]))
			{
				exch (a, j, j-1);
				j--;
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
		FinalSort.insertionSort (args);
		for (int i = 0; i < args.length; i++)
			System.out.println (args[i]);
	}
}
