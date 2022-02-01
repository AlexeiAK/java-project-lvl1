package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        String[][] questionAndAnswer = new String[Engine.MAX_ROUNDS][1];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            questionAndAnswer[i] = getNumberWithAnswer();
        }

        Engine.startGame(GAME_RULES, questionAndAnswer);
    }

    public static String[] getNumberWithAnswer() {
        int randomNumber = Utils.getNumberFromFinalRange();

        String question = Integer.toString(randomNumber);
        String answer = isNumberPrime(randomNumber) ? "yes" : "no";

        String[] numberWithAnswer = new String[2];
        numberWithAnswer[0] = question;
        numberWithAnswer[1] = answer;

        return numberWithAnswer;
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
