package collections.streaks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Code {

    public static List<List<String>> getStreakList(String input) {
        LinkedList<List<String>> result = new LinkedList<>();
        for (char character : input.toCharArray()) {
            String symbol = String.valueOf(character);
            if (result.size() == 0) {
                result.add(new LinkedList<>(Arrays.asList(symbol)));
            }
            else if (result.getLast().contains(symbol)) {
                result.getLast().add(symbol);
            }
            else {
                result.add(new LinkedList<>(Arrays.asList(symbol)));
            }
            }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getStreakList("AAAKKA"));
    }
}
