package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.math.BigInteger;

public class GCD {
    static final String GAME_RULES = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][1];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            BigInteger number1 = BigInteger.valueOf(Utils.getRandom());
            BigInteger number2 = BigInteger.valueOf(Utils.getRandom());
            BigInteger gcd = number1.gcd(number2);

            questionsAndAnswers[i] = new String[]{
                number1 + " " + number2,
                gcd.toString()
            };
        }

        Engine.startGame(GAME_RULES, questionsAndAnswers);
    }
}
