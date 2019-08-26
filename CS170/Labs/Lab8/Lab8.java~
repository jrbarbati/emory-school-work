//Joseph Barbati - jdbarba
//Section 004
import java.io.*;
import java.util.Scanner;
public class Lab8 {
    public static void main(String[] args) throws IOException {
        //Initially setting up file and scanner to read from file
        File numbers = new File("nums.txt");
        Scanner sumNums = new Scanner(numbers);
        
        //makes sure the user inputs exactly 2 CLA's
        if (args.length != 2) {
            System.out.print("Usage: java Lab8 (number of ints to sum up)");
            System.out.println(" (number of lines in between numbers to sum)");
	    return;
        }
        
        //Converting CLA's to ints
        int cla1 = Integer.parseInt(args[0]);
        int cla2 = Integer.parseInt(args[1]);
        
        //Loop to sum up the ints on the requested lines, prints sum at end of
        //loop
        int i = 0;
        int sum = 0;
        while (i < (cla1 * cla2)) {
            i++;
            if (i % cla2 == 1) {
                int nums = sumNums.nextInt();
                sum += nums;
            }
            sumNums.nextLine();
        }
        System.out.println("Sum: " + sum);
    }
}
