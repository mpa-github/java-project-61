package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int GAME_ROUNDS = 3;
    public static final int GAME_PARAMETERS = 2;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void run(String rules, String[][] gameData) {
        String username = Cli.greeting();
        System.out.println(rules);
        for (String[] parameterPair : gameData) {
            String question = parameterPair[0];
            String correctAnswer = parameterPair[1];
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
}
