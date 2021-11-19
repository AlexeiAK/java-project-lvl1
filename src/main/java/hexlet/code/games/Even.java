package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    static final String GAME_RULES = "Answer 'yes' if number even otherwise answer 'no'.";

    static final int MAX_OF_RANDOM_RANGE = 1;
    static final int MIN_OF_RANDOM_RANGE = 100;

    public static void startGame() {
        String[] question = new String[Engine.MAX_ROUNDS];
        String[] answer = new String[Engine.MAX_ROUNDS];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            question[i] = String.valueOf(getNumber());
            answer[i] = isNumberEven(Integer.parseInt(question[i]));
        }

        Engine.startGame(GAME_RULES, question, answer);
    }

    public static String isNumberEven(int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }

    public static int getRandomInteger(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private static int getNumber() {
        return getRandomInteger(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);
    }

}
