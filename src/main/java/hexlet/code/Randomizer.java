package hexlet.code;

public class Randomizer {

    static final int MAX_OF_RANDOM_RANGE = 1;
    static final int MIN_OF_RANDOM_RANGE = 100;

    public static int getNumberFromFinalRange() {
        return getNumberFromMinMax(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);
    }

    public static int getNumberFromMinMax(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
