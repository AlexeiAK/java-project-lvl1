package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {
    static final String GAME_RULES = "What is the result of the expression?";

    static final int NUMBER_OF_TYPES_MATH_OPERATIONS = 3;

    static final int MAX_OF_RANDOM_RANGE = 1;
    static final int MIN_OF_RANDOM_RANGE = 10;

    public static void startGame() {
        String[] question = new String[Engine.MAX_ROUNDS];
        String[] answer = new String[Engine.MAX_ROUNDS];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            String[] randomExpressionWithAnswer = getRandomExpressionWithAnswer();

            question[i] = randomExpressionWithAnswer[0];
            answer[i] = randomExpressionWithAnswer[1];
        }

        Engine.startGame(GAME_RULES, question, answer);
    }

    public static String[] getRandomExpressionWithAnswer() {
        String operandA = "";
        String operandB = "";
        String operator = "";

        int a = getRandomInteger(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);
        int b = getRandomInteger(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);

        int answer = 0;

        switch (getRandomOperation()) {
            case "addition":
                answer = a + b;
                operandA = Integer.toString(a);
                operandB = Integer.toString(b);
                operator = "+";
                break;
            case "subtraction":
                answer = a - b;
                operandA = Integer.toString(a);
                operandB = Integer.toString(b);
                operator = "-";
                break;
            case "multiplication":
                answer = a * b;
                operandA = Integer.toString(a);
                operandB = Integer.toString(b);
                operator = "*";
                break;
            default:
                break;
        }

        String randomExpression = operandA + " " + operator + " " + operandB;

        String[] randomExpressionWithAnswer = new String[2];
        randomExpressionWithAnswer[0] = randomExpression;
        randomExpressionWithAnswer[1] = Integer.toString(answer);

        return randomExpressionWithAnswer;
    }

    public static int getRandomInteger(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static String getRandomOperation() {
        String[] totalOperations = {"addition", "subtraction", "multiplication"};
        Random randomOperation = new Random();

        return totalOperations[randomOperation.nextInt(NUMBER_OF_TYPES_MATH_OPERATIONS)];
    }
}
