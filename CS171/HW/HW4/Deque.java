// Do not edit this file for homework.

// This Deque interface is mostly a subset of java.util.Deque.
// A Deque is a "double-ended queue": a list of items, where we can
// add or remove items at either end (first or last).  It also
// provides two iterator methods, and a reverse method.

// When a deque is empty, some of these methods need to signal an
// runtime exception.  They should do the following:
//
//   throw new NoSuchElementException(); // message string optional
//
// When that happens, they should leave the deque in a consistent
// empty state (for example, size() should still return 0).

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface Deque<Item> extends Iterable<Item>
    {
        // return the number of items
        public int size();
        
        // true if empty, false otherwise
        public boolean isEmpty();
        
        // add Item x to start of this list
        public void addFirst(Item x);
        
        // add Item x to end of this list
        public void addLast(Item p);
        
        // return item removed from start
        public Item removeFirst() throws NoSuchElementException;
        
        // return item removed from end
        public Item removeLast() throws NoSuchElementException;
        
        // Return Iterator as required by Iterable (from front to last).
        public Iterator<Item> iterator();
        
        // Return a reverse-order Iterator (from last to front).
        public Iterator<Item> descendingIterator();
        
        // Reverse the order of the items in this deque.
        public void reverse();
    }