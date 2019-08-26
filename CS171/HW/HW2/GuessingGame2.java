import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class GuessingGame2 {
    
    public ArrayList<Integer> list = new ArrayList<Integer>();
    public int countGuesses = 0;
    public int random;
    public int guess;
    public int matches;
    public int sizeOfListCheck1;
    public int sizeOfListCheck2;
    /**
     creates an ArrayList with numbers 10000 - 99999
     */
    public GuessingGame2() {
        
        //Removes the ten values that are put in using default ArrayList
        //constructor
        list.clear();
        
        int numberToAdd = 10000;
        
        //Adds the numbers 1000 - 9999 to the ArrayList<Integer> list.
        for(int i = 0; i < 90000; i++) {
            list.add(i, numberToAdd);
            numberToAdd++;
        }
    }
    
    /**
     comes up with a guess based on the size of the ArrayList
     @return returns the guess or -1 if the ArrayList doesn't hold anymore
     numbers
     */
    public int myGuessIs() {
        if (list.size() > 0) {
            
            //Checks to make sure the size of the list has changed, if not,
            //invalid input was entered and this repeats the last guess
            if(sizeOfListCheck1 != sizeOfListCheck2) {
                guess = list.get(random);
                return guess;
            }
            
            sizeOfListCheck1 = list.size();
            //            System.out.println("Size of List (myGuessIs()) - " + sizeOfListCheck1);
            
            random = (int)(Math.random() * list.size());
            guess = list.get(random);
            //            System.out.println("Guess: " + guess);
            return guess;
        }
        return -1;
    }
    
    /**
     @return returns the total number of guesses it took to correctly guess
     user's number.
     */
    public int totalNumGuesses() {
        return countGuesses;
    }
    
    /**
     updates the ArrayList by removing any numbers that can't be the user's
     secret number based on the number of matches reported by user and keeps
     track of the number of guesses
     @param nmatches, number of matching digits in guess, reported by user.
     */
    public void updateMyGuess(int nmatches) {
        //B/c the main method "continue's" the loop if the input is invalid, it
        //doesn't even run the updateMyGuess() method.
        countGuesses++;
        
        sizeOfListCheck2= list.size();
        //        System.out.println("Size of List (updateMyGuess())" + sizeOfListCheck2);
        
        //Separates the guess into its digits
        int fifthDigit = guess % 10;
        int fourthDigit = (guess / 10) % 10;
        int thirdDigit = ((guess / 10) / 10) % 10;
        int secondDigit = (((guess / 10) / 10) / 10) % 10;
        int firstDigit = ((((guess / 10) / 10) / 10) / 10) % 10;
        
        for(int i = 0; i < list.size(); i++) {
            //Gets number at current index
            int numberToRemove = list.get(i);
            
            //            System.out.println("Size: \t\t" + list.size());
            //            System.out.println("Guess: \t\t" + guess);
            //            System.out.println("Compare to: \t" + numberToRemove);
            //            System.out.println("nmatches: \t" + nmatches);
            //            System.out.println("Number of Guesses: " + countGuesses);
            
            //Gets digits of the number in ArrayList
            int fifthDigitCheck = numberToRemove % 10;
            int fourthDigitCheck = (numberToRemove / 10) % 10;
            int thirdDigitCheck = ((numberToRemove / 10) / 10) % 10;
            int secondDigitCheck = (((numberToRemove / 10) / 10) / 10) % 10;
            int firstDigitCheck = ((((numberToRemove / 10) / 10) / 10) / 10) % 10;
            
            int numberOfMatches = countMatches(firstDigitCheck,
                                               secondDigitCheck,
                                               thirdDigitCheck,
                                               fourthDigitCheck,
                                               fifthDigitCheck);
            
            if(nmatches == 0) {
                if(fifthDigitCheck == fifthDigit) {
                    //                    System.out.println("Removed: \t\t" + numberToRemove);
                    list.remove(i);
                    i--;
                    continue;
                }
                if(fourthDigitCheck == fourthDigit) {
                    //                    System.out.println("Removed: \t\t" + numberToRemove);
                    list.remove(i);
                    //i-- here and in the other statements b/c the .remove()
                    //method shifts the indexes down one so it would skip
                    //numbers if i wasn't decrimented after removing a number.
                    i--;
                    continue;
                }
                if(thirdDigitCheck == thirdDigit) {
                    //                    System.out.println("Removed: \t\t" + numberToRemove);
                    list.remove(i);
                    i--;
                    continue;
                }
                if(secondDigitCheck == secondDigit) {
                    //                    System.out.println("Removed: \t\t" + numberToRemove);
                    list.remove(i);
                    i--;
                    continue;
                }
                if(firstDigitCheck == firstDigit) {
                    //                    System.out.println("Removed: \t\t" + numberToRemove);
                    list.remove(i);
                    i--;
                    continue;
                }
                if(numberToRemove == guess) {
                    //                    System.out.println("Removed: \t\t" + numberToRemove);
                    list.remove(i);
                    i--;
                    continue;
                }
                
            } else if (nmatches == 1) {
                if(numberToRemove == guess) {
                    //                    System.out.println("Removed: \t\t" + numberToRemove);
                    list.remove(i);
                    i--;
                    continue;
                }
                if(numberOfMatches != 1) {
                    //                    System.out.println("Removed: \t\t" + numberToRemove);
                    list.remove(i);
                    i--;
                    continue;
                }
                
            } else if (nmatches == 2) {
                if(numberToRemove == guess) {
                    //                    System.out.println("Removed: \t\t" + numberToRemove);
                    list.remove(i);
                    i--;
                    continue;
                }
                if(numberOfMatches != 2) {
                    //                    System.out.println("Removed: \t\t" + numberToRemove);
                    list.remove(i);
                    i--;
                    continue;
                }
            } else if (nmatches == 3) {
                if(numberToRemove == guess) {
                    //                    System.out.println("Removed: \t\t" + numberToRemove);
                    list.remove(i);
                    i--;
                    continue;
                }
                if(numberOfMatches != 3) {
                    //                    System.out.println("Removed: \t\t" + numberToRemove);
                    list.remove(i);
                    i--;
                    continue;
                }
            } else if (nmatches == 4) {
                if(numberToRemove == guess) {
                    //                    System.out.println("Removed: \t\t" + numberToRemove);
                    list.remove(i);
                    i--;
                    continue;
                }
                if(numberOfMatches != 4) {
                    //                    System.out.println("Removed: \t\t" + numberToRemove);
                    list.remove(i);
                    i--;
                    continue;
                }
            }
        }
    }
    // fill in code here (optional)
    // feel free to add more methods as needed
    
    /**
     finds the number of digits that match the guess
     @param first, first digit of the number to be checked
     @param second, second digit of the number to be checked
     @param third, third digit of the number to be checked
     @param fourth, fourth digit of the number to be checked
     @return returns the number of total matches
     */
    private int countMatches(int first, int second, int third, int fourth, int fifth) {
        int fifthDigit = guess % 10;
        int fourthDigit = (guess / 10) % 10;
        int thirdDigit = ((guess / 10) / 10) % 10;
        int secondDigit = (((guess / 10) / 10) / 10) % 10;
        int firstDigit = ((((guess / 10) / 10) / 10) / 10) % 10;
        int numberOfMatches = 0;
        if(fifth == fifthDigit) {
            numberOfMatches++;
        }
        if(fourth == fourthDigit) {
            numberOfMatches++;
        }
        if(third == thirdDigit) {
            numberOfMatches++;
        }
        if(second == secondDigit) {
            numberOfMatches++;
        }
        if(first == firstDigit) {
            numberOfMatches++;
        }
        return numberOfMatches;
    }
    
    // you shouldn't need to change the main function
    public static void main(String[] args) {
        
        GuessingGame2 gamer = new GuessingGame2( );
        
        JOptionPane.showMessageDialog(null, "Think of a number between 10000 and 99999.\n Click OK when you are ready...", "Let's play a game", JOptionPane.INFORMATION_MESSAGE);
        int numMatches = 0;
        int myguess = 0;
        
        do {
            myguess = gamer.myGuessIs();
            if (myguess == -1) {
                JOptionPane.showMessageDialog(null, "I don't think your number exists.\n I could be wrong though...", "Mistake", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            String userInput = JOptionPane.showInputDialog("I guess your number is " + myguess + ". How many digits did I guess correctly?");
            // quit if the user input nothing (such as pressed ESC)
            if (userInput == null)
                System.exit(0);
            // parse user input, pop up a warning message if the input is invalid
            try {
                numMatches = Integer.parseInt(userInput.trim());
            }
            catch(Exception exception) {
                JOptionPane.showMessageDialog(null, "Your input is invalid. Please enter a number between 0 and 5", "Warning", JOptionPane.WARNING_MESSAGE);
                continue;
            }
            // the number of matches must be between 0 and 4
            if (numMatches < 0 || numMatches > 5) {
                JOptionPane.showMessageDialog(null, "Your input is invalid. Please enter a number between 0 and 5", "Warning", JOptionPane.WARNING_MESSAGE);
                continue;
            }
            if (numMatches == 5)
                break;
            // update based on user input
            gamer.updateMyGuess(numMatches);
            
        } while (true);
        
        // the game ends when the user says all 5 digits are correct
        System.out.println("Aha, I got it, your number is " + myguess + ".");
        System.out.println("I did it in " + gamer.totalNumGuesses() + " turns.");
    }
}