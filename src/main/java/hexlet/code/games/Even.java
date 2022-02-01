package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    static final String GAME_RULES = "Answer 'yes' if number even otherwise answer 'no'.";

    public static void startGame() {
        String[] question = new String[Engine.MAX_ROUNDS];
        String[] answer = new String[Engine.MAX_ROUNDS];

        String[][] questionAndAnswer = new String[Engine.MAX_ROUNDS][1];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            question[i] = Integer.toString(Utils.getNumberFromFinalRange());
            answer[i] = isNumberEven(Integer.parseInt(question[i]));
        }

        Engine.startGame(GAME_RULES, questionAndAnswer);
    }

    public static String isNumberEven(int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }
}
