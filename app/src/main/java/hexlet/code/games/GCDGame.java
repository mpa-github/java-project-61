package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomIntegerUtils;

public class GCDGame {

    public static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int MIN_POSSIBLE_VALUE = 0;
    private static final int MAX_POSSIBLE_VALUE = 100;

    public static void startGCDGame() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][Engine.GAME_PARAMETERS];
        for (int i = 0; i < gameData.length; i++) {
            int a = RandomIntegerUtils.generateNumber(MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE);
            int b = RandomIntegerUtils.generateNumber(MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE);
            String question = "%d %d".formatted(a, b);
            int correctAnswer = getGreatestDivisor(a, b);
            gameData[i][0] = question;
            gameData[i][1] = String.valueOf(correctAnswer);
        }
        Engine.run(RULES, gameData);
    }

    private static int getGreatestDivisor(int a, int b) {
        int result = 1;
        int currentDivisor = (a == 0 || b == 0) ? Math.max(a, b) : Math.min(a, b);
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
