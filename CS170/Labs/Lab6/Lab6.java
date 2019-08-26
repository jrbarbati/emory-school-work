//Joseph Barbati - jdbarba
//Section 004
public class Lab6 {
    /**
     Method raises a number to a power
     @param a number to be raised to power of b
     @param b raise number a to this power
     @return returns the vale of the number raised to a power
    */
    public static int power(int a, int b) {
        if (b == 0) {
            return 1; //base case
        } else {
            power(a, b-1);
            int mult = a * (int)Math.pow(a, b-1);
            return mult;
        }
    }
    /**
     Method adds up the digits in a number
     @param n the number whose digits will be added
     @return returns the sum of the digits in the number
    */
    public static int sumDigits(int n) {
        int digitSum = 0;
        if (n == 0) {
            return 0; //base case
        } else {
            digitSum += n%10 + sumDigits(n/10);
        }
        return digitSum;
    }
	public static void main(String[] args) {
		System.out.println("\tLab 6");
        System.out.println("\tTask 1");
        System.out.println(power(2, 3)); //8
        System.out.println(power(2, 5)); //32
        System.out.println(power(7, 2)); //49
        System.out.println(power(8, 3)); //512
        System.out.println(power(2, 16)); //65536
        System.out.println(power(-2, 14)); //16384
        System.out.println("\tTask 2");
        System.out.println(sumDigits(558)); //18
        System.out.println(sumDigits(291902)); //23
        System.out.println(sumDigits(8938912)); //40
        System.out.println(sumDigits(999999)); //54
        System.out.println(sumDigits(2147483647)); //46
    }
}
