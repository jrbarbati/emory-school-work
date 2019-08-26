public class FibRec
{
	public static void main(String[] args)
	{
		for(int i = 0; i < args.length; i++)
		{
			long st  = System.currentTimeMillis();
			System.out.printf("%.3f\n", fib( Float.parseFloat( args[i] ) ) );
			long end = System.currentTimeMillis();
			System.out.println("Rec Took: " + (end - st) + " ms");
		}
	}

	public static float fib(float n)
	{
		if (n == 0f) return 0f;
		if (n == 1f) return 1f;

		return fib(n - 1f) + fib(n - 2f);
	}
}