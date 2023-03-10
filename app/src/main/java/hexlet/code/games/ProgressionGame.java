package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.MathUtils;
import java.util.StringJoiner;

public class ProgressionGame {

    private static final String RULES = "What number is missing in the progression?";
    private static final int MIN_POSSIBLE_LENGTH = 5;
    private static final int MAX_POSSIBLE_LENGTH = 10;
    private static final int MIN_POSSIBLE_STEP = 2;
    private static final int MAX_POSSIBLE_STEP = 20;
    private static final int MIN_POSSIBLE_FIRST_VALUE = 0;
    private static final int MAX_POSSIBLE_FIRST_VALUE = 30;

    public static void start() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][Engine.GAME_PARAMETERS];
        for (int i = 0; i < gameData.length; i++) {
            int progressionLength = MathUtils.generateRandom(MIN_POSSIBLE_LENGTH, MAX_POSSIBLE_LENGTH);
            int hidePositionIndex = MathUtils.generateRandom(0, progressionLength - 1);
            int stepOfProgression = MathUtils.generateRandom(MIN_POSSIBLE_STEP, MAX_POSSIBLE_STEP);
            int firstElement = MathUtils.generateRandom(MIN_POSSIBLE_FIRST_VALUE, MAX_POSSIBLE_FIRST_VALUE);
            int[] progression = MathUtils.generateProgression(progressionLength, stepOfProgression, firstElement);

            int correctAnswer = progression[hidePositionIndex];
            String question = buildProgressionString(progression, hidePositionIndex);
            gameData[i][0] = question;
            gameData[i][1] = String.valueOf(correctAnswer);
        }
        Engine.run(RULES, gameData);
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
}
