package hexlet.code.utils;

import java.util.Random;

public class RandomInteger {

    public static int generateNumber(int from, int to) {
        Random random = new Random();
        return random.nextInt(from, to + 1);
    }

    public static int generateNumber() {
        int from = 0;
        int to = 100;
        return generateNumber(from, to);
    }
}
