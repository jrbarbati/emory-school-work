public class Sum {
	public Sum() {
	}

	public static int sum(int a, int b) {
		int z = 0;
		for (int i = a; i < b; i++)
			z += i;
		return z;
	}
};
