public class Evaluate {
	public static void main(String[] args) { 
		Stack<String> ops = new Stack<String>();
		Stack<Double> nums = new Stack<Double>();

		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			switch (s.charAt(0)) {
				case '(':
					break; // ignore
				case '*':
				case '+':
				case '-':
				case '/':
					ops.push(s);	
					break;

				case ')':
					String op = ops.pop();
					Double val1, val2, ret;
					val1 = nums.pop();
					val2 = nums.pop();
					switch (op.charAt(0)) {
						case '*':
							ret = val2 * val1;	
							break;
						case '/':
							ret = val2 / val1;	
							break;
						case '+':
							ret = val2 + val1;	
							break;
						case '-':
							ret = val2 - val1;	
							break;
						default:
							ret = -999.0;
							break;
					}
					nums.push(ret);
					break;
				default:
					nums.push(Double.parseDouble(s));	
					break;
			}
		}
		StdOut.println(nums.pop());
	}
}

