package fp;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;


public class Persons {

    private List<Person> persons = List.of(
            new Person(1, "Alice", 22),
            new Person(2, "Bob", 20),
            new Person(3, "Carol", 21));

    @Test
    public void findsPersonById() {
        List<Person> personById = persons.stream().filter(x -> x.getId().equals(2)).collect(Collectors.toList());

        System.out.println(personById);
    }

    @Test
    public void removePersonById() {
        List<Person> personById = persons.stream().filter(x -> !x.getId().equals(2)).collect(Collectors.toList());

        System.out.println(personById);
    }

    @Test
    public void findsPersonNames() {
        String personNames = persons.stream().map(x -> x.getName()).collect(Collectors.joining(", "));

        System.out.println(personNames);
    }

    @Test
    public void reverseSortedByAge() {
        List<Person> sortedByAge = persons.stream().sorted((a, b) -> a.getAge().compareTo(b.getAge())).toList();

        System.out.println(sortedByAge);
    }

}
