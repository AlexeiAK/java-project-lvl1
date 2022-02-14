package hexlet.code;

public class Utils {

    static final int MAX_OF_RANDOM_RANGE = 100;
    static final int MIN_OF_RANDOM_RANGE = 0;

    public static int getRandom() {
        return getRandomInRange(MIN_OF_RANDOM_RANGE, MAX_OF_RANDOM_RANGE);
    }

    public static int getRandomInRange(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static int getRandomToMax(int max) {
        return getRandomInRange(0, max);
    }
}
