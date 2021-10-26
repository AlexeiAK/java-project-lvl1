package hexlet.code;

public class Greet {
    private static String player1Name; // to be able to call player name wherever
    public static String getName() {
        return player1Name;
    }

    public static void getGreet() {
        System.out.print("\nWelcome to the Brain Games!\n"
            + "May I have your name? ");

        player1Name = Cli.readAndGetLine(); // to be able to call player name wherever

        System.out.println("Hello, " + Greet.getName() + "!");
//        Cli.readLine().close();
    }
}
