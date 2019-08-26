package edu.emory.mathcs.cs323.sort.distribution;

import java.util.Comparator;

public class MSDRadixSort extends BucketSort<Integer> {
	
	private final int MAX;
	private int div;


	public MSDRadixSort(int maxDigits) {
		this(maxDigits, Comparator.naturalOrder());
	}
	
	public MSDRadixSort(int maxDigits, Comparator<Integer> comparator) {
		super(10, true, comparator);
		MAX = maxDigits;
	}
	
	@Override
	public void sort(Integer[] array, int beginIndex, int endIndex) {
		
		div = (int)Math.pow(10, MAX - 1);
		super.sort(array, beginIndex, endIndex);
		
	}

	@Override
	protected int getBucketIndex(Integer key) {
		return (key / div) % 10;
	}
}