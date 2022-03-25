package fp.sales;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Analyser {

    private Repository repository;

    public Analyser(Repository repository) {
        this.repository = repository;
    }

    public Double getTotalSales() {
        return repository.getEntries().stream().mapToDouble(Entry::getAmount).sum();
    }

    public Double getSalesByCategory(String category) {
        return repository.getEntries().stream().filter(x -> x.getCategory().equals(category)).mapToDouble(Entry::getAmount).sum();
    }

    public Double getSalesBetween(LocalDate start, LocalDate end) {
        return repository.getEntries().stream().filter(x -> x.getDate().isAfter(start) && x.getDate().isBefore(end)).mapToDouble(Entry::getAmount).sum();

    }

    public String mostExpensiveItems() {
        return repository.getEntries().stream().sorted(Collections.reverseOrder(Comparator.comparing(x -> x.getAmount()))).limit(3).sorted(Comparator.comparing(x -> x.getProductId())).map(x -> x.getProductId()).collect(Collectors.joining(", "));
    }

    public String statesWithBiggestSales() {
        var map = repository.getEntries().stream().collect(Collectors.toMap(each -> each.getState(),
                each -> each.getAmount(),
                (a, b) -> a + b));
        return map.entrySet().stream().sorted(Collections.reverseOrder(Comparator.comparing(x -> x.getValue()))).limit(3).map(x -> x.getKey()).collect(Collectors.joining(", "));

    }
}
