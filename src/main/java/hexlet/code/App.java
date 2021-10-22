package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.print("Please enter the game number and press Enter\n"
            + "1 - Greet\n"
            + "0 - exit\n"
            + "Your choice: ");
        Cli.readInt();

        if (Cli.readInt().nextInt() == 1) {
            Greet.getGreet();
        }
    }
}
