import java.util.Arrays;


public class BinarySearch {

	public static int bsearch(int key, int[] a)
	{
		/* ??? */

		int hi = a.length-1;
		int lo = 0;
		int mid = 0;

		while (lo <= hi) // key in [lo,hi]
		{
			mid = lo + (hi-lo)/2;
			if (a[mid] > key)
				hi = mid-1;
			else if (a[mid] < key)
				lo = mid+1;
			else
				return mid;
		}
	
		return -1;	
	}

	public static void main(String[] args)
	{
		int[] whitelist = new In(args[0]).readAllInts();

		Arrays.sort (whitelist);

		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			int loc = bsearch (key, whitelist);
			if (loc == -1)
				StdOut.println ("Could not find " + key);
			else
				StdOut.println ("Key " + key + " at location " + loc);
		}
	}

};
