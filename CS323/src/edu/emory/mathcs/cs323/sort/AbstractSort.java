package edu.emory.mathcs.cs323.sort;

import java.util.Comparator;

public abstract class AbstractSort<T extends Comparable<T>> {
	protected Comparator<T> comparator;
	protected long n_comparisons; // for benchmarking
	protected long n_assignments; // for benchmarking
	
	public AbstractSort(Comparator<T> comparator)
	{
		setComparator(comparator);
		resetCounts();
	}
	
	public Comparator<T> getComparator() {
		return comparator;
	}
	
	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	/**
	 * Sorts the array[beginIndex:endIndex] in ascending order.
	 * @param array an array of comparable keys.
	 * @param beginIndex the index of the first key to be sorted (inclusive).
	 * @param endIndex the index of the last key to be sorted (exclusive).
	 */
	abstract public void sort(T[] array, int beginIndex, int endIndex);
	
	/**
	 * Sorts the array in ascending order.
	 * @param array an array of comparable keys.
	 */
	public void sort(T[] array)
	{
		sort(array, 0, array.length);
	}
	
	public void resetCounts()
	{
		n_comparisons = 0;
		n_assignments = 0;
	}
	
	/** @return the total number of comparisons performed by this sort. */
	public long getComparisonCount()
	{
		return n_comparisons;
	}
	
	/** @return the total number of assignments performed by this sort. */
	public long getAssignmentCount()
	{
		return n_assignments;
	}
	
	/**
	 * @param array an array of comparable keys.
	 * @param i the index of the first key.
	 * @param j the index of the second key.
	 * @return {@code array[i].compareTo(array[j])}
	 */
	protected int compareTo(T[] array, int i, int j)
	{
		n_comparisons++;
		return comparator.compare(array[i], array[j]);
	}
	
	/**
	 * {@code array[index] = value}
	 * @param array an array of comparable keys.
	 * @param index the index of the array to assign.
	 * @param value the value to be assigned.
	 */
	protected void assign(T[] array, int index, T value)
	{
		n_assignments++;
		array[index] = value;
	}
	
	/**
	 * Swaps {@code array[i]} and {@code array[j]}. 
	 * @param array an array of comparable keys.
	 * @param i the index of the first key.
	 * @param j the index of the second key.
	 */
	protected void swap(T[] array, int i, int j)
	{
		T t = array[i];
		assign(array, i, array[j]);
		assign(array, j, t);
	}
}
