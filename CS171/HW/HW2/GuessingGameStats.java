import java.util.Arrays;
public class GuessingGameStats {
    public static void main(String[] args) {
        int[] numberOfGuesses = {12, 11, 12, 7, 6, 9, 9, 12, 9, 12, 9, 11, 10, 7,
            8, 8, 6, 10, 11, 10, 7, 11, 7, 12, 12, 8, 11, 9, 10, 10, 10, 10, 10,
            12, 12, 10, 12, 10, 8, 9, 11, 8, 6, 8, 7, 8, 10, 12, 9, 12, 11, 8, 11,
            11, 11, 9, 6, 12, 6, 8, 12, 4, 10, 10, 9, 12, 9, 12, 8, 11, 8, 12, 8,
            11, 10, 10, 7, 9, 11, 10, 12, 13, 11, 11, 6, 10, 11, 11, 7, 12, 12,
            11, 10, 10, 6, 12, 12, 8, 11, 8, 11, 13, 10, 7, 11, 9, 12, 11, 8, 8,
            8, 12, 5, 10, 11, 13, 12, 10, 11, 9, 12, 11, 14, 8, 8, 12, 11, 10, 11,
            9, 11, 11, 9, 7, 12, 12, 11, 10, 10, 12, 10, 13, 10, 8, 10, 11, 9, 10,
            10, 12, 10, 11, 11, 9, 11, 7, 9, 11, 8, 9, 8, 9, 7, 10, 11, 11, 11, 
            9, 10, 10, 10, 12, 7, 12, 9, 10, 11, 12, 7, 9, 12, 12, 12, 11, 13, 6,
            11, 12, 8, 5, 10, 9, 11, 11, 9, 11, 13, 13, 10, 12};
        for(int i = 0; i < numberOfGuesses.length; i++) {
            numberOfGuesses[i] -= 1;
        }
        Arrays.sort(numberOfGuesses);
        System.out.println(Arrays.toString(numberOfGuesses));
        System.out.println();
        System.out.println(numberOfGuesses.length);
        double sum = 0;
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;
        int sevens = 0;
        int eights = 0;
        int nines = 0;
        int tens = 0;
        int elevens = 0;
        int twelves = 0;
        int thirteens = 0;
        int fourteens = 0;
        for(int i = 0; i < numberOfGuesses.length; i++) {
            sum += numberOfGuesses[i];
            if(numberOfGuesses[i] == 0) {
                zeros++;
            } else if(numberOfGuesses[i] == 1) {
                ones++;
            } else if(numberOfGuesses[i] == 2) {
                twos++;
            } else if(numberOfGuesses[i] == 3) {
                threes++;
            } else if(numberOfGuesses[i] == 4) {
                fours++;
            } else if(numberOfGuesses[i] == 5) {
                fives++;
            } else if(numberOfGuesses[i] == 6) {
                sixes++;
            } else if(numberOfGuesses[i] == 7) {
                sevens++;
            } else if(numberOfGuesses[i] == 8) {
                eights++;
            } else if(numberOfGuesses[i] == 9) {
                nines++;
            } else if(numberOfGuesses[i] == 10) {
                tens++;
            } else if(numberOfGuesses[i] == 11) {
                elevens++;
            } else if(numberOfGuesses[i] == 12) {
                twelves++;
            } else if(numberOfGuesses[i] == 13) {
                thirteens++;
            } else if(numberOfGuesses[i] == 14) {
                fourteens++;
            }
        }
        double average = sum / numberOfGuesses.length;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Zeros: " + zeros);
        System.out.println("Ones: " + ones);
        System.out.println("Twos: " + twos);
        System.out.println("Threes: " + threes);
        System.out.println("Fours: " + fours);
        System.out.println("Fives: " + fives);
        System.out.println("Sixes: " + sixes);
        System.out.println("Sevens: " + sevens);
        System.out.println("Eights: " + eights);
        System.out.println("Nines: " + nines);
        System.out.println("Tens: " + tens);
        System.out.println("Elevens: " + elevens);
        System.out.println("Twelves: " + twelves);
        System.out.println("Thirteens: " + thirteens);
        System.out.println("Fourteens: " + fourteens);

    }
}