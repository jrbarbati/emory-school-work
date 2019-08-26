import java.util.Iterator;
public class LinkedDeque<Item> implements Iterable<Item> {
    
    private class Node {
        Node next;
        Node prev;
        Item item;
    }
    
    private Node first, last;
    private int sizeOfQueue;
    
    public LinkedDeque() {
        first = null;
        last = null;
        sizeOfQueue = 0;
    }
    
    /**
     adds the given Item to the beginning of the deque
     @param addThis, Item to be added to deque
     */
    private void addBeginning(Item addThis) {
        Node temp = new Node();
        temp.item = addThis;
        if(first == null) {
            first = temp;
            last = temp;
        } else {
            first.prev = temp;
            temp.next = first;
            first = temp;
        }
        sizeOfQueue++;
    }
    
    /**
     adds the given Item to the end of the deque
     @param addThis, Item to be added to deque
     */
    private void addEnd(Item addThis) {
        Node temp = new Node();
        temp.item = addThis;
        if(last == null) {
            last = temp;
            first = temp;
        } else {
            last.next = temp;
            temp.prev = last;
            last = temp;
        }
        sizeOfQueue++;
    }
    
    /**
     removes and returns the first element in the deque
     @return returns the first element in the deque
    */
    private Item removeFirst() {
        if(first == null)
            return (Item)("Tried to remove from empty deque");
        Item returnThis = first.item;
        first = first.next;
        //Can I avoid this "patched up" code?
        if(sizeOfQueue > 1)
            first.prev = null;
        else {
            last = null;
            first = null;
        }
        sizeOfQueue--;
        return returnThis;
    }
    
    /**
     removes and returns the last element in the deque
     @return returns the last element in the deque
     */
    private Item removeLast() {
        if(last == null)
            return (Item)("Tried to remove from empty deque");
        Item returnThis = last.item;
        last = last.prev;
        //Can I avoid this "patched up" code?
        if(sizeOfQueue > 1)
            last.next = null;
        else {
            last = null;
            first = null;
        }
        sizeOfQueue--;
        return returnThis;
    }
    
    /**
     gets the size of the deque
     @return returns the size
    */
    private int size() {
        return sizeOfQueue;
    }
    
    /**
     gets the first item of the list
     @return returns the first item of the list
    */
    private Item getFirst() {
        return first.item;
    }
    
    /**
     searches for a specific Item in the list
     @param find, item that is searched for
     @return returns true if item is in the list, false otherwise
    */
    //How would you generalize this to Strings and other useful datatypes?
    //for strings you need the .equals() method, but does that also work for
    //Integer datatypes or even a linked list of arrays?
    private boolean search(Item find) {
        boolean isTrue = false;
        for(Node current = first; !isTrue; current = current.next) {
            if(current.item.equals(find)) {
                isTrue = true;
            }
        }
        return isTrue;
    }
    
    /**
     gets the last item of the list
     @return returns the last item of the list
    */
    private Item getLast() {
        return last.item;
    }
    
    public Iterator<Item> iterator() {
        return new LinkedDequeIterator();
    }
    
    private class LinkedDequeIterator implements Iterator<Item> {
        private Node current = first;
        
        public boolean hasNext() {
            if(current == null)
                return false;
            return current.next != null;
        }
        
        public Item next() {
            Item it = current.item;
            current = current.next;
            return it;
        }
        
        public void remove() {
            if(current == first) {
                first = first.next;
            } else if(current = last) {
                last = last.prev;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
        }
    }
    
    public static void main(String[] args) {
        LinkedDeque<Integer> test = new LinkedDeque<Integer>();
        
        for(int i = 0; i < args.length; i += 2) {
            if(args[i].equals("first")) {
                System.out.println(test.removeFirst());
            } else if (args[i].equals("last")) {
                System.out.println(test.removeLast());
            } else if (args[i + 1].equals("begin")) {
                test.addBeginning(Integer.parseInt(args[i]));
            } else if (args[i + 1].equals("end")) {
                test.addEnd(Integer.parseInt(args[i]));
            } else {
                System.out.println("Error.\nUsage: java LinkedDeque " +
                                   "(Item) (To add: enter either 'begin'/'end')"+
                                   "...(To remove: enter either 'first'/'last')");
            }
        }
        
        for(Integer items : test) {
            System.out.println("Still remains: " + items);
        }
    }
}
