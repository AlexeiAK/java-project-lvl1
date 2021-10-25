package hexlet.code;

public class GameEven {
    private static int winsCounter = 0;
    private static final int WINS_NUMBER = 3;

    private static int randomInteger;
    private static final int MAX_OF_RANDOM_RANGE = 1;
    private static final int MIN_OF_RANDOM_RANGE = 100;

    private static String playerAnswer;

    public static void startGame() {
        System.out.print("Answer 'yes' if number even otherwise answer 'no'.\n");
        while (winsCounter <= WINS_NUMBER) {
            if (winsCounter < WINS_NUMBER) {
                askQuestion();
                getAnswer();
                checkAnswer();
            } else if (winsCounter == WINS_NUMBER) {
                System.out.println("Congratulations, " + Greet.player1Name + "!");
                break;
            }
        }
    }

    public static void askQuestion() {
        randomInteger = getRandomInteger(MAX_OF_RANDOM_RANGE, MIN_OF_RANDOM_RANGE);
        System.out.print("Queestion: "
                + randomInteger
                + "\nYour answer: ");
    }

    public static void getAnswer() {
        playerAnswer = Cli.readAndGetLine();
    }

    public static void checkAnswer() {
        if (!isNumberEven(randomInteger) && playerAnswer.equals("yes")) {
            System.out.print("'yes' is wrong answer ;(. Correct answer was 'no'.\n"
                    + "Let's try again, " + Greet.player1Name + "!\n");
            winsCounter = 0;
        } else if (!isNumberEven(randomInteger) && playerAnswer.equals("no")) {
            System.out.println("Correct!");
            winsCounter++;
        } else if (isNumberEven(randomInteger) && playerAnswer.equals("yes")) {
            System.out.println("Correct!");
            winsCounter++;
        } else if (isNumberEven(randomInteger) && playerAnswer.equals("no")) {
            System.out.print("'no' is wrong answer ;(. Correct answer was 'yes'.\n"
                    + "Let's try again, " + Greet.player1Name + "!\n");
            winsCounter = 0;
        } else {
            System.out.print('"' + playerAnswer + '"' + " is wrong answer ;(\n"
                    + "Let's try again, " + Greet.player1Name + "!\n");
            winsCounter = 0;
        }
    }

    public static boolean isNumberEven(int number) {
        return number % 2 == 0;
    }

    public static int getRandomInteger(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
