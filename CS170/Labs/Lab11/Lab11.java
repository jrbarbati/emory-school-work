//Joseph Barbati - jdbarba
//Section 004
import java.math.BigInteger;
public class Lab11 {
    /**
     * method calculates the factorial
     * @param n the factorial of this integer will be calculated
     * @return returns a BigInteger value of the factorial
     */
    public static BigInteger factorial(int n) {
        BigInteger result = new BigInteger("1");
        for(int i = 1; i <= n; i++){
            result = result.multiply(new BigInteger(i + ""));
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        //prints the factorial of each i from 1 to 31
        for(int i = 1; i <= 31; i++) {
            System.out.println(i + "\t" + factorial(i));
        }
        
//        BigInteger ten = new BigInteger("10");
//        System.out.println(ten);
    }
    
    
}
