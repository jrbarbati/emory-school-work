import java.util.Arrays;
public class BinarySearch {
    
    /**
     searches for a given key in a given sorted array
     @param a, sorted array of integers
     @param key, the key to be searched for
     @return returns the position of the key or -1 if it is not in the array
     (if a number is repeated in the array, it returns the position of the first
     instance of the number)
    */
    public static int binarySearch(int[] a, int key) {
        int hi = a.length - 1;
        int lo = 0;
        if(a[hi] == key)
            return hi;
        if(a[lo] == key)
            return lo;
        for(int i = 0; lo <= hi; i++) {
            int mid = ((hi - lo) / 2) + lo;
            if(a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Error.\nUsage: java BinarySearch" +
                               " (size of array) (key)");
        }
        int size = Integer.parseInt(args[0]);
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100) + 1;
        }
        Arrays.sort(array);
        
        System.out.print("The number you are searching for is at index: ");
        System.out.println(binarySearch(array, Integer.parseInt(args[1])));
    }
}
