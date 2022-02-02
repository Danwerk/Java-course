package types;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.Random;

public class Code {

    public static void main(String[] args) {

        int[] numbers = {1, 3, -2, 9};
        int[] numbers2 = {1, 2};

//        System.out.println(sum(numbers)); // 11
//        System.out.println(average(numbers2)); // 1.5
//        System.out.println(minimumElement(numbers2)); // 1
//        System.out.println(asString(numbers));
//        System.out.println(mode("hello")); // l
//        System.out.println(squareDigits("a9b2")); // a81b4;
    }

    public static void print(String[] elements) {
        for (String element : elements) {
            System.out.print(element);

        }
    }


    public static int sum(int[] numbers) {
//        The another way to do it:
//        for (int number : numbers) {
//            result += number }

        int result = 0;
        if (numbers.length == 0) {
            return result;
        }
        for (int number : numbers) {
            result += number;

        }
        return result;
    }


    public static double average(int[] numbers) {
        if (numbers.length == 0) {
            return 0.0;
        }
        return Double.valueOf(sum(numbers)) / numbers.length;
    }


    public static Integer minimumElement(int[] integers) {
        if (integers.length == 0) {
            return null;
        }
        int minimum = integers[0];
        for (int integer : integers) {
            if (integer < minimum) {
                minimum = integer;
            }
        }
        return minimum;
    }


    public static String asString(int[] elements) {
        String result = "";
        for (int i = 0; i < elements.length; i++) {
            if (i == elements.length - 1) {
                result += elements[i];
            } else {
                result += elements[i] + ", ";
            }

        }
        return result;
    }


    public static Character mode(String input) {
        if (input.length() == 0) {
            return null;
        }
        int globalCount = 0;
        String mostCommonChar = "";
        String[] array = input.split("");
        for (String s : array) {
            int count = 0;
            for (String value : array) {
                if (s.equals(value)) {
                    count++;
                }
                if (count > globalCount) {
                    globalCount = count;
                    mostCommonChar = s;
                }


            }
        }
        return mostCommonChar.charAt(0);
    }


    public static String squareDigits(String s) {
        char[] array = s.toCharArray();
        String result = "";
        for (char c : array) {
            if (Character.isDigit(c)) {
                String charToString = Character.toString(c);
                int squaredNumber = Integer.parseInt(charToString) * Integer.parseInt(charToString);
                result += squaredNumber;
            } else {
                result += c;
            }

        }
        return result;

    }


    public static int isolatedSquareCount() {
        boolean[][] matrix = getSampleMatrix();

        printMatrix(matrix);

        int isolatedCount = 0;

        // count isolates squares here

        return isolatedCount;
    }


    private static void printMatrix(boolean[][] matrix) {
        for (boolean[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }


    private static boolean[][] getSampleMatrix() {
        boolean[][] matrix = new boolean[10][10];

        Random r = new Random(5);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = r.nextInt(5) < 2;
            }
        }

        return matrix;
    }
}
