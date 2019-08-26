//Joseph Barbati - jdbarba
//Section 004
public class Roulette {
    
//   private String[] value;
//   private String[] color;
//
//   private int outcome;
    
   public String[] value;
   public String[] color;
    
   public int outcome;

   /* Constructor Method to make a roulette wheel */
   public Roulette( ) {
       value = new String[38];
       color = new String[38];
       
       //for the color array, I felt adding the colors one by one was best
       //because the colors don't necessarily alternate, which means it would be
       //hard to write a loop, it would involve many conditionals and this just
       //seemed easier
       
       color[0] = "G";
       color[1] = "R";
       color[2] = "B";
       color[3] = "R";
       color[4] = "B";
       color[5] = "R";
       color[6] = "B";
       color[7] = "R";
       color[8] = "B";
       color[9] = "R";
       color[10] = "B";
       color[11] = "B";
       color[12] = "R";
       color[13] = "B";
       color[14] = "R";
       color[15] = "B";
       color[16] = "R";
       color[17] = "B";
       color[18] = "R";
       color[19] = "R";
       color[20] = "B";
       color[21] = "R";
       color[22] = "B";
       color[23] = "R";
       color[24] = "R";
       color[25] = "R";
       color[26] = "B";
       color[27] = "R";
       color[28] = "B";
       color[29] = "B";
       color[30] = "R";
       color[31] = "B";
       color[32] = "R";
       color[33] = "B";
       color[34] = "R";
       color[35] = "B";
       color[36] = "R";
       color[37] = "G";
       
       //loop to create value array, the last value "00" is added after loop
       //ends
       
       for(int i = 0; i < 37; i++) {
           value[i] = i + "";
       }
       value[37] = "00";
   }


   /* initializes the outcome instance variable with a random number 0 - 37 */
   public void spin() {
       outcome = (int)(38 * Math.random());
   }


   /* ************************************************
      TODO: Task 2b: change the instance variable to  

                   private

      and recompile Test1.java and Test2.java

      You should get errors
      ************************************************ */

   /* makes the outcome (int) a string and returns the string to give other
      files access to what the outcome was */
   public String getValue() {
      return outcome + "";
   }

   /* returns the value of the color array at the 'outcome' index */
   public String getColor() {
      return color[outcome];
   }

   /* creates a string representation of the Roulette object */
   public String toString() {	
		return value[outcome] + "\t" + color[outcome];
   }

}



