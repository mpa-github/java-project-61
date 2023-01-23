package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomIntegerUtils;

public class PrimeGame {

    public static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_POSSIBLE_VALUE = 2;
    private static final int MAX_POSSIBLE_VALUE = 90;
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void startPrimeGame() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][Engine.GAME_PARAMETERS];
        for (int i = 0; i < gameData.length; i++) {
            int number = RandomIntegerUtils.generateNumber(MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE);
            String correctAnswer = isPrime(number) ? YES : NO;
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
