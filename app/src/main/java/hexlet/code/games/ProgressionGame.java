package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomIntegerUtils;

import java.util.StringJoiner;

public class ProgressionGame {

    private static final String RULES = "What number is missing in the progression?";
    private static final int MIN_POSSIBLE_LENGTH = 5;
    private static final int MAX_POSSIBLE_LENGTH = 10;
    private static final int MIN_POSSIBLE_STEP = 2;
    private static final int MAX_POSSIBLE_STEP = 20;
    private static final int MIN_POSSIBLE_FIRST_VALUE = 0;
    private static final int MAX_POSSIBLE_FIRST_VALUE = 30;

    public static void startProgressionGame() {
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
        int progressionLength = RandomIntegerUtils.generateNumber(MIN_POSSIBLE_LENGTH, MAX_POSSIBLE_LENGTH);
        int hidePositionIndex = RandomIntegerUtils.generateNumber(0, progressionLength - 1);
        int stepOfProgression = RandomIntegerUtils.generateNumber(MIN_POSSIBLE_STEP, MAX_POSSIBLE_STEP);
        int firstElement = RandomIntegerUtils.generateNumber(MIN_POSSIBLE_FIRST_VALUE, MAX_POSSIBLE_FIRST_VALUE);
        int[] progression = generateProgression(progressionLength, stepOfProgression, firstElement);
        int correctAnswer = progression[hidePositionIndex];
        String question = buildProgressionString(progression, hidePositionIndex);
        paramPair[0] = question;
        paramPair[1] = String.valueOf(correctAnswer);
        return paramPair;
    }

    private static String buildProgressionString(int[] progression, int hidePositionIndex) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int j = 0; j < progression.length; j++) {
            if (j == hidePositionIndex) {
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
