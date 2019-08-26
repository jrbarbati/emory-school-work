public class QueueOfStrings {
    private String[] arr;
    private int first = 0; //keeps track of first number in queue
    private int last = 0; //keeps track of first available slot
    private int N = 0; //keeps track of size of queue
    
    public QueueOfStrings() {
        arr = new String[10];
    }
    
    //Adds to end of queue
    public void enqueue(String s) {
        arr[last] = s;
        last = (last + 1) % arr.length;
        N++;
    }
    
    //Removes from beginning of queue
    public String dequeue() {
        String value = arr[first];
        arr[first] = null;
        first = (first + 1) % arr.length;
        N--;
        return value;
    }
    
    public void resize() {
        //Should the old array alias this new array after it has been created?
    }
    
    public boolean isEmpty() {
        return (N == 0);
    }
    public static void main(String[] args) {

    }
}
