package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomIntegerUtils;

import java.util.StringJoiner;

public class ProgressionGame {

    public static final String RULES = "What number is missing in the progression?";
    private static final int MIN_POSSIBLE_LENGTH = 5;
    private static final int MAX_POSSIBLE_LENGTH = 10;
    private static final int MIN_POSSIBLE_STEP = 2;
    private static final int MAX_POSSIBLE_STEP = 20;
    private static final int MIN_POSSIBLE_FIRST_VALUE = 0;
    private static final int MAX_POSSIBLE_FIRST_VALUE = 30;

    public static void start() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][Engine.GAME_PARAMETERS];
        for (int i = 0; i < gameData.length; i++) {
            int progressionLength = RandomIntegerUtils.generateNumber(MIN_POSSIBLE_LENGTH, MAX_POSSIBLE_LENGTH);
            int hidePosition = RandomIntegerUtils.generateNumber(1, progressionLength);
            int stepOfProgression = RandomIntegerUtils.generateNumber(MIN_POSSIBLE_STEP, MAX_POSSIBLE_STEP);
            int firstElement = RandomIntegerUtils.generateNumber(MIN_POSSIBLE_FIRST_VALUE, MAX_POSSIBLE_FIRST_VALUE);
            int[] progression = generateProgression(progressionLength, stepOfProgression, firstElement);
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

    private static int[] generateProgression(int length, int step, int firstElement) {
        int next = firstElement;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = next;
            next += step;
        }
        return result;
    }
}
