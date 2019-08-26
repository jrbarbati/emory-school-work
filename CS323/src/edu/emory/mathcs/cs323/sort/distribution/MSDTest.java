package edu.emory.mathcs.cs323.sort.distribution;

public class MSDTest 
{
	public static void main(String[] args)
	{
		Integer[] arr = new Integer[6];
		
		System.out.print("Arr: ");
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = (Integer)((int)(Math.random() * 20) + 1);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		MSDRadixSort engine = new MSDRadixSort(2);
		
		engine.sort(arr, 0, arr.length);
		
		System.out.print("Arr: ");
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static int findMax(Integer[] array)
	{
		int max = array[0];
		for(int i = 1; i < array.length; i++)
		{
			if (max < array[i])
				max = array[i];
		}
		return max;
	}
}
