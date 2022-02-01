package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int MAX_ROUNDS = 3;

    public static void startGame(String gameRules, String[][] questionAndAnswer) {
        Cli.printGreet();
        System.out.println(gameRules);

        Scanner scanner = new Scanner(System.in);
        String playerAnswer;

        String playerName = Cli.getName();

        for (int i = 0; i < MAX_ROUNDS; i++) {
            System.out.println("Question: " + questionAndAnswer[i][0]);
            System.out.print("Your answer: ");
            playerAnswer = scanner.next();

            if (questionAndAnswer[i][1].equals(playerAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.print("'" + playerAnswer + "' is wrong answer ;(. Correct answer was '"
                        + questionAndAnswer[i][1] + "'.\n"
                        + "Let's try again, " + playerName + "!\n");
                return;
            }
        }

        System.out.println("Congratulations, " + playerName + "!");
    }

}
