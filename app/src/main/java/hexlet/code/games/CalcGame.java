package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.MathUtils;

public class CalcGame {

    public static final String RULES = "What is the result of the expression?";
    private static final int MIN_POSSIBLE_VALUE = 0;
    private static final int MAX_POSSIBLE_VALUE = 100;
    private static final char[] OPERATORS = {'+', '-', '*'};

    public static void start() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][Engine.GAME_PARAMETERS];
        for (int i = 0; i < gameData.length; i++) {
            char operator = OPERATORS[MathUtils.generateRandom(0, OPERATORS.length - 1)];
            int operand1 = MathUtils.generateRandom(MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE);
            int operand2 = MathUtils.generateRandom(MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE);
            String expression = "%d %s %d".formatted(operand1, operator, operand2);
            int correctResult = switch (operator) {
                case '+' -> operand1 + operand2;
                case '-' -> operand1 - operand2;
                case '*' -> operand1 * operand2;
                default -> throw new UnsupportedOperationException("CalcGame: Invalid operation!");
            };
            gameData[i][0] = expression;
            gameData[i][1] = String.valueOf(correctResult);
        }
        Engine.run(RULES, gameData);
    }
}
