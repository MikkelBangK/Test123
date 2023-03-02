package pigsgame;

import java.lang.management.BufferPoolMXBean;
import java.util.Scanner;

import static onedie.RollOneDie.rollDie;

public class Pigs {

    private static final Scanner scanner = new Scanner(System.in);


    private static String spillernavn1 = "";

    private static String spillernavn2 = "";

    private static int spillerPoints1 = 0;
    private static int spillerPoints2 = 0;

    private static double spiller1Rolls = 0;
    private static double spiller2Rolls = 0;
    private static double antalSpilledeRunder = 0;

    private static int WP = 100;


    public static void main(String[] args) {
        System.out.println("Welcome to the game of Pigs");
        printRules();
        System.out.println();

        PlayPigs();

        System.out.println();
        printStatistics();
        System.out.println("Thank you for playing Pigs");
    }

    private static void printStatistics() {
        System.out.println("Gennemsnitlige slag per runde for spiller 1 og spiller 2");
        System.out.println("Antal spillede runder " + antalSpilledeRunder);
        System.out.println("spiller 1 " + spiller1Rolls/antalSpilledeRunder);
        System.out.println("spiller 2 " + spiller2Rolls/antalSpilledeRunder);
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Pigs:");
        System.out.println("Første spiller kaster en terning, ");
        System.out.println("indtil han enten kaster 1, eller beslutter sig for at stoppe. Hvis han slår en 1’er, får han ingen point i denne runde.");
        System.out.println(" Hvis han beslutter sig for at stoppe, inden har slår en 1’er,");
        System.out.println("lægges summen af alle hans kast i denne runde sammen med hans samlede antal point, og turen går videre til næste spiller. ");
        System.out.println("Derefter skiftes spillerne til at kaste. Den første spiller, der samlet når 100 point, har vundet.\n");
        System.out.println("=====================================================");
    }

    public static void pickNavne() {
        System.out.print("vælg navn for spiller 1: ");
        spillernavn1 = scanner.next();
        System.out.print("vælg navn for spiller 2: ");
        spillernavn2 = scanner.next();
    }

    public static void pointsForAtVinde() {
        System.out.print(" Du skal have så mange points for at vinde: ");
        int maxPoints = scanner.nextInt();
        scanner.nextLine();
        WP = (maxPoints > 0) ? maxPoints : WP;
    }

    private static void PlayPigs() {
        pickNavne();
        pointsForAtVinde();
        System.out.println();
        System.out.println("Start dit spil: ");
        scanner.nextLine();
        boolean hvisTur = true;
        boolean vinderFundet = false;
        while (!vinderFundet) {
            if (hvisTur) {
                spillerPoints1 += rollForPoint(spillernavn1, spillerPoints1);
                antalSpilledeRunder++;
                if (spillerPoints1 >= WP) {
                    System.out.println("du har vundet mf!");
                    vinderFundet = true;
                }
            } else {
                spillerPoints2 += rollForPoint(spillernavn2, spillerPoints2);
                if (spillerPoints2 >= WP) {
                    System.out.println("du har vundet mf!");
                    vinderFundet = true;
                }
            } hvisTur = !hvisTur;
        }
    }
            public static int rollDie () {
                int die1 = (int) (Math.random() * 6 + 1);
                return die1;
            }

            private static int rollForPoint (String name,int point){
                System.out.println();
                System.out.println(name + " tur til at spille");
                System.out.println("vil du spille eller give turen videre? ");
                String answer = scanner.nextLine();
                int pointsFraDenneRunde = 0;
                int muligePoint = 0;
                int die1;
                while (!answer.equalsIgnoreCase("Skip")) {
                    die1 = rollDie();
                    if(name == spillernavn1) {
                        spiller1Rolls++;
                    }
                    else if (name == spillernavn2) {
                        spiller2Rolls++;
                    }
                    pointsFraDenneRunde += die1;
                    muligePoint = pointsFraDenneRunde + point;
                    System.out.println(die1);
                    System.out.println("point fra denne runde " + pointsFraDenneRunde);
                    System.out.println("du har så så mange points i alt " + muligePoint);
                    if (die1 == 1) {
                        return 0;
                    } else if (point + pointsFraDenneRunde >= WP) {
                        return pointsFraDenneRunde;

                    } else {
                        answer = scanner.nextLine();
                    }
                }
                return pointsFraDenneRunde;
            }
        }





