public class Pretest {
    public static int inOrder(int[] array) {
        int total = 0;
        for(int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                total++;
            } 
        }
        return total;
    }
    public static void main(String[] args) {
        int[] test = {3, 7, 8, 5, 4, 9};
        System.out.println(inOrder(test));
    }
}