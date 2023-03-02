package crapsgame;

import java.util.Arrays;
import java.util.Scanner;

public class Craps {

    private static int rollCount = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Craps");
        printRules();
        System.out.println();

        PlayCraps();

        System.out.println();
        System.out.println("Thank you for playing Craps");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Craps:");
        System.out.println("Det første kast kaldes ‘come out roll’.");
        System.out.println(" Spilleren vinder med det samme, hvis det første kast er 7 eller 11, og taber med det samme");
        System.out.println(" hvis det første kast er 2, 3 eller 12. Hvis spillerens første kast er 4, 5, 6, 8, 9 eller 10, etableres dette tal som spillerens ‘point’");
        System.out.println(" Spilleren bliver derefter ved med at kaste, indtil han enten kaster sit ‘point’ igen eller kaster 7.");
        System.out.println(" Kaster han 7, har han tabt. Kaster han sit ’point’, har han vundet.");
        System.out.println("=====================================================");
    }

    private static void PlayCraps() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll?");
        String answer = scanner.nextLine();
        int rollpoint = rollDice();
        int sum = rollpoint;
        System.out.println("du har slået: " + sum);
        if (sum == 7 || sum == 11) {
            System.out.println("you win");
        } else if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("you lose");
        } else {
            System.out.println("Nu har du hverken vundet eller tabt, for at gå videre, skal du slå: " + sum + " for at vinde");
            int point = sum;
            rollForPoint(point);
        }

        System.out.println();


        answer = scanner.nextLine();

        scanner.close();
    }


    public static int rollDice() {
        int die1 = (int) (Math.random() * 6 + 1);
        int die2 = (int) (Math.random() * 6 + 1);
        int values = die1 + die2;
        return values;
    }

    private static void updateStatistics(int[] face) {
        rollCount++;
    }

    private static boolean rollForPoint(int point) {
        boolean active = true;
        boolean result = false;
        Scanner scanner = new Scanner(System.in);
        while (active) {
            String answer = scanner.nextLine();
            int rollpoint = rollDice();
            System.out.println("your roll is: " + rollpoint);
            int sum = (rollpoint);
            if (rollpoint == 7) {
                System.out.println("du har tabt");
                active = false;
            } else if (rollpoint == point) {
                System.out.println("Du har vundet");
                active = false;
                result = true;
            }
        }
        return result;
    }
}
