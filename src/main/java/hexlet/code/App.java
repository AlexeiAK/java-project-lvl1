package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class App {
    public static void main(String[] args) {
        printGamesList();
        System.out.print("Your choice: ");
        String playerChoice = Cli.readAndGetLine();

        switch (playerChoice) {
            case "1" -> Greet.getGreet();
            case "2" -> Even.startGame();
            case "3" -> Calc.startGame();
            case "4" -> GCD.startGame();
            case "5" -> Progression.startGame();
            case "6" -> Prime.startGame();
            case "0" -> System.out.println("Goodbye!");
            default -> System.out.println("Incorrect entry. Let's try again!");
        }
    }

    static void printGamesList() {
        System.out.print("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "4 - GCD\n"
                + "5 - Progression\n"
                + "6 - Prime\n"
                + "0 - Exit\n"
        );
    }
}
