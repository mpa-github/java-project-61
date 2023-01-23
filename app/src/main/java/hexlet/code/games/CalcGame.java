package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomIntegerUtils;

public class CalcGame {

    public static final String RULES = "What is the result of the expression?";
    private static final int MIN_POSSIBLE_VALUE = 0;
    private static final int MAX_POSSIBLE_VALUE = 100;
    private static final char[] OPERATORS = {'+', '-', '*'};

    public static void startCalcGame() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][Engine.GAME_PARAMETERS];
        for (int i = 0; i < gameData.length; i++) {
            char operator = OPERATORS[RandomIntegerUtils.generateNumber(0, 2)];
            int a = RandomIntegerUtils.generateNumber(MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE);
            int b = RandomIntegerUtils.generateNumber(MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE);
            String expression = "%d %s %d".formatted(a, operator, b);
            int correctResult = switch (operator) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                // TODO Exception?
                default -> 0;
            };
            gameData[i][0] = expression;
            gameData[i][1] = String.valueOf(correctResult);
        }
        Engine.run(RULES, gameData);
    }
}
