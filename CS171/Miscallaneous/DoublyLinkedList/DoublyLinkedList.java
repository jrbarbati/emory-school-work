import java.util.Iterator;
import java.util.Scanner;
public class DoublyLinkedList<Item> implements Iterable<Item> {
    
    public static Scanner input = new Scanner(System.in);
    
    private class Node {
        Item item;
        Node next;
        Node prev;
    }
    
    private Node first, last;
    private int N;
    
    public DoublyLinkedList() {
        first = null;
        last = null;
        N = 0;
    }
    
    //Adds item as the next thing in the linked list
    public void add(Item addThis) {
        Node temp = new Node();
        temp.item = addThis;
        if(first == null) {
            first = temp;
            last = temp;
        } else {
            last.next = temp;
            temp.prev = last;
            last = temp;
        }
    }
    
    //Removes and returns first instance of specified Item
    //returns null if item was not found
    public Item remove(Item removeThis) {
        if(first == null) {
            throw new IndexOutOfBoundsException("Tried to remove from an " +
                                                 "empty LinkedList.");
        }
        Node previous = new Node();
        previous = first;
        Item returnThis = null;
        for(Node current = first; current != null; current = current.next)
        {
            if(current.item.equals(removeThis)) {
                if(current == first) {
                    returnThis = current.item;
                    first = first.next;
                    first.prev = null;
                    break;
                }
                if(current == last) {
                    returnThis = current.item;
                    last = last.prev;
                    last.next = null;
                    break;
                }
                //Updates the prev and next so it skips over the removed item
                returnThis = current.item;
                current.prev.next = current.next;
                current.next.prev = current.prev;
                break;
            }
            previous = current;
        }
        return returnThis;
    }
    /* ALLOWS USE OF FOREACH LOOP */
    
    public Iterator<Item> iterator() {
        return new DoublyLinkedListIterator();
    }
    
    private class DoublyLinkedListIterator implements Iterator<Item> {
        private Node current = first;
        
        public boolean hasNext() {
            return current != null;
        }
        
        public Item next() {
            Item it = current.item;
            current = current.next;
            return it;
        }
        
        public void remove() {
            
        }
    }
    
    public static void main(String[] args) {
        
        DoublyLinkedList<String> test = new DoublyLinkedList<String>();
        
        for(int i = 0; i < args.length; i++) {
            if(args[i].equals("R")) {
                System.out.print("What would you like to remove? ");
                String removeString = input.next();
                System.out.println(test.remove(removeString));
            } else {
                test.add(args[i]);
            }
        }
        
        for(String thing : test) {
            System.out.println("Still Remains: " + thing);
        }
    }
}