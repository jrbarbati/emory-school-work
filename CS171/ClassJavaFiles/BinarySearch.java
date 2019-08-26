import java.util.Arrays;


public class BinarySearch {

	/* precondition: `bsearch takes in a sorted list a */
	/* output: -1 if the key 'key' is not in the list a, otherwise the location
	 * of key in the list */

	public static int bsearch(int key, int[] a)
	{
		int lo = 0;
		int hi = a.length-1;
		int mid;
		/* the key could be in [lo,hi] */
		while (lo <= hi) {
			mid = lo + (hi-lo)/2;
			if (a[mid] == key)
				return mid;
			else if (a[mid] < key)
				lo = mid;
			else 
				hi = mid;	
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
