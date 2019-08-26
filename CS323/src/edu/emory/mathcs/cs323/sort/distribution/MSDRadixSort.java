package edu.emory.mathcs.cs323.sort.distribution;

import java.util.Comparator;
import java.util.List;

public class MSDRadixSort extends BucketSort<Integer> {
	
	private List<List<Integer>> buckets; 


	public MSDRadixSort(int maxDigits) {
		this(maxDigits, Comparator.naturalOrder());
	}
	
	public MSDRadixSort(int maxDigits, Comparator<Integer> comparator) {
		super(10, false, comparator);
	}
	
	public void sort(Integer[] array, int beginIndex, int endIndex)
	{
		int maxBit = getMaxBit(array, beginIndex, endIndex);
		sort(array, beginIndex, endIndex, maxBit - 1);
	}
	
	private void sort(Integer[] array, int beginIndex, int endIndex, int bit) {
		if (bit < 0) return;
		int div = (int)Math.pow(10, bit);
		int[] start = getBucketSizes();
		
		for(int i = 0; i < array.length; i++)
			buckets.get((array[i] / div) % 10).add(array[i]);
		
		int ei = beginIndex, bi = beginIndex, idx;
		for(int i = 0; i < 10; i++)
		{
			List<Integer> bucket = buckets.get(i);
			idx = ei = ei + bucket.size() + start[i];
			while(bucket.size() > start[i]) array[--idx] = bucket.remove(bucket.size() - 1);
			sort(array, bi, ei, bit - 1);
			bi = ei;
		}
	}

	private int[] getBucketSizes() {
		int[] temp = new int[10];
		
		for(int i = 0; i < buckets.size(); i++) {
			temp[i] = buckets.get(i).size();
		}
		
		return temp;
	}

	@Override
	protected int getBucketIndex(Integer key) {
		return 0;
	}

	protected int getMaxBit(Integer[] array, int beginIndex, int endIndex) {                                   
		int max = array[beginIndex];

		for (int i=endIndex-1; i>beginIndex; i--)
			max = Math.max(max, array[i]);
		
		return Integer.toString(max).length();
	}
}