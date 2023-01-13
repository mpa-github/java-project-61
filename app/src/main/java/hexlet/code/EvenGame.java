package hexlet.code;

import java.util.Scanner;

public class EvenGame {

    public static void run(Scanner scanner) {
        String username = Cli.greeting(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        final String answerYes = "yes";
        final String answerNo = "no";
        int correctAnswersToWin = 3;

        for (int i = 1; i <= correctAnswersToWin; i++) {
            int numberToGuess = (int) (Math.random() * 100);
            String correctAnswer = (numberToGuess % 2 == 0) ? answerYes : answerNo;
            System.out.printf("Question: %d%n", numberToGuess);
            String userAnswer = scanner.next();
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
