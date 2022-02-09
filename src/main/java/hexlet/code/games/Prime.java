package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][1];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int randomNumber = Utils.getRandom();

            questionsAndAnswers[i] = new String[]{
                Integer.toString(randomNumber),
                isNumberPrime(randomNumber) ? "yes" : "no"
            };
        }

        Engine.startGame(GAME_RULES, questionsAndAnswers);
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
