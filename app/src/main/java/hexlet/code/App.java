package hexlet.code;

import java.util.Scanner;

public class App {

    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String userChoice;
        do {
            System.out.println("Please enter the game number and press Enter.");
            showGameChoiceMenu();
            userChoice = readUserGameChoice(SCANNER);
            printEmptyLine();
            switch (userChoice) {
                case "1" -> Cli.greeting(SCANNER);
                case "2" -> EvenGame.run(SCANNER);
                case "0" -> System.out.println("Exit...");
                default -> System.out.println("Invalid input...");
            }
            printEmptyLine();
        } while (!userChoice.equals("0"));
        SCANNER.close();
    }

    public static String readUserGameChoice(Scanner scanner) {
        final String inputPattern = "[012]";
        final String emptyString = "";
        final String message = "Your choice: ";
        System.out.print(message);
        String userInput = scanner.next();
        if (userInput.matches(inputPattern)) {
            return userInput;
        } else {
            return emptyString;
        }
    }

    public static void showGameChoiceMenu() {
        final String newLine = System.lineSeparator();
        final String menu = "1 - Greet" + newLine +
                            "2 - Even" + newLine +
                            "0 - Exit";
        System.out.println(menu);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
