package edu.emory.mathcs.cs323.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Joseph Barbati
 *
 */
public class TernaryHeap<T extends Comparable<T>> extends AbstractPriorityQueue<T> {
	
	private List<T> keys;
	private int size;
	
	public TernaryHeap() {
		this(Comparator.naturalOrder());
	}
	
	public TernaryHeap(Comparator<T> comparator) {
		super(comparator);
		keys = new ArrayList<T>();
		keys.add(null);
		size = 0;
	}

	/**
	 * Adds to the priority queue
	 * @param key The key to be added
	 */
	@Override
	protected void add(T key) {
		keys.add(key);
		size++;
//		System.out.print("Before Swim:\t");
//		System.out.println(keys);
		swim(size);
//		System.out.print("After Swim:\t");
//		System.out.println(keys);
//		System.out.println();
	}
	
	/**
	 * Helps add() method, makes sure TernaryHeap remains a conventional heap
	 * after addition of new key.
	 * @param k The index of the newly added key
	 */
	private void swim(int k) {
		// (k+1)/3 is the parent index.
		
		// while the parent is smaller than the child, swap
		// k then becomes parent
		while(k > 1 && comparator.compare(keys.get((k+1)/3), keys.get(k)) < 0) {
			Collections.swap(keys, k, (k+1)/3);
			k = (k + 1) / 3;
		}
	}

	/**
	 * Removes the highest priority key from the priority queue
	 * @return Returns maximum key (i.e. highest priority key)
	 */
	@Override
	protected T removeAux() {
		// Swap first and last elements in ArrayList
//		System.out.print("Before Sink:\t");
//		System.out.println(keys);
//		System.out.println("Size: " + size);
		Collections.swap(keys, 1, size);
		T max = keys.remove(size--);
//		System.out.print("Before Sink:\t");
//		System.out.println(keys);
//		System.out.println("Size: " + size);
		sink(1);
//		System.out.print("After Sink:\t");
//		System.out.println(keys);
//		System.out.println(size);
//		System.out.println();
		return max;
	}
	
	/**
	 * Helps removeAux() method, makes sure TernaryHeap remains conventional heap
	 * after removal of key.
	 * @param k index of key that will sink.
	 */
	private void sink(int k) {
		for(int i = (3 * k) - 1; i <= size; k = i, i = (3 * k) - 1) {
			// If middle child is greater than left child, switch pointer
			if(i < size && comparator.compare(keys.get(i), keys.get(i + 1)) < 0) {
				i++;
				// Then check if right child is greater than middle child, if so
				// then switch pointer.
				if(i < size && comparator.compare(keys.get(i), keys.get(i + 1)) < 0) {
					i++;
				}
			// If middle child is NOT greater than left, 
			// then compare left and right children,
			// if right is greater, switch pointer
			} else if(i + 1 < size && comparator.compare(keys.get(i), keys.get(i + 2)) < 0) {
				i += 2;
			}
			
			// If k (parent) is greater than i (child), break;
			if(comparator.compare(keys.get(k), keys.get(i)) >= 0) break;
			// Otherwise swap
			Collections.swap(keys, k, i);
		}
	}

	/**
	 * Gets the size of the queue
	 * @return Returns the size of the queue
	 */
	@Override
	protected int size() {
		return size;
	}
}
