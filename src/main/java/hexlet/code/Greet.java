package hexlet.code;

public class Greet {
    public static void getGreet() {
        System.out.print("\nWelcome to the Brain Games!\n"
                + "May I have your name? ");
        Cli.readLine();

        System.out.println("Hello, "
                + Cli.readLine().nextLine()
                + "!");
        Cli.readLine().close();
    }
}
