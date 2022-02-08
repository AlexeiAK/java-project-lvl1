package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.math.BigInteger;

public class GCD {
    static final String GAME_RULES = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][1];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            BigInteger number1 = new BigInteger(Integer.toString(Utils.getRandom()));
            BigInteger number2 = new BigInteger(Integer.toString(Utils.getRandom()));

            questionsAndAnswers[i] = getGcdWithAnswer(number1, number2);
        }

        Engine.startGame(GAME_RULES, questionsAndAnswers);
    }

    public static String[] getGcdWithAnswer(BigInteger number1, BigInteger number2) {
        BigInteger gcd = number1.gcd(number2);

        String question = number1 + " " + number2;
        String answer = gcd.toString();

        return Utils.pairOf(question, answer);
    }
}
