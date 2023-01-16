package hexlet.code.games;

import hexlet.code.utils.RandomInteger;

import java.util.StringJoiner;

public class ProgressionGame {

    public static final String RULES = "What number is missing in the progression?";

    public static String[] getGameData(int gameRounds) {
        String[] gameData = new String[2 * gameRounds];
        for (int i = 0; i < gameData.length; i += 2) {
            int progressionLength = RandomInteger.generateNumber(5, 10);
            int hidePosition = RandomInteger.generateNumber(1, progressionLength);
            int stepOfProgression = RandomInteger.generateNumber(1, 20);
            int nextNumber = RandomInteger.generateNumber(0, 50);
            int correctAnswer = 0;
            StringJoiner question = new StringJoiner(" ");
            for (int j = 1; j <= progressionLength; j++) {
                if (j == hidePosition) {
                    question.add("..");
                    correctAnswer = nextNumber;
                } else {
                    question.add(String.valueOf(nextNumber));
                }
                nextNumber += stepOfProgression;
            }
            gameData[i] = question.toString();
            gameData[i + 1] = String.valueOf(correctAnswer);
        }
        return gameData;
    }
}
