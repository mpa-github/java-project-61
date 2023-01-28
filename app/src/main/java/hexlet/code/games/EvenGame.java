package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomIntegerUtils;

public class EvenGame {

    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_POSSIBLE_VALUE = 1;
    private static final int MAX_POSSIBLE_VALUE = 99;
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void startEvenGame() {
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
        int number = RandomIntegerUtils.generateNumber(MIN_POSSIBLE_VALUE, MAX_POSSIBLE_VALUE);
        String correctAnswer = (number % 2 == 0) ? YES : NO;
        paramPair[0] = String.valueOf(number);
        paramPair[1] = correctAnswer;
        return paramPair;
    }
}
