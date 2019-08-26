public class CircularDoublyLinkedList<Item> {
    
    private class Node {
        Item item;
        Node next = null;
        Node prev = null;
    }
    
    private Node current, first;
    int sizeOflist;
    
    public CircularDoublyLinkedList() {
        current = null;
        sizeOflist = 0;
    }
    
    /**
     adds the specifed itember to the end of the LinkedList
     @param addThis, itember to be added to LinkedList
    */
    private void add(Item addThis) {
        Node temp = new Node();
        temp.item = addThis;
        if(current == null) {
            first = temp;
            current = temp;
//            System.out.println("Added: " + current.item);
        } else {
            current.next = temp;
            temp.prev = current;
            current = temp;
            first.prev = current;
            current.next = first;
//            System.out.println("Added: " + current.item);
        }
        sizeOflist++;
    }
    
    /**
     removes the specified node
     @param removeThis, the node to be removed
    */
    private Item remove(Node removeThis) {
        if(first == null) {
            throw new IndexOutOfBoundsException("Tried to remove from empty list");
        }
        Item returnThis = removeThis.item;
        removeThis.prev.next = removeThis.next;
        removeThis.next.prev = removeThis.prev;
        sizeOflist--;
        return returnThis;
    }
    
    /**
     @return returns the size of the LinkedList
    */
    private int size() {
        return sizeOflist;
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList<String> test = new CircularDoublyLinkedList<String>();
        for(int i = 0; i < args.length; i++) {
            if(args[i].equals("R")) {
                System.out.println("Removed: " + test.remove(test.current));
                test.current = test.current.next;
            } else {
                test.add(args[i]);
            }
        }
    }
}
