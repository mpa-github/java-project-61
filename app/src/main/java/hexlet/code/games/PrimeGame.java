package hexlet.code.games;

import hexlet.code.utils.RandomInteger;

public class PrimeGame {

    public static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static String[] getGameData(int gameRounds) {
        String[] gameData = new String[2 * gameRounds];
        String answerYes = "yes";
        String answerNo = "no";
        int minPossibleValue = 2;
        int maxPossibleValue = 90;
        for (int i = 0; i < gameData.length; i += 2) {
            int number = RandomInteger.generateNumber(minPossibleValue, maxPossibleValue);
            String correctAnswer = answerYes;
            for (int j = 2; j < number; j++) {
                if (number % j == 0) {
                    correctAnswer = answerNo;
                    break;
                }
            }
            gameData[i] = String.valueOf(number);
            gameData[i + 1] = correctAnswer;
        }
        return gameData;
    }
}
