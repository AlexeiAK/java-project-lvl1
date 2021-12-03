package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Randomizer;

import java.math.BigInteger;

public class GCD {
    static final String GAME_RULES = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        String[] question = new String[Engine.MAX_ROUNDS];
        String[] answer = new String[Engine.MAX_ROUNDS];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            String[] randomExpressionWithAnswer = getGcdWithAnswer();

            question[i] = randomExpressionWithAnswer[0];
            answer[i] = randomExpressionWithAnswer[1];
        }

        Engine.startGame(GAME_RULES, question, answer);
    }

    public static String[] getGcdWithAnswer() {
        BigInteger number1 = new BigInteger(Integer.toString(Randomizer.getNumberFromFinalRange()));
        BigInteger number2 = new BigInteger(Integer.toString(Randomizer.getNumberFromFinalRange()));
        BigInteger gcd = number1.gcd(number2);

        String[] gcdWithAnswer = new String[2];
        gcdWithAnswer[0] = number1 + " " + " " + number2;
        gcdWithAnswer[1] = gcd.toString();

        return gcdWithAnswer;
    }

}
