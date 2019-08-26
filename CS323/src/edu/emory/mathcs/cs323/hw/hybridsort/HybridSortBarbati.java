package edu.emory.mathcs.cs323.hw.hybridsort;

import edu.emory.mathcs.cs323.sort.AbstractSort;
import edu.emory.mathcs.cs323.sort.comparison.ShellSortKnuth;
import edu.emory.mathcs.cs323.sort.divide_conquer.QuickSort;

public class HybridSortBarbati<T extends Comparable<T>> implements HybridSort<T> {
	
	private AbstractSort<T> engine;
	private AbstractSort<T> engineAlt;

	public HybridSortBarbati() {
		engineAlt = new ShellSortKnuth<>();
		engine = new QuickSort<>();
	}
	
	// FIND A WAY TO MERGE THE SORTED ARRAYS
	
	@Override
	public T[] sort(T[][] input)
	{
		// Sort each array the best away
		for(int i = 0; i < input.length; i++) {
			int method = findBestSort(input[i]);

			if (method == 0) {
				engineAlt.sort(input[i]);
			} else {
				engine.sort(input[i]);
			}	
		}
		
		T[] output = merge(input, 0, input.length - 1);
		
		return output;
	}

	/**
	 * Takes the first, middle, and last elements in array and compares them
	 * if they seem random, array is probably random, so use QuickSort,
	 * else array is probably not random, so use ShellSort.
	 * @param array Array to be sorted
	 * @return returns 0 if ShellSortKnuth is best, returns 1 if QuickSort is best
	 */
	private int findBestSort(T[] array) {
		T first = array[getRandomIndex(array, 1)];
		T second = array[getRandomIndex(array, 2)];
		T third = array[getRandomIndex(array, 3)];
		
		if ((first.compareTo(second) <= 0 && second.compareTo(third) >= 0)
			|| (first.compareTo(second) >= 0 && second.compareTo(third) <= 0)) {
			return 1; // Probably random, so QuickSort is best
		} else {
			return 0; // Probably not Random, so ShellSort is best
		}
	}
	
	/**
	 * Gets a random index from an array in the part.
	 * @param part Part of array to get index from.  Either 1, 2 or 3.
	 * Corresponds to the first, second or third part of array, respectively.
	 * @return returns the randomly generated index.
	 */
	private int getRandomIndex(T[] array, int part) {
		int endingPoint;
		// Check Part, should be 1 - 3, if not just return a random index.
		if (part == 1) 		endingPoint = array.length / part;
		else if (part == 2)	endingPoint = array.length - (array.length / part);
		else				endingPoint = array.length - 1;
		
		int rand = (int)(Math.random() * endingPoint);
		
		return rand;
	}
	
	/**
	 * Recursively merges a 2D array of sorted 1D arrays into a sorted 1D array
	 * @param array 2D array of sorted 1D arrays
	 * @param beginIndex 1D array to merge with array[endIndex]
	 * @param endIndex 1D array to merge with array[beginIndex]
	 * @return returns sorted and merged array.
	 */
	@SuppressWarnings("unchecked")
	private T[] merge(T[][] array, int beginIndex, int endIndex)
	{	
		int midIndex = ((endIndex - beginIndex) / 2) + beginIndex;
		
		T[] a;
		T[] b;
		
		// If merge is looking at more than 2 arrays, divide again
		if 		(endIndex - beginIndex > 1)
		{
			a = merge(array, beginIndex, midIndex);
			b = merge(array, midIndex + 1, endIndex);
		}
		// If merge is looking at exactly 2 arrays, merge the arrays
		else if (endIndex - beginIndex == 1) 
		{
			a = array[beginIndex];
			b = array[endIndex];
		} 
		// If merge is looking at exactly 1 array, return that array
		// it is already sorted.
		else //if (endIndex - beginIndex == 0)
		{
			return array[beginIndex];
		}
		
		int i = 0, j = 0, k;
		
		T[] tempo = (T[])(new Integer[a.length + b.length]);
		
		for(k = 0; k < tempo.length; k++)
		{
			// Already added all numbers from a
			if		(i >= a.length)		tempo[k] = b[j++];
			
			// Already added all numbers from b
			else if (j >= b.length) 	tempo[k] = a[i++];
					
			// Still have numbers in both arrays, must compare
			else
			{
				if (a[i].compareTo(b[j]) <= 0) tempo[k] = a[i++];
				else 						   tempo[k] = b[j++];
			}
		}
		
		return tempo;
	}
}
