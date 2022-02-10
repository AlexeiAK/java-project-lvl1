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

        int roundsCounter = 0;
        Scanner answerScanner = new Scanner(System.in);

        for (String[] questionAndAnswer : questionsAndAnswers) {
            String question = questionAndAnswer[0];
            String answer = questionAndAnswer[1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String playerAnswer = answerScanner.next();

            if (answer.equals(playerAnswer)) {
                System.out.println("Correct!");
                roundsCounter++;
            } else {
                System.out.print("'" + playerAnswer + "' is wrong answer ;(. Correct answer was '"
                        + answer + "'.\n"
                        + "Let's try again, " + playerName + "!\n");
                return;
            }
        }

        if (roundsCounter == MAX_ROUNDS) {
            System.out.println("Congratulations, " + playerName + "!");
        }
    }
}
