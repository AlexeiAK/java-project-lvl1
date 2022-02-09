package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int MAX_ROUNDS = 3;

    public static void startGame(String gameRules, String[][] questionsAndAnswers) {
        Scanner nameScanner = new Scanner(System.in);

        System.out.print("\nWelcome to the Brain Games!\n"
                + "May I have your name? ");
        String playerName = nameScanner.nextLine();

        System.out.println("Hello, " + playerName + "!");
        System.out.println(gameRules);

        Scanner answerScanner = new Scanner(System.in);

        for (int i = 0; i < MAX_ROUNDS; i++) {
            System.out.println("Question: " + questionsAndAnswers[i][0]);
            System.out.print("Your answer: ");
            String playerAnswer = answerScanner.next();

            if (questionsAndAnswers[i][1].equals(playerAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.print("'" + playerAnswer + "' is wrong answer ;(. Correct answer was '"
                        + questionsAndAnswers[i][1] + "'.\n"
                        + "Let's try again, " + playerName + "!\n");
                return;
            }
        }

        System.out.println("Congratulations, " + playerName + "!");
    }

}
