package hexlet.code.games;

import hexlet.code.utils.RandomInteger;

public class EvenGame {

    public static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static String[] getGameData() {
        String[] gameData = new String[2];
        String answerYes = "yes";
        String answerNo = "no";
        int numberToGuess = RandomInteger.generateNumber(0, 100);
        String correctAnswer = (numberToGuess % 2 == 0) ? answerYes : answerNo;
        gameData[0] = String.valueOf(numberToGuess);
        gameData[1] = correctAnswer;
        return gameData;
    }
}
