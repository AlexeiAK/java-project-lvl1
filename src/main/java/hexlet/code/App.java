package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.print("Please enter the game number and press Enter\n"
            + "1 - Greet\n"
            + "2 - Even\n"
            + "0 - exit\n"
            + "Your choice: ");
        int playerChoice = Cli.readAndGetInt();

        if (playerChoice == 1) {
            Greet.getGreet();
        } else if (playerChoice == 2) {
            Greet.getGreet();
            GameEven.startGame();
        }
    }
}
