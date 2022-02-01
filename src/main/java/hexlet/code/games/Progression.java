package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    static final String GAME_RULES = "What is number is missing in the progression?";

    static final int MIN_OF_PROGRESSION_LENGTH = 5;
    static final int MAX_OF_PROGRESSION_LENGTH = 10;

//    private static String hiddenElement;

    public static void startGame() {
//        String[] question = new String[Engine.MAX_ROUNDS];
//        String[] answer = new String[Engine.MAX_ROUNDS];

        String[][] questionAndAnswer = new String[Engine.MAX_ROUNDS][1];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
//            String[] randomExpressionWithAnswer = getProgressionWithAnswer();
//            question[i] = randomExpressionWithAnswer[0];
//            answer[i] = randomExpressionWithAnswer[1];
            questionAndAnswer[i] = getProgressionWithAnswer();
        }

        Engine.startGame(GAME_RULES, questionAndAnswer);
    }

    public static String[] getProgressionWithAnswer() {
        int progressionLength = Utils.getNumberFromMinMax(MIN_OF_PROGRESSION_LENGTH, MAX_OF_PROGRESSION_LENGTH);
        int firstNumberOfProgression = Utils.getNumberFromFinalRange();
        int stepOfProgression = Utils.getNumberFromMinMax(MIN_OF_PROGRESSION_LENGTH, MAX_OF_PROGRESSION_LENGTH);
        int indexOfhiddenElement = Utils.getNumberFromMinMax(MIN_OF_PROGRESSION_LENGTH, progressionLength);

        int[] progressionIntRow = new int[progressionLength];
        fillTheProgression(progressionIntRow, firstNumberOfProgression, stepOfProgression);

        String[] progressionStringRow = intArrayToStringArray(progressionIntRow);
        String hiddenElement = getAndhideRandomElementOfStringRow(progressionStringRow, indexOfhiddenElement - 1);

        String[] progressionWithAnswer = new String[2];
        progressionWithAnswer[0] = stringArrayToString(progressionStringRow);
        progressionWithAnswer[1] = hiddenElement;

        return progressionWithAnswer;
    }


    public static void fillTheProgression(int[] progression, int firstNumberOfProgression, int stepOfProgression) {
        progression[0] = firstNumberOfProgression;

        for (int i = 1; i < progression.length; i++) {
            progression[i] = progression[i - 1] + stepOfProgression;
        }
    }

    public static String[] intArrayToStringArray(int[] intArray) {
        String[] stringArray = new String[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            stringArray[i] = Integer.toString(intArray[i]);
        }

        return stringArray;
    }

    public static String getAndhideRandomElementOfStringRow(String[] progression, int indexOfhiddenElement) {
        String hiddenElement = progression[indexOfhiddenElement];
        progression[indexOfhiddenElement] = "..";

        return hiddenElement;
    }

    public static String stringArrayToString(String[] array) {
        String stringOfArray = array[0]; // for avoid second space at the beginning of stringOfArray

        for (int i = 1; i < array.length; i++) {
            stringOfArray = stringOfArray + " " + array[i];
        }

        return stringOfArray;
    }
}
