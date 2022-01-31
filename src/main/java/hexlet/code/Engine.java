package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int MAX_ROUNDS = 3;

    public static void startGame(String gameRules, String[] question, String[] answer) {
        Cli.printGreet();
        System.out.println(gameRules);

        Scanner scanner = new Scanner(System.in);
        String playerAnswer;

        String playerName = Cli.getName();

        int correctAnswersCounter = 0;

        for (int i = 0; i < MAX_ROUNDS; i++) {
            System.out.println("Question: " + question[i]);
            System.out.print("Your answer: ");
            playerAnswer = scanner.next();

            if (answer[i].equals(playerAnswer)) {
                System.out.println("Correct!");
                correctAnswersCounter++;
            } else {
                System.out.print("'" + playerAnswer + "' is wrong answer ;(. Correct answer was '"
                        + answer[i] + "'.\n"
                        + "Let's try again, " + playerName + "!\n");
                return;
            }
        }

        if (correctAnswersCounter == MAX_ROUNDS) {
            System.out.println("Congratulations, " + playerName + "!");
        }

    }

}
