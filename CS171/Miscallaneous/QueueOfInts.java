public class QueueOfInts {
    
    private int[] queue;
    private int size = 0;
    //points to the first item that will be dequeued
    private int first;
    //points to the next open spot that will be enqueued
    private int last;
    
    public QueueOfInts(int capacity) {
        int[] queue = new int[capacity];
        size = 0;
        first = 0;
        last = 0;
    }
    
    private void enqueue(int add) {
        if(size == queue.length) {
            resizeUp();
            first = 0;
            last = size - 1;
        }
        queue[(last++) % queue.length] = add;
        size++;
    }
    
    private int dequeue() {
        if(size == queue.length / 4) {
            resizeDown();
            first = 0;
            last = size - 1;
        }
        int returnThis = queue[(first) % queue.length];
        queue[(first++) % queue.length] = 0;
        size--;
        return returnThis;
    }
    
    private void resizeUp() {
        int[] newQueue = new int[queue.length * 2];
        for(int i = 0; i < queue.length; i++) {
            newQueue[i] = queue[first++ % queue.length];
        }
        queue = newQueue;
    }
    
    private void resizeDown() {
        int[] newQueue = new int[queue.length / 2];
        for(int i = 0; i < newQueue.length; i++) {
            newQueue[i] = queue[first++ % size];
        }
        queue = newQueue;
    }
    
    public static void main(String[] args) {
        QueueOfInts test = new QueueOfInts(10);
        System.out.println("Size of queue: " + test.queue.length);
        for(int i = 0; i < args.length; i++) {
            if(args[i].equals("-")) {
                System.out.println(test.dequeue());
            } else {
                test.enqueue(Integer.parseInt(args[i]));
            }
            System.out.println("Size of Queue: " + test.queue.length);
        }
    }
}