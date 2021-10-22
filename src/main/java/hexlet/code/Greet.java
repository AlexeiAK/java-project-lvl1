package hexlet.code;

public class Greet {
    public static String player1Name; // to be able to call player name wherever

    public static void getGreet() {
        System.out.print("\nWelcome to the Brain Games!\n"
            + "May I have your name? ");

        Player player1 = new Player();
        player1Name = Cli.readAndGetLine(); // to be able to call player name wherever
        player1.setName(player1Name);

        System.out.println("Hello, " + player1Name + "!");
//        Cli.readLine().close();
    }
}
