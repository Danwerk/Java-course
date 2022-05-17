package proovEx.ex1.ex2;

import java.util.ArrayList;
import java.util.List;

public class NumberRepository {
    // pärimine

    private String[] simpleNumberData = "2, 4, 6, 2, 9, 10".split(", ");
    private String[] scientificNumberData = "2e3, 2e4, 6e3".split(", ");

    private List<SimpleNumber> simpleNumbers = new ArrayList<>();
    private List<ScientificNumber> scientificNumbers = new ArrayList<>();

    public List<SimpleNumber> getSimpleNumbers() {
        for (String snd : simpleNumberData) {

            int intValue = Integer.parseInt(snd);

            simpleNumbers.add(new SimpleNumber(intValue));
        }

        return simpleNumbers;
    }

    public List<ScientificNumber> getScientificNumbers() {

        for (String sn : scientificNumberData) {

            String[] splittedByE = sn.split("e");

            scientificNumbers.add(new ScientificNumber(Integer.parseInt(splittedByE[0]), Integer.parseInt(splittedByE[1])));
        }

        return scientificNumbers;
    }

    public List<Number> getAllNumbers() {
        List<Number> numbers = new ArrayList<>();
        numbers.addAll(getSimpleNumbers());
        numbers.addAll(getScientificNumbers());

        return numbers;
    }

}
