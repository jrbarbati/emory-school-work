public class Summ {

	// Calculate the sum of the integers a, a+1, ..., b-1
	public static int sum(int a, int b)
	{

		return (b*(b-1) - a*(a-1))/2;
		
	}

	public static double sum(double a, double b)
	{
		return (b*(b-1) - a*(a-1))/2.0;
	}


	public static void main(String[] args) {

		System.out.println ("Sum is " + (sum(1,101) + sum(200.0,301.0)));

	
	}
};
