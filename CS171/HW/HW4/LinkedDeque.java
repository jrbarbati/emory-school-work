/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
A TUTOR OR CODE WRITTEN BY OTHER STUDENTS.  Joseph Barbati
*/

// Homework: revise this file, see TODO items below.

// This LinkedDeque class is a linked list, and a partial
// implementation of the java.util.Deque interface.  It is already
// sufficient for its use by PathFinder.  You should improve it, by
// fixing the TODO items.

// TODO: make this a doubly-linked list.  We already declared a
// "previous" link in the Node class, but you need to properly
// maintain those links.

// All methods here (except toString() and reverse()) should run in
// constant time.   Iterators do not need to be fail-fast.

// As given, this is nearly a copy of LinkedQueue.java from our
// textbook.  We added the second link in Node, We removed check() and
// main().  We removed the "private" declarations, to allow
// testing your code from external classes (like Test1.java,
// which should still be able to compile when you are done).

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeque<Item> implements Deque<Item> {
    // Not private, just to allow testing.
    public int N;         // number of elements on deque
    public Node first;    // beginning of deque
    public Node last;     // end of deque

    // Linked list node.
    public class Node {
        Item item;
        Node next;
        Node previous;          // new!
    }

    // Initialize empty deque
    public LinkedDeque() {
        first = null;
        last  = null;
        N = 0;
    }

    /**
     * Checks if LinkedDeque is empty
     * @return returns true if empty, false otherwise
     */
    public boolean isEmpty() { return first == null; }

    /**
     * adds the given Item to the end of the deque
     * @param item, Item to be added to deque
     */
    public void addLast(Item item) {
        // TODO: done
        Node temp = new Node();
        temp.item = item;
        if(isEmpty()) {
            last = temp;
            first = temp;
        } else {
            //updating next/previous links and last
            last.next = temp;
            temp.previous = last;
            last = temp;
        }
        //updating the size
        ++N;
    }
    
    /**
     * adds the given Item to the beginning of the deque
     * @param item, Item to be added to deque
     */
    public void addFirst(Item item) {
        // TODO: done
        Node temp = new Node();
        temp.item = item;
        if(isEmpty()) {
            first = temp;
            last = temp;
        } else {
            //updating next/previous links and first
            first.previous = temp;
            temp.next = first;
            first = temp;
        }
        //updating size
        ++N;
    }

    /**
     * removes and returns the first element in the deque
     * @return returns the first element in the deque
     */
    public Item removeFirst() {
        // TODO: done
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        if(N > 1)
            first.previous = null;
        else {
            //If list was size 1, makes an empty list
            last = null;
            first = null;
        }
        //updating size
        --N;
        return item;
    }

    /**
     * removes and returns the last element in the deque
     * @return returns the last element in the deque
     */
    public Item removeLast() {
        // TODO: done
        if(isEmpty()) throw new NoSuchElementException();
        Item item = last.item;
        last = last.previous;
        if(N > 1)
            last.next = null;
        else {
            last = null;
            first = null;
        }
        //updating size
        --N;
        return item;
    }

    /**
     * creates a string representation of the LinkedDeque
     * @return returns the string representation
     */
    public String toString() {
        // TODO: done
        StringBuilder build = new StringBuilder();
        for(Node current = first; current != null; current = current.next) {
            if(current == first)
                build.append(first.item);
            else
                //Avoids Fencepost Problem
                build.append(", " + current.item);
        }
        return "[" + build + "]";
    }

    // A standard iterator (visits items from first to last).
    public Iterator<Item> iterator() { return new Iter(); }

    private class Iter implements Iterator<Item> {
        protected Node current = first;
        protected Node lastcurrent = first;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            // TODO(EC): done
            
            /* Since this remove method removes the last item returned by next, 
             I treated it like a regular remove method.  Started by writing the
             code to remove from the middle then dealt with the cases if the 
             Node to be removed was the first or last node in the list.
             Before any of that I check if lastcurrent is equal to current to 
             make sure remove() isn't called without a next() inbetween (see
             comments for more of a description) */
            
            //If lastcurrent == current, then there were two remove() calls in
            //a row...throws the correct exception when this occurs
            if(lastcurrent == current) throw new IllegalStateException();
            if(lastcurrent == first) {
                first = first.next;
                if(N > 1)
                    first.previous = null;
            } else if(lastcurrent == last) {
                last = last.previous;
                last.next = null;
            } else {
                lastcurrent.previous.next = lastcurrent.next;
                lastcurrent.next.previous = lastcurrent.previous;
            }
            /* Sets lastcurrent to be current.  If next is called, then current 
             gets set to current.next so lastcurrent shouldn't equal current, so
             if it does, then two remove calls were made in a row and the 
             exception is thrown. */
            lastcurrent = current;
            //updating size...remove() removes from the actual list
            N--;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastcurrent = current;
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class RevIter extends Iter {
        public RevIter() { this.current = last; }
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastcurrent = current;
            Item item = current.item;
            current = current.previous;
            return item;
        }
          
    }

    // A reverse iterator (visits items from last to first).
    public Iterator<Item> descendingIterator() {
        // TODO: done
        return new RevIter();
    }

    /**
     * reverses the linked list
     * [A, B, C, D] --> [D, C, B, A]
     */
    public void reverse() {
        // TODO(EC): done
        
        /* In order to figure out how to do this, I simulated potential methods
         on pen and paper.  After much thought I realized I was doing things
         too complicated and decided to try a simple swap of the previous and
         next pointers.  After doing this I saw that if that was to work I would 
         also have to switch first and last to complete the reversal. After
         implementing the for loop and swapping first and last after, I saw a
         bug in the toString method, so I swapped first and last before the loop
         instead. */
        
        //Swap first and last
        Node temp = first;
        first = last;
        last = temp;
        
        //Swap next and prev links
        for(Node curr = first; curr != null; curr = curr.next) {
            temp = curr.next;
            curr.next = curr.previous;
            curr.previous = temp;
        }
    }
    
    /**
     * gets the size of the deque
     * @return returns the size
     */
    public int size() {
        return N;
    }
    
    public static void main(String[] args) {
//        LinkedDeque<Integer> test = new LinkedDeque<Integer>();
//        
//        System.out.println("List: " + test);
//        System.out.println("Size: " + test.size());
//        
//        for(int i = 0; i < args.length; i++) {
//            if(args[i].equals("first")) {
//                System.out.println(test.removeFirst());
//                System.out.println("List: " + test);
//                System.out.println("Size: " + test.size());
//            } else if (args[i].equals("last")) {
//                System.out.println(test.removeLast());
//                System.out.println("List: " + test);
//                System.out.println("Size: " + test.size());
//            } else if (args[i + 1].equals("begin")) {
//                test.addFirst(Integer.parseInt(args[i]));
//                System.out.println("List: " + test);
//                System.out.println("Size: " + test.size());
//                i++;
//            } else if (args[i + 1].equals("end")) {
//                test.addLast(Integer.parseInt(args[i]));
//                System.out.println("List: " + test);
//                System.out.println("Size: " + test.size());
//                i++;
//            } else {
//                System.out.println("Error.\nUsage: java LinkedDeque (Item)" +
//                                   "(To add: enter either 'begin'/'end') " +
//                                   "(To remove: enter either 'first'/'last')");
//            }
//        }
//        
//        test.reverse();
//        System.out.println("Reversed: " + test);
//        
//        test.reverse();
//        System.out.println("Reversed: " + test);
//
//        Iterator<Integer> testIter = test.iterator();
//        
//        for(Integer items : test) {
//            System.out.println("Still remains: " + items);
//            System.out.println("List: " + test);
//            System.out.println("Size: " + test.size());
//            testIter.next();
//            testIter.remove();
//        }
//
//        Iterator<Integer> testRevIter = test.descendingIterator();
//        
//        for(Integer items : test) {
//            System.out.println("Still remains: " + items);
//            System.out.println("List: " + test);
//            System.out.println("Size: " + test.size());
//            testRevIter.next();
//            testRevIter.remove();
//        }
    }
}
