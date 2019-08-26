import java.util.Stack;

public class Queens {

	public static boolean feasible(Stack<Integer> cur, int i)
	{
		/* Columns */
		for (int j = 0; j < cur.size; j++)
		{
			if (cur.get(j) == i)
				return false;
		}

		/* Rows - automatically true by design  */

		/* Diagonals */
		for (int j = 0; j < cur.size; j++)
		{
			if (cur.get(j) == i)
				return false;
		}
	}

	public static Stack<Integer> solve(int N)
	{
		Stack<Integer> cur = new Stack<Integer>();
		int i = 0;

		cur.push(0); // Initialize

		while (cur.size() > 0)
		{

			if (feasible (cur, i))
			{
				cur.push (i);
			}

			i++;
			if (i == N)

		}

	}

	public static printQueens(Stack<Integer> stack)
	{
		
	}


	public static void main(String[] args)
	{
		
	}

}
