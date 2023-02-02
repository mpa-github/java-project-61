package hexlet.code.utils;

import java.util.Random;

public class MathUtils {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int getGreatestDivisor(int a, int b) {
        int currentDivisor = Math.min(a, b);
        if (a == 0 || b == 0) {
            currentDivisor = Math.max(a, b);
        }
        while (currentDivisor > 0) {
            if (isIntegerDivision(a, currentDivisor) && isIntegerDivision(b, currentDivisor)) {
                return currentDivisor;
            }
            currentDivisor--;
        }
        return currentDivisor;
    }

    public static boolean isIntegerDivision(int a, int b) {
        return a % b == 0;
    }

    public static int[] generateProgression(int length, int step, int firstElement) {
        int next = firstElement;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = next;
            next += step;
        }
        return result;
    }

    public static int generateRandom(int from, int to) {
        Random random = new Random();
        return random.nextInt(from, to + 1);
    }

    public static int generateRandom() {
        final int from = 0;
        final int to = 100;
        return generateRandom(from, to);
    }
}
