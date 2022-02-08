package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    static final String GAME_RULES = "Answer 'yes' if number even. Otherwise answer 'no'.";

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.MAX_ROUNDS][1];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            int randomNumber = Utils.getRandom();
            questionsAndAnswers[i] = getNumberWithAnswer(randomNumber);
        }

        Engine.startGame(GAME_RULES, questionsAndAnswers);
    }

    public static String[] getNumberWithAnswer(int randomNumber) {
        String question = Integer.toString(randomNumber);
        String answer = isNumberEven(randomNumber) ? "yes" : "no";

        return Utils.pairOf(question, answer);
    }

    public static boolean isNumberEven(int number) {
        return number % 2 == 0;
    }
}
