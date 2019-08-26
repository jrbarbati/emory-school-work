import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //User inputs integer
        System.out.print("Please enter an integer: ");
        int x = in.nextInt();
        //User inputs another integer
        System.out.print("Please enter another integer: ");
        int y = in.nextInt();
        //Prints the sum of the two integers
        System.out.print("The sum of those two numbers is: ");
        System.out.println(x + y);
        //prints the return value for equation method
        System.out.println(equation());
    }
    //Method designed to take user input and outputs the answer to the equation
    //xe^-x + sqrt(1-e^-x)
    public static double equation() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter a value for x: ");
        double x = userInput.nextDouble();
        double output = (x * Math.pow(Math.exp(1), -x)) + Math.sqrt(1 - Math.pow(Math.exp(1), -x));
        System.out.print("The answer to the equation xe^-x + sqrt(1-(e^-x)) ");
	System.out.println(" with that x is: ");
        return output;
    }
}
