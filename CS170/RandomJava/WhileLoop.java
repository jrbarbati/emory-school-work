public class WhileLoop {
	public static void main(String[] args) {
		System.out.println("While Loop");
		int i = 7398;
		int d = 0;
		int s = 0;
		int c = 0;
		while (i > 0) {
			d = i % 10;
			i = i / 10;
			s = s + d; 
			c = c + 1;
			System.out.println("i: " + i + " " + "d: " + d + " " + "s: " + s + " " + "c: " + c);
		}
	}
}
