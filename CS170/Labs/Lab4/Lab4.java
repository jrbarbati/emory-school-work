//Joseph Barbati - jdbarba
//Section 004
public class Lab4 {
    public static void main(String[] args) {
        System.out.println("\tLab4");
        System.out.println("Exercise 1: Zork");
        System.out.println("Miles: " + bloitsToMiles(3));
        System.out.println("Exercise 2: Random Numbers");
        System.out.println("Number of dots on winning side: " + roll(3));
        //Testing randomness
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));
//        System.out.println(roll(3));

    }
    /**
     Method takes the number of miles entered by user and converts it to bloits
     @param miles User entered, multiplied by 1.3 to get number of bloits
     @return This method returns the number of bloits for entered number of miles
    */
    public static double bloitsToMiles(int bloits) {
        double miles = bloits * 1.3;
        return miles;
    }
    /** 
     Method takes the number of sides entered by user and randomly selects a
     winning face
     @param sides User entered, multiplied by Math.random() to create
     possibilities from 0 to sides - 1 (inclusive)
     @return This method returns the random number generated
    */
    public static int roll(int sides) {
        //One is added here to make sure that "0" dots doesn't show up becuase
        //zero dots are not possible
        //effectively making the random numbers [1, # of Sides]
        double d = sides * Math.random();
        return (int)d + 1;
    }
}