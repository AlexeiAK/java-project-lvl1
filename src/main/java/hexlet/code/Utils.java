package hexlet.code;

public class Utils {

    static final int MAX_OF_RANDOM_RANGE = 1;
    static final int MIN_OF_RANDOM_RANGE = 100;

    public static int getRandom() {
        return getRandomInRange(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);
    }

    public static int getRandomInRange(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static String[] pairOf(String question, String answer) {
        String[] questionsAndAnswers = new String[2];
        questionsAndAnswers[0] = question;
        questionsAndAnswers[1] = answer;

        return questionsAndAnswers;
    }
}
