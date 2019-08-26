import java.util.Arrays;
//DOESN'T WORK
public class Quicksort {
    
    public Quicksort() {
        
    }
    
    public static void sort(Comparable[] a) {
        quicksort(a, 0, a.length - 1);
    }
    
    //quicksort sorts array a[lo:hi], inclusive.
    private static void quicksort(Comparable[] a, int lo, int hi) {
        if(lo >= hi)
            return;
        int pivot = partition(a, lo, hi);
        quicksort(a, lo, pivot - 1);
        quicksort(a, pivot + 1, hi);
    }
    
    //we return a pivot point for which a now satisfies
    //a[lo:p - 1] is less than or equal to a[p] and a[p + 1:hi] is greater than
    //a[p]
    private static int partition(Comparable[] a, int lo, int hi) {
        int pivot = lo;
        int i = lo + 1;
        int j = hi;
        
        while(i <= j) {
            //If a[i] is smaller than the pivot, then just increment i;
            //Same with j (but decrement)
            while(i < hi && less(a[i], a[pivot]))
                i++;
            while(j > lo && less(a[pivot], a[j]))
                j--;
            
            if(i >= j)
                break;
            //Exchange a[i] and a[j] when a[i] is greater than a[j]
            exch(a, i, j);
        }
        //exchange the last element less than the pivot with the pivot
        exch(a, pivot, i);
        
        return pivot;
    }
    
    //true if v < w, false otherwise
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
    
    private static void exch(Comparable[] a, int lo, int hi) {
        Comparable temp = a[lo];
        a[lo] = a[hi];
        a[hi] = temp;
    }
    
    public static void main(String[] args) {
        Comparable[] test = new Comparable[args.length];
        
        for(int i = 0; i < args.length; i++) {
            test[i] = args[i];
        }
        
        sort(test);
        
        System.out.println(Arrays.toString(test));
    }
}