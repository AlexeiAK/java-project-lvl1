package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String player1Name; // to be able to call player name wherever
    public static String getName() {
        return player1Name;
    }

    public static void printGreet() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nWelcome to the Brain Games!\n"
                + "May I have your name? ");

        player1Name = scanner.nextLine();

        System.out.println("Hello, " + player1Name + "!");
    }
}
