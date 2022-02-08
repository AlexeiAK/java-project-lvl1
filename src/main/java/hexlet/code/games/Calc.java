package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;

public class Calc {
    static final String GAME_RULES = "What is the result of the expression?";

    static final int NUMBER_OF_TYPES_MATH_OPERATIONS = 3;

    static final int MAX_OF_RANDOM_RANGE = 1;
    static final int MIN_OF_RANDOM_RANGE = 10;

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][1];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int operandA = Utils.getRandomInRange(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);
            int operandB = Utils.getRandomInRange(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);
            String operator = getRandomOperationSign();

            questionsAndAnswers[i] = getRandomQuestionAndAnswer(operandA, operandB, operator);
        }

        Engine.startGame(GAME_RULES, questionsAndAnswers);
    }

    public static String[] getRandomQuestionAndAnswer(int operandA, int operandB, String operator) {
        String a = Integer.toString(operandA);
        String b = Integer.toString(operandB);

        String question = a + " " + operator + " " + b;

        String answer = switch (operator) {
            case "+" -> Integer.toString(operandA + operandB);
            case "-" -> Integer.toString(operandA - operandB);
            case "*" -> Integer.toString(operandA * operandB);
            default -> "Wrong operator!";
        };

        return Utils.pairOf(question, answer);
    }

    public static String getRandomOperationSign() {
        String[] totalOperations = {"+", "-", "*"};
        Random randomOperation = new Random();

        return totalOperations[randomOperation.nextInt(NUMBER_OF_TYPES_MATH_OPERATIONS)];
    }
}
