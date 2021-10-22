package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String readAndGetLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int readAndGetInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
