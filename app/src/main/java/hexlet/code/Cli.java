package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static void greeting() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String username = scanner.nextLine();
        System.out.printf("Hello, %s!%n", username);
        scanner.close();
    }
}
