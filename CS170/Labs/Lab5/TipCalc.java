//Joseph Barbati - jdbarba
//Section - 004
import java.util.Scanner;

public class TipCalc {
	//TODO: Write the method bill
    /**
     Method calculates bill before tip
     @param waffles multiplied by price of waffles to find total price of all
     waffles purchased
     @param hashbrowns multiplied by the price of hashbrowns to find total price 
     of all hashbrowns purchased
     @return returns the sum of the values of the parameters
    */
    public static double bill(int waffles, int hashbrowns) {
        double wafflePrice = 3.35 * waffles;
        double hashPrice = 1.45 * hashbrowns;
        double totalBeforeTip = wafflePrice + hashPrice;
        return totalBeforeTip;
    }

	//TODO: Write the method tip
    /**
     Method calculates appropriate tip 
     @param price used in deciding the approprate percentage to tip
     @return returns the dollar amount of the appropriate tip
    */
    public static double tip(double price) {
        if (price < 20.0) {
            double lowTip = price * 0.15;
            return lowTip;
        } else if (price < 30.0) {
            double medTip = price * 0.17;
            return medTip;
        } else {
            double highTip = price * 0.20;
            return highTip;
        }
    }

	//TODO: Write the method info
    /**
     Method prints information about purchase (bill before tip, tip, etc)
     @param waffles shows how many waffles were purchased
     @param hashbrowns shows how many hashbrowns were purchased
     @param b prints to screen and used to calculate total bill
     @param t prints to screen and used to calculate total bill
     @return This method is void, no return statement
    */
    public static void info(int waffles, int hashbrowns, double b, double t) {
        System.out.print("You bought " + waffles + " waffles");
        System.out.println(" and " + hashbrowns + " hasbrowns.");
        System.out.println("Calculated bill before tip: $" + b);
        System.out.println("Calculated tip: $" + t);
        double totalBill = b + t;
        double giveMoney = Math.ceil(totalBill);
        System.out.print("Total bill is $" + totalBill + ", ");
        System.out.println("rounded up to $" + giveMoney);
    }
	
	public static void main(String[] args) {
		//DO NOT change any code in the main method

		Scanner in = new Scanner(System.in);
		
		//get the number of waffles
		System.out.print("How many waffles? ");
		int w = in.nextInt();

		//get the number of hashbrowns from the user
		System.out.print("How many hashbrowns? " );
		int h = in.nextInt();

		//Calculate the total bill for waffles and hashbrowns
		double b = bill(w, h);
		double t = tip(b);
		info(w, h, b, t);
	}

}
