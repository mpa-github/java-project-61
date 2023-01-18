package hexlet.code.utils;

import java.util.Random;

public class RandomIntegerUtils {

    public static int generateNumber(int from, int to) {
        Random random = new Random();
        return random.nextInt(from, to + 1);
    }

    public static int generateNumber() {
        final int from = 0;
        final int to = 100;
        return generateNumber(from, to);
    }
}
