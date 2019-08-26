public class StackOfStrings {
    
    private String[] stack;
    private int size;
    //Index of next free spot
    private int first;
    
    public StackOfStrings(int capacity) {
        stack = new String[capacity];
        size = 0;
        first = 0;
    }
    
    /**
     adds an element to top of stack
     @param s, element that is added
    */
    private void push(String s) {
        if(size == stack.length) {
            resizeUp();
        }
        stack[first++] = s;
        size++;
    }
    
    /**
     removes element from top of stack
     @return, returns the removed element
    */
    private String pop() {
        if(size == 0) {
            throw new ArrayIndexOutOfBoundsException("Tried to pop from empty" +
                                                     " stack.");
        }
        if(size == stack.length / 4) {
            resizeDown();
        }
        String s = stack[--first];
        stack[first] = null;
        size--;
        return s;
    }
    
    /**
     resizes the stack, doubles the size
    */
    private void resizeUp() {
        String[] newStack = new String[stack.length * 2];
        for(int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }
    
    /** 
     resizes the stack, halves the size
    */
    private void resizeDown() {
        String[] newStack = new String[stack.length / 2];
        for(int i = 0; i < newStack.length; i++) {
          newStack[i] = stack[i];
        }
        stack = newStack;
    }

    public static void main(String[] args) {
        StackOfStrings test = new StackOfStrings(10);
        for(int i = 0; i < args.length; i++) {
            if(args[i].equals("-")) {
                System.out.println(test.pop());
            } else {
                test.push(args[i]);
            }
            //System.out.println("Stack Length: " + test.stack.length);
        }
    }
}