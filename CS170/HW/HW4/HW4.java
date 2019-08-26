//Joseph Barbati - jdbarba
//Section 004
//Worked by myself
//Due Oct 29th at 9pm
import java.util.Scanner;
public class HW4 {
    //global Scanner variable
    public static Scanner input = new Scanner(System.in);
    //global points variable used to keep track of computer's points
    public static int compPoints = 0;
    //global points variable used to keep track of user's points
    public static int playerPoints = 0;
    /**
     * Method determines the what side of die is rolled
     * @return returns the number on the would-be face-up side of the would-be die
    */
    public static int roll() {
        double d = 6 * Math.random();
        return (int)d + 1;
    }
    /**
     * Method is the loop required in the holdAt20 method
     * @param point is the number of points at which the computer holds
     * @return returns the points earned in one turn
    */
    public static int holdAt20Loop(int holdAt) {
        int points = 0;
        while (points < holdAt) {
            int outcome = roll();
            System.out.println("Roll: " + outcome);
            if (outcome == 1) {
                points = 0;
                break;
            } else if (outcome == 2) {
                points += 2;
                continue;
            } else if (outcome == 3) {
                points += 3;
                continue;
            } else if (outcome == 4) {
                points += 4;
                continue;
            } else if (outcome == 5) {
                points += 5;
                continue;
            } else if (outcome == 6) {
                points += 6;
                continue;
            }
        }
        System.out.println("Turn Total: " + points);
        HW4.compPoints += points;
        return points;
    }
    /**
     * Method is computer player for Game of Pig
     * @param prevPoints takes the points from the previous turn
    */
    public static int holdAt20(int prevPoints) {
        int points = 0;
        if (prevPoints < 85) {
            points = holdAt20Loop(20);
        } else if (prevPoints < 90) {
            points = holdAt20Loop(15);
        } else if (prevPoints < 95) {
            points = holdAt20Loop(10);
        } else if (prevPoints < 100) {
            points = holdAt20Loop(5);
        }
        return points;
    }
    /**
     * Method is user player for Game of Pig, allows player to keep going or hold
     * after each turn.
     * @return returns the points earned in one turn
    */
    public static int holdUI() {
        int points = 0;
        while (playerPoints <= 100) {
            int outcome = roll();
            System.out.println("Roll: " + outcome);
            if (outcome == 1) {
                points = 0;
                break;
            } else if (outcome == 2) {
                points += 2;
                System.out.print("Turn Total: " + points);
                System.out.print("\t(1 to Roll, 2 to Hold): ");
                int rollHold = input.nextInt();
                if (rollHold == 1) {
                    continue;
                } else {
                    break;
                }
            } else if (outcome == 3) {
                points += 3;
                System.out.print("Turn Total: " + points);
                System.out.print("\t(1 to Roll, 2 to Hold): ");
                int rollHold = input.nextInt();
                if (rollHold == 1) {
                    continue;
                } else {
                    break;
                }
            } else if (outcome == 4) {
                points += 4;
                System.out.print("Turn Total: " + points);
                System.out.print("\t(1 to Roll, 2 to Hold): ");
                int rollHold = input.nextInt();
                if (rollHold == 1) {
                    continue;
                } else {
                    break;
                }
            } else if (outcome == 5) {
                points += 5;
                System.out.print("Turn Total: " + points);
                System.out.print("\t(1 to Roll, 2 to Hold): ");
                int rollHold = input.nextInt();
                if (rollHold == 1) {
                    continue;
                } else {
                    break;
                }
            } else if (outcome == 6) {
                points += 6;
                System.out.print("Turn Total: " + points);
                System.out.print("\t(1 to Roll, 2 to Hold): ");
                int rollHold = input.nextInt();
                if (rollHold == 1) {
                    continue;
                } else {
                    break;
                }
            }
        }
        System.out.print("Turn Total: ");
        HW4.playerPoints += points;
        return points;
    }
    /**
     * Method plays the game, chooses who goes first, and alternates turns
     * @param playerName String that takes user's name
     */
    public static void playGame(String playerName) {
        int decidePlayer = (int)(2 * Math.random()) + 1;
        System.out.println(playerName + ", you will be Player " + decidePlayer);
        if (decidePlayer == 1) {
            while (compPoints < 100 || playerPoints < 100) {
                System.out.println("Player 1 score: " + playerPoints);
                System.out.println("Player 2 score: " + compPoints);
                System.out.println("It is player 1's turn.");
                System.out.println(holdUI());
                System.out.println("New Score: " + playerPoints);
                if (playerPoints >= 100) {
                    System.out.print("Game over!!! " + playerName + " wins! ");
                    System.out.print("The score was " + playerPoints + "-");
                    System.out.println(compPoints);
                    break;
                }
                System.out.println("It is player 2's turn.");
                holdAt20(compPoints);
                System.out.println("New Score: " + compPoints);
                if (compPoints >= 100) {
                    System.out.print("Game over!!! Player 2 wins! ");
                    System.out.print("The score was " + compPoints + "-");
                    System.out.println(playerPoints);
                    break;
                }
            }
            
        } else {
            while (compPoints < 100 && playerPoints < 100) {
                System.out.println("Player 1 score: " + compPoints);
                System.out.println("Player 2 score: " + playerPoints);
                System.out.println("It is player 1's turn.");
                holdAt20(compPoints);
                System.out.println("New Score: " + compPoints);
                if (compPoints >= 100) {
                    System.out.print("Game over!!! Player 1 wins! ");
                    System.out.print("The score was " + compPoints + "-");
                    System.out.println(playerPoints);
                    break;
                }
                System.out.println("It is player 2's turn.");
                System.out.println(holdUI());
                System.out.println("New Score: " + playerPoints);
                if (playerPoints >= 100) {
                    System.out.print("Game over!!! " + playerName + " wins! ");
                    System.out.print("The score was " + playerPoints + "-");
                    System.out.println(compPoints);
                    break;
                }
            }

        }
    }
    public static void main(String[] args) {
        System.out.println("The Game of Pig");
        //I add-libbed this, just a little warning for player to hold while
        //he or she is ahead.
        System.out.println("Don't fly too close to the sun!");
        System.out.print("Please enter your name: ");
        String userName = input.next();
        playGame(userName);
    }
}