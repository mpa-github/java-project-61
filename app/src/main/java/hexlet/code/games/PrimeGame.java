package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomIntegerUtils;

public class PrimeGame {

    public static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void start() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][Engine.GAME_PARAMETERS];
        String answerYes = "yes";
        String answerNo = "no";
        final int minPossibleValue = 2;
        final int maxPossibleValue = 90;
        for (int i = 0; i < gameData.length; i++) {
            int number = RandomIntegerUtils.generateNumber(minPossibleValue, maxPossibleValue);
            String correctAnswer = isPrime(number) ? answerYes : answerNo;
            gameData[i][0] = String.valueOf(number);
            gameData[i][1] = correctAnswer;
        }
        Engine.run(RULES, gameData);
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
