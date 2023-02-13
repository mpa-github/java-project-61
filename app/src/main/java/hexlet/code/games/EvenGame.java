package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.MathUtils;

public class EvenGame {

    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_POSSIBLE_VALUE = 1;
    private static final int MAX_POSSIBLE_VALUE = 99;
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void start() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][Engine.GAME_PARAMETERS];
        for (int i = 0; i < gameData.length; i++) {
            int number = MathUtils.generateRandom(MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE);
            String correctAnswer = MathUtils.isEven(number) ? YES : NO;
            gameData[i][0] = String.valueOf(number);
            gameData[i][1] = correctAnswer;
        }
        Engine.run(RULES, gameData);
    }
}
