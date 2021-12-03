package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Randomizer;

import java.util.Random;

public class Calc {
    static final String GAME_RULES = "What is the result of the expression?";

    static final int NUMBER_OF_TYPES_MATH_OPERATIONS = 3;

    static final int MAX_OF_RANDOM_RANGE = 1;
    static final int MIN_OF_RANDOM_RANGE = 10;

    private static int expressionAnswer;

    public static void startGame() {
        String[] question = new String[Engine.MAX_ROUNDS];
        String[] answer = new String[Engine.MAX_ROUNDS];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            question[i] = getRandomExpression();
            answer[i] = Integer.toString(Calc.expressionAnswer);
        }

        Engine.startGame(GAME_RULES, question, answer);
    }

    public static String getRandomOperation() {
        String[] totalOperations = {"addition", "subtraction", "multiplication"};
        Random randomOperation = new Random();

        return totalOperations[randomOperation.nextInt(NUMBER_OF_TYPES_MATH_OPERATIONS)];
    }

    public static String getRandomExpression() {
        String operandA = "";
        String operandB = "";
        String operator = "";

        int a = Randomizer.getNumberFromMinMax(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);
        int b = Randomizer.getNumberFromMinMax(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);

        switch (getRandomOperation()) {
            case "addition":
                Calc.expressionAnswer = a + b;
                operandA = Integer.toString(a);
                operandB = Integer.toString(b);
                operator = "+";
                break;
            case "subtraction":
                Calc.expressionAnswer = a - b;
                operandA = Integer.toString(a);
                operandB = Integer.toString(b);
                operator = "-";
                break;
            case "multiplication":
                Calc.expressionAnswer = a * b;
                operandA = Integer.toString(a);
                operandB = Integer.toString(b);
                operator = "*";
                break;
            default:
                break;
        }

        return operandA + " " + operator + " " + operandB;
    }
}
