package edu.emory.mathcs.cs323.sort.comparison;

import java.util.Collections;
import java.util.Comparator;

public class ShellSortPratt<T extends Comparable<T>> extends ShellSort<T> {

	public ShellSortPratt() {
		this(Comparator.naturalOrder());
	}
	
	public ShellSortPratt(Comparator<T> comparator) {
		this(comparator, 1000);
	}
	
	public ShellSortPratt(Comparator<T> comparator, int n) {
		super(comparator, n);
	}

	@Override
	protected void populateSequence(int n) {	
		n /= 2;
		// Populating sequence with Pratt sequence
		sequence.clear();
		sequence.add(1);
		
		int two = 0; // last index when it was multiplied by 2
		int three = 0; // last index when it was multiplied by 3
		
		// Adds numbers to pratt if it is in sequence until the last number is above n
		for(int i = 0; sequence.get(i) < n; i++) {
			if(sequence.get(two) * 2 < sequence.get(three) * 3) {
				sequence.add(sequence.get(two) * 2);
				two++;
			} else if (sequence.get(two)*2 > sequence.get(three)*3) { 
				sequence.add(sequence.get(three) * 3); 
				three++;
			} else { 
				sequence.add(sequence.get(two) * 2);
				two++; 
				three++; 
			} 
		}
		
		// Since last index in pratt is above n, remove it
		sequence.remove(sequence.get(sequence.size() - 1));

	}

	@Override
	protected int getSequenceStartIndex(int n) {
		int index = Collections.binarySearch(sequence, n / 2);
		if (index < 0) index = -(index+1);
		if (index == sequence.size()) index--;
		return index;
	}

	/** 
	 * Finds out if num is in the Pratt sequence
	 * @param num number to be checked
	 * @return true if in Pratt sequence, false otherwise
	 */
//	private boolean inPratt(int num) {
//		while(true) {
//			// divide by 3 as much as possible
//			if (num % 3 == 0) {
//				num /= 3;
//				continue;
//			// then divide by 2 as much as possible
//			} else if (num % 2 == 0)  {
//				num /= 2;
//				continue;
//			// If num == 1, then it's in the sequence, return true
//			// Will only become 1 if completely divisible by 2 and/or 3.
//			} else if (num == 1) {
//				return true;
//			// If num is greater than 3 and not divisible again by 2 or 3 evenly
//			// not in sequence, return false
//			} else if (num > 3 && num % 2 != 0 && num % 3 != 0)
//				return false;
//		}
//	}
}
