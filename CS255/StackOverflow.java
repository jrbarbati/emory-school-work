public class StackOverflow {
    public static void main(String[] args) {
        try {
            recursion(0);
        } catch (StackOverflowError e) {
            System.out.println("You caused a StackOverflow Error.");
        }
    }
    public static int recursion(int num) {
        recursion(0);
        return num;
    }
}
