package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.MathUtils;

public class PrimeGame {

    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_POSSIBLE_VALUE = 2;
    private static final int MAX_POSSIBLE_VALUE = 90;
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void startPrimeGame() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][Engine.GAME_PARAMETERS];
        for (int i = 0; i < gameData.length; i++) {
            String[] paramPair = generateGameParameterPair();
            gameData[i][0] = paramPair[0];
            gameData[i][1] = paramPair[1];
        }
        Engine.run(RULES, gameData);
    }

    private static String[] generateGameParameterPair() {
        String[] paramPair = new String[2];
        int number = MathUtils.generateRandom(MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE);
        String correctAnswer = MathUtils.isPrime(number) ? YES : NO;
        paramPair[0] = String.valueOf(number);
        paramPair[1] = correctAnswer;
        return paramPair;
    }
}
