package edu.emory.mathcs.cs323.queue;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LazyPriorityQueue<T extends Comparable<T>> 
						extends AbstractPriorityQueue<T> {
	private List<T> keys;
	
	public LazyPriorityQueue() {
		// Calling constructor of this class
		this(Comparator.naturalOrder());
		// naturalOrder() --> default comparator (max is highest number)
	}
	
	public LazyPriorityQueue(Comparator<T> comparator) {
		super(comparator);
		keys = new ArrayList<>();
	}

	@Override // Annotation --> indicates you are overriding method from super class
	protected void add(T key) {
		keys.add(key);
	}

	@Override
	protected T removeAux() {
		T max = Collections.max(keys, comparator);
		keys.remove(max);
		return max;
	}

	@Override
	protected int size() {
		return keys.size();
	}
}
