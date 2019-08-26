public class Converge {
	public static void main(String[] args)
	{
		double c = 2.0;
		double t = 2.0;
		while (Math.abs(t - c/t) > 1e-15*t)
			t = (c/t + t) / 2.0;
		System.out.println (t);
	}
};
