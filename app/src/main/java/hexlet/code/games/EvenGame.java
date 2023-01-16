package hexlet.code.games;

import hexlet.code.utils.RandomInteger;

public class EvenGame {

    public static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static String[] getGameData(int gameRounds) {
        String[] gameData = new String[2 * gameRounds];
        String answerYes = "yes";
        String answerNo = "no";
        final int minPossibleValue = 0;
        final int maxPossibleValue = 100;
        for (int i = 0; i < gameData.length; i += 2) {
            int numberToGuess = RandomInteger.generateNumber(minPossibleValue, maxPossibleValue);
            String correctAnswer = (numberToGuess % 2 == 0) ? answerYes : answerNo;
            gameData[i] = String.valueOf(numberToGuess);
            gameData[i + 1] = correctAnswer;
        }
        return gameData;
    }
}
