package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        String[] question = new String[Engine.MAX_ROUNDS];
        String[] answer = new String[Engine.MAX_ROUNDS];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            question[i] = Integer.toString(Utils.getNumberFromFinalRange());
            answer[i] = getCorrectAnswer(Integer.parseInt(question[i]));
        }

        Engine.startGame(GAME_RULES, question, answer);
    }

    public static String getCorrectAnswer(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return "no";
            }
        }

        return "yes";
    }
}
