package twodice;

import java.util.Arrays;
import java.util.Scanner;

public class RollTwoDice {

    private static int rollCount = 0;
    private static int sum = 0;

    private static int SNOE = 0;

    private static int LSOE = 0;

    private static int[] frequence = new int[6];


    private static void sameNumberOfEyes(int[] face){
       if (face[0] == face[1]){
           SNOE++;
       }
    }

    private static void numberOfEyes(int[] face){
        frequence[face[0]-1] ++;
        frequence[face[1] -1] ++;
    }

    private static void largetSumOfEyes(int[] face){
        if (face[0] + face[1] > LSOE) {
            LSOE = face[0] + face[1];
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the game of RollTwoDice");
        printRules();
        System.out.println();

        playTwoDie();

        System.out.println();
        System.out.println("Thank you for playing RollTwoDice");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of RollTwoDice:");
        System.out.println("The player throws two dice as long as he/she wants.");
        System.out.println("=====================================================");
    }

    private static void playTwoDie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll? ('no' stops) ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int[] face = rollDice();
            System.out.println("Eyes: " + face[0] + " and " + face[1]);
            sameNumberOfEyes(face);
            largetSumOfEyes(face);
            numberOfEyes(face);
            System.out.println();

            updateStatistics(face);

            System.out.print("Roll? ('no' stops) ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    public static int[] rollDice() {
        int[] values = new int[2];
        double die1 = (Math.random() * 6 + 1);
        double die2 = (Math.random() * 6 + 1);
        values[0] = (int) die1;
        values[1] = (int) die2;
        return values;
    }

    private static void updateStatistics(int[] face) {
        sum += face[0] + face[1];


        rollCount++;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.println("Sum of Eyes: " + sum);
        System.out.println("antal gange det samme antal øjne er slået: " + SNOE);
        System.out.println("Største sum af øjne: " + LSOE);
        System.out.println("Antal øjne for hver: " + Arrays.toString(frequence));
        for (int i = 0; i < frequence.length; i++){
            System.out.println("antal " + (i + 1) + "'ere: " + frequence[i]);

        }
        System.out.printf("%17s %4d\n", "Roll count:",rollCount);
    }
}
