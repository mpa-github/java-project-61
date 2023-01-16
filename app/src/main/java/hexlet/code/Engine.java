package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.util.Scanner;

public class Engine {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String[] MENU = {"Exit", "Greet", "Even", "Calc", "GCD", "Progression", "Prime"};
    private static final int GAME_ROUNDS = 3;

    // TODO (?)
    public static void run() {
        String menuChoice;
        System.out.println("Please enter the game number and press Enter.");
        showGameChoiceMenu();
        menuChoice = readUserMenuChoice();
        printEmptyLine();
        switch (menuChoice) {
            case "1" -> greeting();
            case "2", "3", "4", "5", "6" -> startGame(MENU[Integer.parseInt(menuChoice)]);
            case "0" -> System.out.println("Exit...");
            // TODO (?)
            default -> System.out.println("Invalid menu choice!");
        }
        SCANNER.close();
    }

    // TODO (?)
    private static void startGame(String gameName) {
        String rules;
        String[] data;
        String username = greeting();
        switch (gameName) {
            case "Even" -> {
                rules = EvenGame.RULES;
                data = EvenGame.getGameData(GAME_ROUNDS);
            }
            case "Calc" -> {
                rules = CalcGame.RULES;
                data = CalcGame.getGameData(GAME_ROUNDS);
            }
            case "GCD" -> {
                rules = GCDGame.RULES;
                data = GCDGame.getGameData(GAME_ROUNDS);
            }
            case "Progression" -> {
                rules = ProgressionGame.RULES;
                data = ProgressionGame.getGameData(GAME_ROUNDS);
            }
            case "Prime" -> {
                rules = PrimeGame.RULES;
                data = PrimeGame.getGameData(GAME_ROUNDS);
            }
            default -> {
                // TODO (?)
                System.out.printf("The game '%s' is not ready yet!%n", gameName);
                return;
            }
        }
        System.out.println(rules);
        for (int i = 0; i < data.length; i += 2) {
            String question = data[i];
            String correctAnswer = data[i + 1];
            System.out.printf("Question: %s%n", question);
            String userAnswer = SCANNER.next();
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", userAnswer, correctAnswer);
                System.out.printf("Let's try again, %s!%n", username);
                return;
            }
        }
        System.out.printf("Congratulations, %s!%n", username);
    }

    private static String greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String username = SCANNER.next();
        System.out.printf("Hello, %s!%n", username);
        return username;
    }

    private static String readUserMenuChoice() {
        StringBuilder numbersForPattern = new StringBuilder();
        // TODO Make result of this cycle constant?
        for (int i = 0; i < MENU.length; i++) {
            numbersForPattern.append(i);
        }
        String inputPattern = "[%s]".formatted(numbersForPattern.toString());
        String emptyString = "";
        String message = "Your choice: ";
        System.out.print(message);
        String userInput = SCANNER.next();
        if (userInput.matches(inputPattern)) {
            return userInput;
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
