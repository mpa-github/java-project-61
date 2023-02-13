package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.MathUtils;

public class GCDGame {

    private static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int MIN_POSSIBLE_VALUE = 0;
    private static final int MAX_POSSIBLE_VALUE = 100;

    public static void start() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][Engine.GAME_PARAMETERS];
        for (int i = 0; i < gameData.length; i++) {
            int number1 = MathUtils.generateRandom(MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE);
            int number2 = MathUtils.generateRandom(MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE);
            String question = "%d %d".formatted(number1, number2);
            int correctAnswer = MathUtils.getGreatestDivisor(number1, number2);
            gameData[i][0] = question;
            gameData[i][1] = String.valueOf(correctAnswer);
        }
        Engine.run(RULES, gameData);
    }
}
