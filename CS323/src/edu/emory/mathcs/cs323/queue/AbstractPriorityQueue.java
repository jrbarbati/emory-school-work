package edu.emory.mathcs.cs323.queue;

import java.util.Comparator;
import java.util.NoSuchElementException;

// In Java, at least one file must have a public class
// Abstract Class
//		Can have abstract method, but may not.
//		Cannot do a 'new AbstractClass()' in another program.
//		Can't have multiple inheritance
// Interface
//		Not allowed to have defined methods
//		Can have multiple inheritance
// Generic
//		Define a type for class yourself, arbitrary type
// Protected
//		Only visible to class and any subclasses
// This
//		refers to the instance of the class itself.
public abstract class AbstractPriorityQueue<T extends Comparable<T>> {
	protected Comparator<T> comparator;
	
	public AbstractPriorityQueue(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	// No bodies, just declaring the function
	// Will be implemented in subclass
	abstract protected void add(T key);
	abstract protected T removeAux();
	abstract protected int size();
	
	public boolean isEmpty() {
		// Using abstract class before it's defined
		// This works because before a call to isEmpty(),
		// 		size() should have already been defined in the subclass
		return size() == 0;
	}
	
	public T remove() {
		if (isEmpty()) throw new NoSuchElementException("No key exists");
		return removeAux();
	}
	
	
}