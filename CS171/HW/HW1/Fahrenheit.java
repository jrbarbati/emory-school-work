//Joseph Barbati
import java.util.Scanner;
public class Fahrenheit {
    public static Scanner input = new Scanner(System.in);
    public static double toCelsius(double f) {
        return (f - 32) / 1.8;
    }
    public static void main(String[] args) {
        boolean again = true;
        while(again) {
            System.out.print("Enter degrees in Fahrenheit: ");
            double degreesFahrenheit = input.nextDouble();
            
            double degreesCelsius = toCelsius(degreesFahrenheit);
            System.out.println("Degrees Celsius: " + degreesCelsius);
            
            System.out.print("Again? (y/n) ");
            String againString = input.next();
            againString = againString.toLowerCase();
            if(againString.equals("y")) {
                again = true;
            } else {
                again = false;
            }
        }
    }
}
