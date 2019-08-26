package edu.emory.mathcs.cs323.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>> extends AbstractPriorityQueue<T> {
	
	private List<T> keys;
	private int size;
	
	public BinaryHeap() {
		this(Comparator.naturalOrder());
	}
	
	public BinaryHeap(Comparator<T> comparator) {
		super(comparator);
		keys = new ArrayList<T>();
		keys.add(null);
		size = 0;
	}

	@Override
	protected void add(T key) {
		keys.add(key);
		swim(++size);
	}
	
	private void swim(int k) {
		// If parent is smaller can current node, swap, then go to parent and check again
		while (k > 1 && comparator.compare(keys.get(k/2), keys.get(k)) < 0) {
			Collections.swap(keys, k/2, k);
			k /= 2;
		}
	}

	@Override
	protected T removeAux() {
		Collections.swap(keys, 1, size);
		T max = keys.remove(size--);
		sink(1);
		return max;
	}

	private void sink(int k) {
		for(int i =  k * 2; i <= size; k=i, i *= 2) {
			// i is currently left child, compare to right child
			// If right child is bigger, switch pointer to right
			if (i < size && comparator.compare(keys.get(i), keys.get(i + 1)) < 0) i++;
			// Now compare parent (k) to i (biggest child)
			// If its bigger or equal, break (it's a heap)
			if (comparator.compare(keys.get(k), keys.get(i)) >= 0) break;
			// Otherwise, swap parent and child and check again.
			Collections.swap(keys, k, i);
			// i becomes the child, k becomes new parent.
		}
	}
	
	@Override
	protected int size() {
		return size;
	}
}
