package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomIntegerUtils;

public class EvenGame {

    public static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void start() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][Engine.GAME_PARAMETERS];
        String answerYes = "yes";
        String answerNo = "no";
        final int minPossibleValue = 0;
        final int maxPossibleValue = 100;
        for (int i = 0; i < gameData.length; i++) {
            int numberToGuess = RandomIntegerUtils.generateNumber(minPossibleValue, maxPossibleValue);
            String correctAnswer = isEven(numberToGuess) ? answerYes : answerNo;
            gameData[i][0] = String.valueOf(numberToGuess);
            gameData[i][1] = correctAnswer;
        }
        Engine.run(RULES, gameData);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
