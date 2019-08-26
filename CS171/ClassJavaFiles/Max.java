public class Max {

	public static int max(int num1, int num2) { 
		if (num1 > num2)
			return num1;
		else
			return num2;
	}


	public static void main(String[] args) {
		System.out.println ("Max is: " + max(99,42));
	}
};
