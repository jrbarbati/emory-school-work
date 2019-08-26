public class Array {
	public static int[] basicArray()
	{
		int[] nums = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
		return nums;
		//new int[10];
	}

	/* Q: Can we change the length of an array? */


	public static int findMax(int[] arr)
	{
		int max = arr[0];

		for (int i = 1; i < arr.length; i++)
			if (arr[i] > max)
				max = arr[i];		

		return max;
	}


	public int[] copyArray(int[] arr)
	{
		int[] newArray = new int[arr.length];

		for (int i = 0; i < arr.length; i++)
			newArray[i] = arr[i];		

		return newArray;
	}	


	public static int puzzle(int[] arr)
	{
		/* Find the number of elements that are smaller than the one preceding it */
		int count = 0;

	
		for (int i = 0; i < arr.length; i++)
		/* I: Count reflects the number of increasing pairs between arr[0] and arr[i] */
			if (arr[i] < arr[i+1])
				count++;

		return count;
	}

	public static void main(String[] args)
	{
		int[] arr;

		arr = basicArray();		
		//int[] ahoy = arr; /* What does this do ? */ 

		/* Print entire array? */

		int[] t1 = { 5, 16777216, 1, -1000000, 5, 16777215 };

		System.out.println ("Maximum is: " + findMax(arr));
		System.out.println ("Maximum is: " + findMax(arr));
		
		System.out.println ("Test 1: " + findMax(t1));
		
		System.out.println ("Puzzle: " + puzzle(arr));
		System.out.println ("Puzzle: " + puzzle(t1));

	}
}
