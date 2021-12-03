package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Randomizer;

public class Progression {
    static final String GAME_RULES = "What is number is missing in the progression?";

    static final int MIN_OF_PROGRESSION_LENGTH = 5;
    static final int MAX_OF_PROGRESSION_LENGTH = 10;

    private static String hiddenElement;

    public static void startGame() {
        String[] question = new String[Engine.MAX_ROUNDS];
        String[] answer = new String[Engine.MAX_ROUNDS];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            String[] randomExpressionWithAnswer = getProgressionWithAnswer();

            question[i] = randomExpressionWithAnswer[0];
            answer[i] = randomExpressionWithAnswer[1];
        }

        Engine.startGame(GAME_RULES, question, answer);
    }

    public static String[] getProgressionWithAnswer() {
        int progressionLength = Randomizer.getNumberFromMinMax(MIN_OF_PROGRESSION_LENGTH, MAX_OF_PROGRESSION_LENGTH);
        int firstNumberOfProgression = Randomizer.getNumberFromFinalRange();
        int stepOfProgression = Randomizer.getNumberFromMinMax(MIN_OF_PROGRESSION_LENGTH, MAX_OF_PROGRESSION_LENGTH);

        int indexOfhiddenElement = Randomizer.getNumberFromMinMax(MIN_OF_PROGRESSION_LENGTH, progressionLength);
//        String hiddenElement = ""; // для вопроса, который ниже

        int[] progressionIntRow = new int[progressionLength];
        fillTheProgression(progressionIntRow, firstNumberOfProgression, stepOfProgression);

        String[] progressionStringRow = intArrayToStringArray(progressionIntRow);
        hideRandomElementOfStringRow(progressionStringRow, indexOfhiddenElement - 1/*, hiddenElement*/);

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

    public static void hideRandomElementOfStringRow(String[] progression, int indexOfhiddenElement
            /*, String hiddenElement*/) { // почему hiddenElement не изменяется этим методом?
        hiddenElement = progression[indexOfhiddenElement];
        progression[indexOfhiddenElement] = "..";
    }

    public static String stringArrayToString(String[] array) {
        String stringOfArray = array[0]; // for avoid second space at the beginning of stringOfArray

        for (int i = 1; i < array.length; i++) {
            stringOfArray = stringOfArray + " " + array[i];
        }

        return stringOfArray;
    }
}
