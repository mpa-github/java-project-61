package hexlet.code.games;

import hexlet.code.utils.RandomInteger;

public class GCDGame {

    public static final String RULES = "Find the greatest common divisor of given numbers.";

    public static String[] getGameData(int gameRounds) {
        String[] gameData = new String[2 * gameRounds];
        int minPossibleValue = 0;
        int maxPossibleValue = 100;
        for (int i = 0; i < gameData.length; i += 2) {
            int a = RandomInteger.generateNumber(minPossibleValue, maxPossibleValue);
            int b = RandomInteger.generateNumber(minPossibleValue, maxPossibleValue);
            String question = "%d %d".formatted(a, b);
            int correctAnswer = 1;
            int currentDivisor = Math.min(a, b);
            while (currentDivisor > 0) {
                if (a % currentDivisor == 0 && b % currentDivisor == 0) {
                    correctAnswer = currentDivisor;
                    break;
                }
                currentDivisor--;
            }
            gameData[i] = question;
            gameData[i + 1] = String.valueOf(correctAnswer);
        }
        return gameData;
    }
}
