package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][1];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int randomNumber = Utils.getNumberFromFinalRange();
            questionsAndAnswers[i] = getNumberWithAnswer(randomNumber);
        }

        Engine.startGame(GAME_RULES, questionsAndAnswers);
    }

    public static String[] getNumberWithAnswer(int randomNumber) {
        String question = Integer.toString(randomNumber);
        String answer = isNumberPrime(randomNumber) ? "yes" : "no";

        return Utils.formQuestionAndAnswer(question, answer);
    }

    public static boolean isNumberPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
