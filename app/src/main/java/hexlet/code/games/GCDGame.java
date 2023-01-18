package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomIntegerUtils;

public class GCDGame {

    public static final String RULES = "Find the greatest common divisor of given numbers.";

    public static void start() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][Engine.GAME_PARAMETERS];
        final int minPossibleValue = 0;
        final int maxPossibleValue = 100;
        for (int i = 0; i < gameData.length; i++) {
            int a = RandomIntegerUtils.generateNumber(minPossibleValue, maxPossibleValue);
            int b = RandomIntegerUtils.generateNumber(minPossibleValue, maxPossibleValue);
            String question = "%d %d".formatted(a, b);
            int correctAnswer = getGreatestDivisor(a, b);
            gameData[i][0] = question;
            gameData[i][1] = String.valueOf(correctAnswer);
        }
        Engine.run(RULES, gameData);
    }

    private static int getGreatestDivisor(int a, int b) {
        int result = 1;
        int currentDivisor = Math.min(a, b);
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
