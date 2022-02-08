package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    static final String GAME_RULES = "What is number is missing in the progression?";

    static final int MIN_OF_PROGRESSION_LENGTH = 5;
    static final int MAX_OF_PROGRESSION_LENGTH = 10;

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][1];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int progressionLength = Utils.getNumberFromMinMax(MIN_OF_PROGRESSION_LENGTH, MAX_OF_PROGRESSION_LENGTH);
            int firstNumberOfProgression = Utils.getNumberFromFinalRange();
            int stepOfProgression = Utils.getNumberFromMinMax(MIN_OF_PROGRESSION_LENGTH, MAX_OF_PROGRESSION_LENGTH);
            int indexOfhiddenElement = Utils.getNumberFromMinMax(MIN_OF_PROGRESSION_LENGTH, progressionLength);

            questionsAndAnswers[i] = getProgressionWithAnswer(progressionLength,
                    firstNumberOfProgression,
                    stepOfProgression,
                    indexOfhiddenElement);
        }

        Engine.startGame(GAME_RULES, questionsAndAnswers);
    }

    public static String[] getProgressionWithAnswer(int progressionLength,
                                                    int firstNumberOfProgression,
                                                    int stepOfProgression,
                                                    int indexOfhiddenElement) {

        int[] progressionIntRow = new int[progressionLength];

        fillTheProgression(progressionIntRow, firstNumberOfProgression, stepOfProgression);

        String[] progressionStringRow = intArrayToStringArray(progressionIntRow);
        String hiddenElement = getAndhideRandomElementOfStringRow(progressionStringRow, indexOfhiddenElement - 1);

        String question = stringArrayToString(progressionStringRow);
        String answer = hiddenElement;

        return Utils.formQuestionAndAnswer(question, answer);
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

        return stringOfArray.toString();
    }
}
