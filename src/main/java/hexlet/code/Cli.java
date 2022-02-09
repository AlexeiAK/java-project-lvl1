package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void printGreet() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nWelcome to the Brain Games!\n"
                + "May I have your name? ");
        String playerName = scanner.nextLine();

        System.out.println("Hello, " + playerName + "!");
    }
}
