import java.util.Scanner;

public class HW2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("\nType '-1' to quit.\n");

		while(true)
		{
			System.out.print("Enter decimal number: ");
			String dec = in.next();

			if (dec.equals("-1")) break;

			long decimal = Long.parseLong(dec);
			System.out.println(decimalToBinary(decimal));
			System.out.println("\n\n");
		}

		while(true)
		{
			System.out.print("Enter a string: ");
			String input = in.nextLine();

			if (input.equals("-1")) break;

			System.out.println("Number of vowels: " + countVowels(input));
			System.out.println("\n\n");
		}

		while(true)
		{
			int num, digit;
			
			System.out.print("Enter a number: ");
			try
			{
				num = Integer.parseInt(in.next());

				if (num == -1) break;

				System.out.print("Enter a digit: ");
				digit = Integer.parseInt(in.next());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Number had too many digits.\n" +
								   "Try a smaller one.\n\n");
				continue;
			}

			System.out.println("There are " +
								digitCount(num, digit) + " " + 
								digit + "s in " + num + ".");
			System.out.println("\n\n");
		}

	}
	//1a.
	public static int sumOfSquares(int n) 
	{
		int ans = 0;

		for(int i = 1; i <= n; i++) 
		{
			ans += (int)Math.pow(i, 2);
		}

		return ans;
	}

	//1b.
	public static int product(int a, int b) 
	{
		int ans = 0;

		for(int i = 0; i < b; i++) 
		{
			ans += a;
		}

		return ans;
	}

	//1c.
	public static double compoundInterest(double money, double interestRate, 
											int years) 
	{
		for(int i = 0; i < years; i++)
		{
			money += interestRate * money;
		}

		return money;
	} 

	//1d.
	public static int polySpiralLength(int n, double base, int rounds)
	{
		return 0;
	}

	//2.
	public static String decimalToBinary(long n)
	{
		String ans = "";

		for(int i = 0; i < 32; i++)
		{
			ans = (n % 2) + ans;
			n /= 2;
		}

		return ans;
	}

	//5.
	public static int countVowels(String s)
	{
		s = s.toLowerCase();

		int sum = 0;

		for(int i = 0; i < s.length(); i++)
		{
			if 		((int)s.charAt(i) == (int)'a') 	sum++;
			else if ((int)s.charAt(i) == (int)'e') 	sum++;
			else if ((int)s.charAt(i) == (int)'i')	sum++;
			else if ((int)s.charAt(i) == (int)'o')	sum++;
			else if ((int)s.charAt(i) == (int)'u')	sum++;
		}

		return sum;
	}

	public static int letterCount(String s, String c)
	{
		if (s.length() == 0) return 0;

		s = s.toLowerCase();
		c = c.toLowerCase();

		int sum = 0;

		for(int i = 0; i < s.length(); i++)
		{
			if (s.substring(i, i+1).equals(c)) sum++;
		}

		return sum;
	}

	public static int digitCount(int number, int digit) 
	{
		int sum = 0;

		for(int i = number; i != 0; i /= 10)
		{
			if (i % 10 == digit)
			{
				sum += 1;
			}
		}

		return sum;
	}

	public static boolean isPalindrome(String s)
	{
		for(int i = 0, j = s.length(); i < s.length() / 2; i++, j--)
		{
			if (s.substring(i, i+1).equals(s.substring(j - 1, j))) 
			{
				continue;
			}
			else 
			{
				return false;
			}
		}
		return true;
	}
	

}
