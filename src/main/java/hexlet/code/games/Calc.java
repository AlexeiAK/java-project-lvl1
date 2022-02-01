package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;
import java.util.Random;

public class Calc {
    static final String GAME_RULES = "What is the result of the expression?";

    static final int NUMBER_OF_TYPES_MATH_OPERATIONS = 3;

    static final int MAX_OF_RANDOM_RANGE = 1;
    static final int MIN_OF_RANDOM_RANGE = 10;

//    private static int expressionAnswer;

    public static void startGame() {
//        String randomOperation = getRandomOperationSign();
//        String[] questionAndAnswer = getRandomQuestionAndAnswer();

//        String[] question = new String[Engine.MAX_ROUNDS];
        String[][] questionAndAnswer = new String[Engine.MAX_ROUNDS][1];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            questionAndAnswer[i] = getRandomQuestionAndAnswer();
//            answer[i] = questionAndAnswer[1];
        }

        Engine.startGame(GAME_RULES, questionAndAnswer);
    }

    public static String[] getRandomQuestionAndAnswer() {
        String operandA = "";
        String operandB = "";
        String operator = "";

        int a = Utils.getNumberFromMinMax(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);
        int b = Utils.getNumberFromMinMax(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);

        int answer = 0;

        switch (getRandomOperationSign()) {
            case "+":
                answer = a + b;
                operandA = Integer.toString(a);
                operandB = Integer.toString(b);
                operator = "+";
                break;
            case "-":
                answer = a - b;
                operandA = Integer.toString(a);
                operandB = Integer.toString(b);
                operator = "-";
                break;
            case "*":
                answer = a * b;
                operandA = Integer.toString(a);
                operandB = Integer.toString(b);
                operator = "*";
                break;
            default:
                break;
        }

        String[] questionAndAnswer = new String[2];
        questionAndAnswer[0] = operandA + " " + operator + " " + operandB;
        questionAndAnswer[1] = Integer.toString(answer);
//        System.out.println(Arrays.toString(questionAndAnswer));
        return questionAndAnswer;
    }

    public static String getRandomOperationSign() {
        String[] totalOperations = {"+", "-", "*"};
        Random randomOperation = new Random();

        return totalOperations[randomOperation.nextInt(NUMBER_OF_TYPES_MATH_OPERATIONS)];
    }
}
