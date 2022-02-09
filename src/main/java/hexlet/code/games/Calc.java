package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    static final String GAME_RULES = "What is the result of the expression?";

    static final int MAX_OF_RANDOM_RANGE = 1;
    static final int MIN_OF_RANDOM_RANGE = 10;

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][1];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int operandA = Utils.getRandomInRange(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);
            int operandB = Utils.getRandomInRange(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);
            String operator = getRandomOperationSign();

            questionsAndAnswers[i] = new String[]{
                operandA + " " + operator + " " + operandB,
                calculate(operator, operandA, operandB)
            };
        }

        Engine.startGame(GAME_RULES, questionsAndAnswers);
    }

    public static String calculate(String operator, int operandA, int operandB) {
        return switch (operator) {
            case "+" -> Integer.toString(operandA + operandB);
            case "-" -> Integer.toString(operandA - operandB);
            case "*" -> Integer.toString(operandA * operandB);
            default -> "Wrong operator!";
        };
    }

    public static String getRandomOperationSign() {
        String[] totalOperations = {"+", "-", "*"};

        return totalOperations[Utils.getRandomToMax(totalOperations.length - 1)];
    }
}
