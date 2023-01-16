package hexlet.code.games;

import hexlet.code.utils.RandomInteger;

public class CalcGame {

    public static final String RULES = "What is the result of the expression?";

    public static String[] getGameData(int gameRounds) {
        String[] gameData = new String[2 * gameRounds];
        char[] operators = {'+', '-', '*'};
        for (int i = 0; i < gameData.length; i += 2) {
            char operator = operators[RandomInteger.generateNumber(0, 2)];
            int a = RandomInteger.generateNumber(0, 99);
            int b = RandomInteger.generateNumber(0, 99);
            String expression = "%d %s %d".formatted(a, operator, b);
            int correctResult = switch (operator) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                // TODO Exception?
                default -> 0;
            };
            gameData[i] = expression;
            gameData[i + 1] = String.valueOf(correctResult);
        }
        return gameData;
    }
}
