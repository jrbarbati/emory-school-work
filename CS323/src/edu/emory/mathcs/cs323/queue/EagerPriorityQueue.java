package edu.emory.mathcs.cs323.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EagerPriorityQueue<T extends Comparable<T>>
							extends AbstractPriorityQueue<T> {

	private List<T> keys;
	
	public EagerPriorityQueue() {
		// Calling constructor of this class
		this(Comparator.naturalOrder());
		// naturalOrder() --> default comparator (max is highest number)
	}
	
	public EagerPriorityQueue(Comparator<T> comparator) {
		super(comparator);
		keys = new ArrayList<>();
	}

	@Override
	protected void add(T key) {
		// If key DNE, binarySearch() returns the negative-index where the key should go -1.
		int index = Collections.binarySearch(keys, key, comparator);
		if (index < 0) index = -(index + 1);
		keys.add(index, key);
	}

	@Override
	protected T removeAux() {
		return keys.remove(keys.size() - 1);
	}

	@Override
	protected int size() {
		return keys.size();
	}
	
}
