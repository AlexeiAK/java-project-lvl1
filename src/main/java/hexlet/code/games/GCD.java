package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.math.BigInteger;

public class GCD {
    static final String GAME_RULES = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        String[] question = new String[Engine.MAX_ROUNDS];
        String[] answer = new String[Engine.MAX_ROUNDS];

        String[][] questionAndAnswer = new String[Engine.MAX_ROUNDS][1];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            String[] randomExpressionWithAnswer = getGcdWithAnswer();

            question[i] = randomExpressionWithAnswer[0];
            answer[i] = randomExpressionWithAnswer[1];
        }

        Engine.startGame(GAME_RULES, questionAndAnswer);
    }

    public static String[] getGcdWithAnswer() {
        BigInteger number1 = new BigInteger(Integer.toString(Utils.getNumberFromFinalRange()));
        BigInteger number2 = new BigInteger(Integer.toString(Utils.getNumberFromFinalRange()));
        BigInteger gcd = number1.gcd(number2);

        String[] gcdWithAnswer = new String[2];
        gcdWithAnswer[0] = number1 + " " + number2;
        gcdWithAnswer[1] = gcd.toString();

        return gcdWithAnswer;
    }

}
