package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static String greeting(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String username = scanner.next();
        System.out.printf("Hello, %s!%n", username);
        return username;
    }
}
