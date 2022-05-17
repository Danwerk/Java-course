package proovEx.ex1.ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// compareTo

public class WordStore {

    private static final String[] ORDER = {
            "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten"
    };

    private List<String> list = new ArrayList<>();

    public void add(String numberAsWord) {
        list.add(numberAsWord);
    }

    public List<String> getStoredWords() {
        Collections.sort(list, (a, b) -> compare(a, b));
        return list;
    }

    public Integer getOrderIndex(String s) {
        for (int i = 0; i < ORDER.length; i++) {
            if (ORDER[i] == s) {
                return i;
            }
        }
        return -1;
    }

    public int compare(String a, String b) {
        return getOrderIndex(a).compareTo(getOrderIndex(b));

    }
}
