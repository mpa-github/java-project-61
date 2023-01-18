package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {

    public static final Scanner SCANNER = new Scanner(System.in);
    private static final String[] MENU = {"Exit", "Greet", "Even", "Calc", "GCD", "Progression", "Prime"};

    public static void main(String[] args) {
        String menuChoice;
        System.out.println("Please enter the game number and press Enter.");
        showGameChoiceMenu();
        menuChoice = readUserMenuChoice();
        printEmptyLine();
        switch (menuChoice) {
            case "Greet" -> greeting();
            case "Even" -> EvenGame.start();
            case "Calc" -> CalcGame.start();
            case "GCD" -> GCDGame.start();
            case "Progression" -> ProgressionGame.start();
            case "Prime" -> PrimeGame.start();
            case "Exit" -> System.out.println("Exit...");
            default -> System.out.println("Invalid menu choice!");
        }
        SCANNER.close();
    }

    public static String greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String username = SCANNER.next();
        System.out.printf("Hello, %s!%n", username);
        return username;
    }

    private static String readUserMenuChoice() {
        StringBuilder numbersForPattern = new StringBuilder();
        for (int i = 0; i < MENU.length; i++) {
            numbersForPattern.append(i);
        }
        String inputPattern = "[%s]".formatted(numbersForPattern.toString());
        String emptyString = "";
        String message = "Your choice: ";
        System.out.print(message);
        String userInput = SCANNER.next();
        if (userInput.matches(inputPattern)) {
            return MENU[Integer.parseInt(userInput)];
        } else {
            return emptyString;
        }
    }

    private static void showGameChoiceMenu() {
        StringBuilder menu = new StringBuilder();
        for (int i = 1; i < MENU.length; i++) {
            menu.append("%d - %s%n".formatted(i, MENU[i]));
        }
        menu.append("0 - %s".formatted(MENU[0]));
        System.out.println(menu);
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
