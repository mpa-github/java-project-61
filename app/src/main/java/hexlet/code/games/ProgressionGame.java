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
            int firstElement = RandomIntegerUtils.generateNumber(minPossibleFirstValue, maxPossibleFirstValue);
            int[] progression = getProgressionElements(progressionLength, stepOfProgression, firstElement);
            int correctAnswer = progression[hidePosition - 1];
            String question = buildProgressionString(progression, hidePosition);
            gameData[i][0] = question;
            gameData[i][1] = String.valueOf(correctAnswer);
        }
        Engine.run(RULES, gameData);
    }

    private static String buildProgressionString(int[] progression, int hidePosition) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int j = 0; j < progression.length; j++) {
            if (j == hidePosition - 1) {
                stringJoiner.add("..");
            } else {
                stringJoiner.add(String.valueOf(progression[j]));
            }
        }
        return stringJoiner.toString();
    }

    private static int[] getProgressionElements(int length, int step, int firstElement) {
        int next = firstElement;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = next;
            next += step;
        }
        return result;
    }
}
