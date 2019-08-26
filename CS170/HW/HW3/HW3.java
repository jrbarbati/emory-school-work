//Joseph Barbati - jdbarba
//Section 004
//Worked by myself
//Due Oct 15, 2015 9pm
public class HW3 {
    //Exercise 1
    /**
     Method shows bus stop closest to the street you live on
     @param street used to find the closest stop
     @return returns the closest bus stop
    */
	public static int closestBusStop(int street) {
        int busStop = street % 8;
        if (street >= 0) {
            if (busStop == 0) {
                System.out.print("Bus Stop: ");
                return street;
            } else if (busStop <= 4) {
                System.out.print("Bus Stop: ");
                return street - busStop;
            } else if (busStop > 4) {
                System.out.print("Bus Stop: ");
                return street + (8 - busStop);
            }
        } else {
            System.out.print("Make sure the street number is positive! ");
            System.out.print("You entered: ");
        }
        return street;
	}
    //Exercise 2
    /**
     Method calculates the number of nickels returned to a person given amount
     of change
     @param pennies amount of total change to be returned
     @return returns the number of nickels that should be returned, given the
     amount pennies, after quarters and dimes are returned
    */
    public static int numNickels(int pennies) {
//        int numQuarters = pennies / 25;
//        int numDimes = (pennies % 25) / 10;
        int numNicks = ((pennies % 25) % 10) / 5;
        System.out.print("Number of nickels: ");
        return numNicks;
    }
    //Exercise 3
    /**
     Method takes a 6-digit integer and tells whether that number is a winner
     @param tickNumber 6-digit integer\
     @return returns a boolean, true for a winning ticket, false if not.
    */
    public static boolean ticket(int tickNumber) {
        String s = "" + tickNumber;
        //Makes sure the number entered is 6-digits
        if (s.length() == 6) {
            int i = 2;
            int ones = 0;
            int twos = 0;
            int threes = 0;
            int fours = 0;
            int fives = 0;
            int sixes = 0;
            int sevens = 0;
            int eights = 0;
            int nines = 0;
            //Iterates through the characters of s after index 1
            //This adds up the number of each number in last 4 digits
            while (i < s.length()) {
                if (s.charAt(i) == '1') {
                    ones++;
                } else if (s.charAt(i) == '2') {
                    twos++;
                } else if (s.charAt(i) == '3') {
                    threes++;
                } else if (s.charAt(i) == '4') {
                    fours++;
                } else if (s.charAt(i) == '5') {
                    fives++;
                } else if (s.charAt(i) == '6') {
                    sixes++;
                } else if (s.charAt(i) == '7') {
                    sevens ++;
                } else if (s.charAt(i) == '8') {
                    eights++;
                } else if (s.charAt(i) == '9') {
                    nines++;
                }
                i++;
            }
            //Uses the results from the above loop and sees if the second
            //digit equals the number of times the digit at index 0 is
            //seen in the final 4 digits.
            if (s.charAt(0) == '1') {
                if (s.charAt(1) == ('0' + ones)) {
                    return true;
                }
            } else if (s.charAt(0) == '2') {
                if (s.charAt(1) == ('0' + twos)) {
                    return true;
                }
            } else if (s.charAt(0) == '3') {
                if (s.charAt(1) == ('0' + threes)) {
                    return true;
                }
            } else if (s.charAt(0) == '4') {
                if (s.charAt(1) == ('0' + fours)) {
                    return true;
                }
            } else if (s.charAt(0) == '5') {
                if (s.charAt(1) == ('0' + fives)) {
                    return true;
                } 
            } else if (s.charAt(0) == '6') {
                if (s.charAt(1) == ('0' + sixes)) {
                    return true;
                } 
            } else if (s.charAt(0) == '7') {
                if (s.charAt(1) == ('0' + sevens)) {
                    return true;
                } 
            } else if (s.charAt(0) == '8') {
                if (s.charAt(1) == ('0' + eights)) {
                    return true;
                }
            } else if (s.charAt(0) == '9') {
                if (s.charAt(1) == ('0' + nines)) {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            System.out.print("Enter a positive, six-digit number!");
            return false;
        }
        return false;
    }
    //Exercise 4
    /**
     Method calculates the number of points given a certain roll of three die
     @param roll1 the number on the first die
     @param roll2 the number on the second die
     @param roll3 the number on the third die
     @return returns the number of points awared based on rules of game
    */
    public static int triples(int roll1, int roll2, int roll3) {
        int points = 0;
        if (roll1 == roll2 && roll2 == roll3) {
            points += 100;
        } else if (roll1 == 1 || roll2 == 1 || roll3 == 1) {
            if (roll1 == roll2 || roll2 == roll3 || roll1 == roll3) {
                points += 45;
            } else if (roll1 % 2 != 0 && roll2 % 2 != 0 && roll3 % 2 != 0) {
                points += 20;
            } else if (roll1 + roll2 == roll3) {
                points += 10;
            } else if (roll1 + roll3 == roll2) {
                points += 10;
            } else if (roll2 + roll3 == roll1) {
                points += 10;
            }
        } else if (roll1 == 2 || roll2 == 2 || roll3 == 2) {
            if (roll1 % 2 == 0 && roll2 % 2 == 0 && roll3 % 2 == 0) {
                points += 20;
            } else if (roll1 + roll2 == roll3) {
                points += 10;
            } else if (roll1 + roll3 == roll2) {
                points += 10;
            } else if (roll2 + roll3 == roll1) {
                points += 10;
            }
        } else if (roll1 == 3 || roll2 == 3 || roll3 == 3) {
            if (roll1 == roll2 || roll2 == roll3 || roll1 == roll3) {
                points += 45;
            } else if (roll1 % 2 != 0 && roll2 % 2 != 0 && roll3 % 2 != 0) {
                points += 20;
            } else if (roll1 + roll2 == roll3) {
                points += 10;
            } else if (roll1 + roll3 == roll2) {
                points += 10;
            } else if (roll2 + roll3 == roll1) {
                points += 10;
            }
        } else if (roll1 == 4 || roll2 == 4 || roll3 == 4) {
            if (roll1 % 2 == 0 && roll2 % 2 == 0 && roll3 % 2 == 0) {
                points += 20;
            } else if (roll1 + roll2 == roll3) {
                points += 10;
            } else if (roll1 + roll3 == roll2) {
                points += 10;
            } else if (roll2 + roll3 == roll1) {
                points += 10;
            }
        } else if (roll1 == 5 || roll2 == 5 || roll3 == 5) {
            if (roll1 % 2 != 0 && roll2 % 2 != 0 && roll3 % 2 != 0) {
                points += 20;
            }else if (roll1 + roll2 == roll3) {
                points += 10;
            } else if (roll1 + roll3 == roll2) {
                points += 10;
            } else if (roll2 + roll3 == roll1) {
                points += 10;
            }
        }
        else if (roll1 == 6 || roll2 == 6 || roll3 == 6) {
            if (roll1 == roll2 || roll2 == roll3 || roll1 == roll3) {
                points += 45;
            } else if (roll1 % 2 == 0 && roll2 % 2 == 0 && roll3 % 2 == 0) {
                points += 20;
            }else if (roll1 + roll2 == roll3) {
                points += 10;
            } else if (roll1 + roll3 == roll2) {
                points += 10;
            } else if (roll2 + roll3 == roll1) {
                points += 10;
            }
        }
        System.out.print("Points: ");
        return points;
    }
    //Exercise 5
    /**
     Medthod predicts what side will come up on a loaded die
     @return returns the number of dots on top side of loaded die
    */
    public static int loaded() {
        double random = Math.random();
        //Don't need logical operators b/c of the way Java reads if-statements
        if (random <= 0.25) {
            return 1;
        } else if (random <= 0.50) {
            return 2;
        } else if (random <= 0.70) {
            return 3;
        } else if (random <= 0.85) {
            return 4;
        } else if (random <= 0.95) {
            return 5;
        } else if (random > 0.95) {
            return 6;
        }
        return 0;
    }
	public static void main(String[] args) {
        System.out.println("\t   HW3");
        System.out.println("\tExercise 1");
        System.out.println(closestBusStop(100)); //96
        System.out.println(closestBusStop(-10)); //print statement
        System.out.println(closestBusStop(33)); //32
        System.out.println(closestBusStop(29)); //32
        System.out.println(closestBusStop(122)); //120
        System.out.println(closestBusStop(3)); //0
        System.out.println("\tExercise 2");
        System.out.println(numNickels(36)); //0
        System.out.println(numNickels(40)); //1
        System.out.println(numNickels(5)); //1
        System.out.println(numNickels(90)); //1
        System.out.println(numNickels(4839)); //0
        System.out.println("\tExercise 3");
        System.out.println(ticket(120011));
        System.out.println(ticket(389239));
        System.out.println(ticket(333333));
        System.out.println(ticket(923995));
        System.out.println(ticket(923945));
        System.out.println(ticket(004655));//false becuase it read
                                           //it as 4655.
        System.out.println("\tExercise 4");
        System.out.println(triples(4, 4, 4)); //100
        System.out.println(triples(6, 3, 6)); //45
        System.out.println(triples(2, 4, 6)); //20
        System.out.println(triples(1, 3, 4)); //10
        System.out.println(triples(1, 2, 6)); //0
        System.out.println("\tExercise 5");
        //Testing randomness
        int i = 0;
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;
        while (i < 1000000) {
            int num = loaded();
            if (num == 1) {
                ones++;
            } else if (num == 2) {
                twos++;
            } else if (num == 3) {
                threes++;
            } else if (num == 4) {
                fours++;
            } else if (num == 5) {
                fives++;
            } else if (num == 6) {
                sixes++;
            }
            i++;
        }
        System.out.println("1's: " + ones);
        System.out.println("2's: " + twos);
        System.out.println("3's: " + threes);
        System.out.println("4's: " + fours);
        System.out.println("5's: " + fives);
        System.out.println("6's: " + sixes);
    }
}
