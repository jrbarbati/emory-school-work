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
		
		n /= 10;
		// Populating sequence with Pratt sequence
		// Only add if size of sequence is less than 1
		// i.e. only during call to constructor
		if (sequence.size() < 1) {
			sequence.add(1);
		}
		
		int two = sequence.size() - 1; // last index when it was multiplied by 2
		int three = sequence.size() - 1; // last index when it was multiplied by 3
		
		// Adds numbers to pratt if it is in sequence until the last number is above n
		boolean didChange = false; // checks of sequence was changed.
		for(int i = sequence.size() - 1; ; i++) {
			// break if the last index is greater or equal to n
			if (sequence.get(i) >= n) break;
			
			if(sequence.get(two) * 2 < sequence.get(three) * 3) {
				sequence.add(sequence.get(two) * 2);
				two++;
			} else if (sequence.get(two) * 2 > sequence.get(three) * 3) { 
				sequence.add(sequence.get(three) * 3); 
				three++;
			} else { 
				sequence.add(sequence.get(two) * 2);
				two++; 
				three++; 
			} 
			didChange = true;
		}
		
		// Since last index in pratt is above n, remove it
		// but only if sequence was changed, keeps from removing
		// the last index every time method is called.
		if (didChange)
			sequence.remove(sequence.get(sequence.size() - 1));
	}

	@Override
	protected int getSequenceStartIndex(int n) {
		int index = Collections.binarySearch(sequence, n/10);
		if (index < 0) index = -(index+1);
		if (index == sequence.size()) index--;
		return index;
	}
}
