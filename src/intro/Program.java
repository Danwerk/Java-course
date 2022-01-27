package intro;

public class Program {

    public static void main(String[] args) {

        int decimal = asDecimal("11001101");

        System.out.println(decimal); // 205

        System.out.println(asString(205));

        System.out.println(pow(2, 7));
    }

    public static String asString(int input) {
        // convert binary code to decimal.
        String result = "";
        while (input != 0) {
            result = (input % 2) + result;
            input = Math.floorDiv(input, 2);

        }
        return result;
    }

    public static int asDecimal(String input) {
        int result = 0;
        int j = 7;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                result += pow(2, j);
                j -= 1;
            }
            else {
                j -= 1;
            }
        }

        return result;
    }

    private static int pow(int arg, int power) {
        // Java has Math.pow() but this time write your own implementation.
        int result = 1;
        if (power == 0) {
            return 1;
        }
        for (int i = 0; i < power; i++) {
            result = result * arg;
        }
        return result;
    }
}
