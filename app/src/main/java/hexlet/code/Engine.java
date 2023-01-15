package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;

import java.util.Scanner;

public class Engine {

    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String[] MENU = {"Exit", "Greet", "Even", "Calc"};

    // TODO (?)
    public static void run() {
        String menuChoice;
        do {
            int gameRounds = 3;
            System.out.println("Please enter the game number and press Enter.");
            showGameChoiceMenu();
            menuChoice = readUserMenuChoice();
            printEmptyLine();
            switch (menuChoice) {
                case "1" -> greeting();
                case "0" -> System.out.println("Exit...");
                case "2", "3" -> {
                    String gameName = MENU[Integer.parseInt(menuChoice)];
                    String username = greeting();
                    startGame(username, gameName, gameRounds);
                }
                default -> System.out.println("Invalid menu choice!");
            }
            printEmptyLine();
        } while (!menuChoice.equals("0"));
        SCANNER.close();
    }

    // TODO (?)
    private static void startGame(String username, String gameName, int gameRounds) {
        String rules;
        String[] data = new String[2];
        switch (gameName) {
            case "Even" -> rules = EvenGame.RULES;
            case "Calc" -> rules = CalcGame.RULES;
            default -> {
                // TODO (?)
                System.out.println("Game error!");
                return;
            }
        }
        System.out.println(rules);
        for (int i = 1; i <= gameRounds; i++) {
            switch (gameName) {
                case "Even" -> data = EvenGame.getGameData();
                case "Calc" -> data = CalcGame.getGameData();
            }
            String question = data[0];
            String correctAnswer = data[1];
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
        // TODO Make result of this cycle constant
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
