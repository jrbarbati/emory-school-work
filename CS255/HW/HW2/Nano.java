 // THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR   
 // OR CODE WRITTEN BY OTHER STUDENTS - Joseph Barbati
import java.util.Arrays;

public class Nano
{
   public static char[] digit
            = {'#', '!', '%', '@', '(', ')', '[', ']', '$'};

   /* ==========================================================
      Return the 2's complement binary representation for the
      Nano number given in String s
      ========================================================== */
   public static int parseNano(String s)
   {
      /* ------------------------------------------------------------------
         This loop checks if the input contains an illegal (non-Nano) digit
         ------------------------------------------------------------------ */
      for (int i = 0 ; i < s.length(); i++)
      {
         int j = 0;
         while ( j < digit.length )
         {
            if ( s.charAt(i) == digit[j] || s.charAt(i) == '-' )
            {
               break;
            }

            j++;
         }

         if ( j >= digit.length )
         {
            System.out.println("Illegal nano digit found in input: " 
					+ s.charAt(i) );
            System.out.println("A Nano digit must be one of these: " 
				+ Arrays.toString (digit) );
            System.exit(1);
         }
      }

      // Write the parseNano() code here
      int start;
      int sign;
      int value;

      // Check sign
      if (s.charAt(0) == '-') {
         sign = -1;
         start = 1;
      } else {
         sign = 1;
         start = 0;
      }

      value = 0;

      for(int i = start; i < s.length(); i++) {
         value = 9 * value + getIndexOfChar(s.charAt(i));
      }

      if (sign == -1)
         value = -1 * value;

      return value;
   }

   /* ==========================================================
      Return the String of Nano digit that represent the value
      of the 2's complement binary number given in 
      the input parameter 'value'
      ========================================================== */
   public static String toString(int value)
   {
      // Write the toString() code here
      String repr = "";
      int digt, sign;

      // Checking sign.
      if (value < 0) {
         sign = -1;
         value = -1 * value;
      } else 
         sign = 1;
      
      // populating repr witch correct 'digits'
      for(int i = 0; value > 0; i++) {
         digt = value % 9;
         value /= 9;
         
         repr = getCharOfValue(digt) + repr;
      }

      // If value was negative, add negative sign
      if (sign == -1) {
         repr = "-" + repr;
      }

      return repr;
   }

   /**
    * Gets the index of the digit (int Nano system)
    * @param digit Nano digit to find
    * @return returns the index of 'digit'
    */
   private static int getIndexOfChar(char symbol) 
   {
      for(int i = 0; i < digit.length; i++)
      {
         if ((int)symbol == (int)digit[i]) 
         {
            return i;
         }
      }
      return -1;
   }

   /**
    * Gets the char of the value
    * @param value Value be checked
    * @return returns the char that represents that value in Nano system
    */
   private static char getCharOfValue(int value) 
   {
      return digit[value];
   }

}

