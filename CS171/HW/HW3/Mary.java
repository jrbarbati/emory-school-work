/*
 THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
 A TUTOR OR CODE WRITTEN BY OTHER STUDENTS.  Joseph Barbati
 */


//Due Feb 19, 2016


/* I started by trying to solve using ArrayLists and figured out a formula close
 to what you see here.  Then I decided to try and figure out formula, so I tried
 to solve recursivley based on the formula I had, then using the recursion, I 
 came up with this loop and formula here. */


import java.util.Scanner;

public class Mary {

    static Scanner input = new Scanner(System.in);
    
    /**
     * calculates where Mary should stand to be saved if there are N people and 
     * every Kth person is fired (last person is not fired)
     * @param N, total number of people
     * @param K, number of people to count then firing Kth person
     * @return returns the position number where Mary should stand to keep her job
     */
    public static int mary(int N, int K) {
        if(N == 1) return 1;

        int position = 1;
        for(int i = 2; i <= N; i++) {
            position = (position + (K - 1)) % i + 1;
        }
        return position;
    }
    
    public static void main(String[] args) {
        System.out.print("Enter an integer for N: ");
        int N = input.nextInt();
        System.out.print("Enter an integer for K: ");
        int K = input.nextInt();

        System.out.println("Calling mary(N=" + N + ", K=" + K + ")");

        long start = System.currentTimeMillis();
        System.out.println("Mary should stand at position: " + mary(N, K) + " to not be fired.");
        long end = System.currentTimeMillis();

        System.out.println("Total Time: " + (end - start) + " millis");
    }
}