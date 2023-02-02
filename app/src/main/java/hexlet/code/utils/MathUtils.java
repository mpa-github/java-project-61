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
        int result = 0;
        int currentDivisor = (a == 0 || b == 0) ? Math.max(a, b) : Math.min(a, b);
        while (currentDivisor > 0) {
            if (a % currentDivisor == 0 && b % currentDivisor == 0) {
                result = currentDivisor;
                break;
            }
            currentDivisor--;
        }
        return result;
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
