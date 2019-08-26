public class HW1 {

	public static void polyspiral(int n, double base, int rounds) {
		int degrees = 120;
		Turtle t = new Turtle();
		for(int i = 0; i < n * rounds; i++) {
			t.forward(base);
			t.right(degrees);
			base *= 1.3;
		}
	}

	public static void polywheel(int numSides, double length) {

	}

	public static void multistar(int n, double length) {

	}

	public static void pyramid(double base, int levels) {

	}

	public static void houseline(int numHouses) {

	}

	public static void main(String[] args) {
		polyspiral(3, 15, 5);
	}
}