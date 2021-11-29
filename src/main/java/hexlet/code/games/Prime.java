package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    static final int MAX_OF_RANDOM_RANGE = 1;
    static final int MIN_OF_RANDOM_RANGE = 100;

    public static void startGame() {
        String[] question = new String[Engine.MAX_ROUNDS];
        String[] answer = new String[Engine.MAX_ROUNDS];

        for (int i = 0; i < Engine.MAX_ROUNDS; i++) {
            question[i] = Integer.toString(getNumber());
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

    private static int getNumber() {
        return getRandomInteger(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);
    }

    public static int getRandomInteger(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
