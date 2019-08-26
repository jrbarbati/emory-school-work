public class RandomNumber {
    public static void main(String[] args) {
        int random = (int)(Math.random() * 9000) + 1000;
        System.out.println(random);
    }
}