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
            int firstNumberOfProgression = Utils.getRandom();
            int stepOfProgression = Utils.getRandomInRange(MIN_OF_PROGRESSION_LENGTH, MAX_OF_PROGRESSION_LENGTH);

            int progressionLength = Utils.getRandomInRange(MIN_OF_PROGRESSION_LENGTH, MAX_OF_PROGRESSION_LENGTH);

            int[] progressionIntRow = buildProgression(progressionLength, firstNumberOfProgression, stepOfProgression);
            int indexOfhiddenElement = Utils.getRandomInRange(MIN_OF_PROGRESSION_LENGTH - 1, progressionLength - 1);

            questionsAndAnswers[i] = new String[]{
                buildQuestion(progressionIntRow, indexOfhiddenElement),
                Integer.toString(progressionIntRow[indexOfhiddenElement])
            };
        }

        Engine.startGame(GAME_RULES, questionsAndAnswers);
    }

    public static int[] buildProgression(int progressionLength, int firstNumberOfProgression, int stepOfProgression) {
        int[] progression = new int[progressionLength];
        progression[0] = firstNumberOfProgression;

        for (int i = 1; i < progression.length; i++) {
            progression[i] = progression[i - 1] + stepOfProgression;
        }

        return progression;
    }

    public static String buildQuestion(int[] array, int indexOfhiddenElement) {
        // for avoid second space at the beginning of row
        String stringOfArray = Integer.toString(array[0]);

        for (int i = 1; i < array.length; i++) {
            if (i == indexOfhiddenElement) {
                stringOfArray = stringOfArray + " " + "..";
            } else {
                stringOfArray = stringOfArray + " " + array[i];
            }
        }

        return stringOfArray;
    }
}
