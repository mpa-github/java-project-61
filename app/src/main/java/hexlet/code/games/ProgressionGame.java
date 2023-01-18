package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomIntegerUtils;

import java.util.StringJoiner;

public class ProgressionGame {

    public static final String RULES = "What number is missing in the progression?";

    public static void start() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][Engine.GAME_PARAMETERS];
        final int minPossibleLengthValue = 5;
        final int maxPossibleLengthValue = 10;
        final int minPossibleStepValue = 2;
        final int maxPossibleStephValue = 20;
        final int minPossibleFirstValue = 0;
        final int maxPossibleFirstValue = 30;
        for (int i = 0; i < gameData.length; i++) {
            int progressionLength = RandomIntegerUtils.generateNumber(minPossibleLengthValue, maxPossibleLengthValue);
            int hidePosition = RandomIntegerUtils.generateNumber(1, progressionLength);
            int stepOfProgression = RandomIntegerUtils.generateNumber(minPossibleStepValue, maxPossibleStephValue);
            int nextNumber = RandomIntegerUtils.generateNumber(minPossibleFirstValue, maxPossibleFirstValue);
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
            gameData[i][0] = question.toString();
            gameData[i][1] = String.valueOf(correctAnswer);
        }
        Engine.run(RULES, gameData);
    }
}
