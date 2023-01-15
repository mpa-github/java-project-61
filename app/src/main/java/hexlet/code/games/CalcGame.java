package hexlet.code.games;

import hexlet.code.utils.RandomInteger;

public class CalcGame {

    public static final String RULES = "What is the result of the expression?";

    public static String[] getGameData() {
        String[] gameData = new String[2];
        char[] operators = {'+', '-', '*'};
        char operator = operators[RandomInteger.generateNumber(0, 2)];
        int a = RandomInteger.generateNumber(0, 99);
        int b = RandomInteger.generateNumber(0, 99);
        String expression = "%d %s %d".formatted(a, operator, b);
        int correctResult;
        switch (operator) {
            case '+' -> correctResult = a + b;
            case '-' -> correctResult = a - b;
            case '*' -> correctResult = a * b;
            // TODO Exception?
            default -> correctResult = 0;
        }
        gameData[0] = expression;
        gameData[1] = String.valueOf(correctResult);
        return gameData;
    }
}
