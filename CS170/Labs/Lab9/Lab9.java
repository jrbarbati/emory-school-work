//Joseph Barbati - jdbarba
//Section 004
import java.util.Arrays;
public class Lab9 {
    /**
     Method creates a random integer between 1 and 50
     @return returns the random int
    */
    public static int rand() {
        int rand = ((int)(Math.random() * 50)) + 1;
        return rand;
    }
    /**
     Method augments and array, filling it with random integers between 1 and 50
     @param a an integer array of anylength
    */
    public static void fillRandom(int[] a) {
        int i = 0;
        while (i < a.length) {
            int randomInt = rand();
            a[i] = randomInt;
            i++;
        }
    }
    /** 
     Method calculates the minimum gap between adjacent array elements (no 
     augmentation to original array)
     @param a integer array of any length
     @return returns an int that represents the minimum gap between adjacent
     array elements
    */
    public static int minGap(int[] a) {
        if (a.length >= 2) {
            int minimum = Math.abs(a[0] - a[1]);
            for(int i = 1; i < a.length - 1; i++) {
                int gap = Math.abs(a[i] - a[i + 1]);
                if (gap < minimum) {
                    minimum = gap;
                }
            }
            System.out.print("Minimum gap between two adjacent elements: ");
            return minimum;
        } else {
            return -1;
        }
    }
    public static void main (String[] args) {
        //Error in CLA's prompts Usage statement
        if (args.length == 0 || args.length > 1) {
            System.out.println("Usage: java Lab9 [size of array (int)]");
        } else {
            int size = Integer.parseInt(args[0]);
            int[] array = new int[size];
            fillRandom(array);
            System.out.print(Arrays.toString(array));
            System.out.println();
            System.out.println(minGap(array));
        }
    }
}
