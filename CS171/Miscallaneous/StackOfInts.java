public class StackOfInts {
    private int[] arr;
    private int N = 0; //Keeps track of next new slot
    
    public StackOfInts() {
        arr = new int[10];
    }
    
    public void push(int n) {
        if(arr.length == N) {
            resize(arr.length * 2);
        }
        arr[N++] = n;
    }
    
    public int pop() {
        if (N <= arr.length / 4) {
            resize(arr.length / 2);
        }
        return arr[--N];
    }
    
    public void resize(int newSize) {
        int[] newArray = new int[newSize];
        for(int i = 0; i < N; i++) {
            newArray[i] = arr[i];
        }
        arr = newArray;
    }
    
    public boolean isEmpty() {
        return (N == 0);
    }
    
    public int size() {
        return N;
    }
    
    public static void main(String[] args) {

    }
}