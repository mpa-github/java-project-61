package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;
import java.util.Scanner;

public class App {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String START_MENU_MESSAGE = "Please enter the game number and press Enter.";
    private static final String USER_CHOICE_REQUEST_MESSAGE = "Your choice: ";
    private static final String[] MENU = {"Exit", "Greet", "Even", "Calc", "GCD", "Progression", "Prime"};

    public static void main(String[] args) {
        String menuChoice;
        System.out.println(START_MENU_MESSAGE);
        showGameChoiceMenu();
        System.out.print(USER_CHOICE_REQUEST_MESSAGE);
        menuChoice = SCANNER.nextLine();
        System.out.println();
        switch (menuChoice) {
            case "1" -> Cli.greeting();
            case "2" -> EvenGame.start();
            case "3" -> CalcGame.start();
            case "4" -> GCDGame.start();
            case "5" -> ProgressionGame.start();
            case "6" -> PrimeGame.start();
            case "0" -> System.out.println("Exit...");
            default -> System.out.println("Invalid menu choice!");
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
}
