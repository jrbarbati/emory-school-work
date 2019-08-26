import java.util.Iterator;
public class LinkedQueue<Item> implements Iterable<Item>{
    
    private class Node {
        Item it;
        Node next;
    }
    
    private Node first, last;
    private int N;
    
    public LinkedQueue() {
        first = null;
        last = null;
        N = 0;
    }
    
    public void enqueue(Item it) {
        Node temp = new Node();
        temp.it = it;
        temp.next = null;
        if (last != null) {
            //If last exists, it sets the next element to be temp
            last.next = temp;
        } else {
            //if last is null, then first is null as well so we have to update
            //both
            first = temp;
            last = temp;
        }
        //finally, we set last = temp so we keep accurate track of the last
        //thing in the linked list
        last = temp;
        N++;
    }
    
    public Iterator<Item> iterator() {
        return new LinkedQueueIterator();
    }
    
    private class LinkedQueueIterator implements Iterator<Item> {
        
        private Node current = first;
        
        public boolean hasNext() {
            return current != null;
        }
        
        public Item next() {
            Item it = current.it;
            current = current.next;
            return it;
        }
        
        public void remove() {
            
        }
        
    }
    //Returns and removes element at end of the queue, throws an exception if no element
    public Item dequeue() {
        if (first == null) {
            throw new IndexOutOfBoundsException("Dequeue from an empty queue.  Idiot.");
        }
        //Set an Item equal to the first Item, then update first
        Item ontheriver = first.it;
        first = first.next;
        //If list is empty, update last to be null as well
        if(first == null)
            last = null;
        N--;
        return ontheriver;
    }
    
    public int size() {
        return N;
    }
    public static void main(String[] args) {
        LinkedQueue<String> arr = new LinkedQueue<String>();
        
        for(int i = 0; i < args.length; i++) {
            if(args[i].equals("D")) {
                System.out.println(arr.dequeue());
            } else {
                arr.enqueue(args[i]);
            }
        }
        for(String s : arr) {
            System.out.println("Still Remains: " + s);
        }
    }
}