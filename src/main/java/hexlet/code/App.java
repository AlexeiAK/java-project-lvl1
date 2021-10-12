package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!\n"
        + "May I have your name?");

        Cli.enterName();

        System.out.println("Hello, " +
                Cli.enterName().nextLine() + "!");
    }
}