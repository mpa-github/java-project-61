package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomIntegerUtils;

public class GCDGame {

    private static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int MIN_POSSIBLE_VALUE = 0;
    private static final int MAX_POSSIBLE_VALUE = 100;

    public static void startGCDGame() {
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
        int a = RandomIntegerUtils.generateNumber(MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE);
        int b = RandomIntegerUtils.generateNumber(MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE);
        String question = "%d %d".formatted(a, b);
        int correctAnswer = getGreatestDivisor(a, b);
        paramPair[0] = question;
        paramPair[1] = String.valueOf(correctAnswer);
        return paramPair;
    }

    private static int getGreatestDivisor(int a, int b) {
        boolean hasZero = (a == 0 || b == 0);
        int result = 0;
        int currentDivisor = hasZero ? Math.max(a, b) : Math.min(a, b);
        while (currentDivisor > 0) {
            if (a % currentDivisor == 0 && b % currentDivisor == 0) {
                result = currentDivisor;
                break;
            }
            currentDivisor--;
        }
        return result;
    }
}
