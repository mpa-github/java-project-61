package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    private static final String USER_NAME_REQUEST_MESSAGE = "May I have your name? ";

    public static String greeting() {
        System.out.println(WELCOME_MESSAGE);
        System.out.print(USER_NAME_REQUEST_MESSAGE);
        String username = SCANNER.next();
        System.out.printf("Hello, %s!%n", username);
        return username;
    }
}
