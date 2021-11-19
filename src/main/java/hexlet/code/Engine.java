package hexlet.code;

public class Engine {
    public static final int MAX_ROUNDS = 3;

    public static void startGame(String gameRules, String[] question, String[] answer) {
        System.out.println(gameRules);

        for (int i = 0; i < MAX_ROUNDS; i++) {
            System.out.print("Queestion: " + question[i]);
            System.out.print("\nYour answer: ");
            String playerAnswer = Cli.readAndGetLine();

            if (answer[i].equals(playerAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.print("'" + playerAnswer + "' is wrong answer ;(. Correct answer was '"
                        + answer[i] + "'.\n"
                        + "Let's try again, " + Greet.getName() + "!\n");
            }
        }

        System.out.println("Congratulations, " + Greet.getName() + "!");
    }

}