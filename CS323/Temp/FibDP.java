public class FibDP
{
	public static void main(String[] args)
	{
		for(int i = 0; i < args.length; i++)
		{
			long st  = System.currentTimeMillis();
			System.out.printf("%.3f\n", fib( Integer.parseInt( args[i] ) ) );
			long end = System.currentTimeMillis();
			System.out.println("DP Took: " + (end - st) + " ms");
		}
	}

	public static float fib(int n)
	{
		float[] table = createTable(n);
		return fib(n, table);

	}

	public static float fib(int n, float[] table)
	{
		if (table[n] != -1f)
		{
			return table[n];
		}
		else 
		{
			table[n - 1] = fib(n - 1, table);
			table[n - 2] = fib(n - 2, table);
			return table[n - 1] + table[n - 2];
		}
	}

	public static float[] createTable(int n)
	{
		float[] temp = new float[n + 1];
		for(int i = 0; i <= n; i++)
		{
			temp[i] = -1f;
		}
		temp[0] = 0f;
		temp[1] = 1f;

		return temp;
	}
}