//Joseph Barbati - NETID: jdbarba - Section: 004
//Worked by myself
//Consulted API documentation for while-loop syntax

import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        //The following should print the number of totem heads the user inputs
        //uncomment to use if you wish
//        System.out.print("ENTER THE TOTAL NUMBER OF TOTEM HEADS YOU WANT TO SEE: ");
//        Scanner input = new Scanner(System.in);
//        int inputInt = input.nextInt();
//        int y = 1;
//        while (y <= inputInt) {
//           totemHead();
//              y += 1;
//        }
//        //This is just the standartd 3 headed totem pole
//        System.out.println("Calling totemPole() method:");
        totemPole();
    }
    //Normal hair
    public static String hair1() {
        return "|||||||||||||||";
    }
    //Spikey hair
    public static String hair2() {
        return "\\\\\\\\\\\\\\////////";
    }
    //Eye looking up
    public static String eyeOne() {
        System.out.println("");
        System.out.println("|  ___   ___  |");
        System.out.println("| |  *| |  *| |");
        System.out.println("| |   | |   | |");
        System.out.println("| |___| |___| |");
        return ""; 
    }
    //Eye looking to side
    public static String eyeTwo() {
        System.out.println("");
        System.out.println("|  ___   ___  |");
        System.out.println("| |   | |   | |");
        System.out.println("| |*  | |*  | |");
        System.out.println("| |___| |___| |");
        return "";
    }
    //Surprised mouth
    public static String mouthSurprised() {
        System.out.println("|    ____     |");
        System.out.println("|   /    \\    |");
        System.out.println("|   |    |    |");
        System.out.println("|   \\____/    |");
        System.out.println("|             |");
        return "";
    }
    //Scared mouth
    public static String mouthScared() {
        System.out.println("|     ____    |");
        System.out.println("|    /    \\   |");
        System.out.println("|   / ____ \\  |");
        System.out.println("|   |/    \\|  |");
        return "";
    }
    //Happy mouth
    public static String mouthHappy() {
        System.out.println("|             |");
        System.out.println("|  |\\____/|   |");
        System.out.println("|  \\      /   |");
        System.out.println("|   \\____/    |");
        return "";
    }
    //Normal chin
    public static String chinNormal() {
        return "|_____________| ";
    }
    //Hairy chin
    public static String chinHairy() {
        System.out.println("|_____________|");
        return "//////////////";
    }
    //Nose
    public static String nose() {
        System.out.println("|     /\\      |");
        return "";
    }
    
    //Choosing Head Parts
    //Choosing the Hair
    public static String totemHair() {
        double r = Math.random();
        if (r >= 0.50) {
            return hair1();
        } else {
            return hair2();
        }
    }
    //Choosing the Eyes
    public static String totemEye() {
        double r = Math.random();
        if (r >= 0.50) {
            return eyeOne();
        } else {
            return eyeTwo();
        }
    }
    //Choosing the Mouth
    public static String totemMouth() {
        double r = Math.random();
        r *= 3;
        r = (int)r;
        if (r == 0) {
            return mouthSurprised();
        } else if (r == 1) {
            return mouthScared();
        } else {
            return mouthHappy();
        }
    }
    //Choosing the Chin
    public static String totemChin() {
        double r = Math.random();
        if (r >= 0.50) {
            return chinNormal();
        } else {
            return chinHairy();
        }
    }
    //Choosing the Nose
    public static String totemNose() {
        double r = Math.random();
        if (r >= 0.50) {
            return nose();
        } else {
            return "";
        }
    }

    //Printing the whole head at once
    public static void totemHead() {
        System.out.print(totemHair());
        System.out.print(totemEye());
        System.out.print(totemNose());
        System.out.print(totemMouth());
        System.out.println(totemChin());
    }
    //Prints 3 heads at once
    public static void totemPole() {
        totemHead();
        totemHead();
        totemHead();
    }
}