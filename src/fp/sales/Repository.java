package fp.sales;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {

    private static final String FILE_PATH = "src/fp/sales/sales-data.csv";

    private List<Entry> entries;

    private DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("dd.MM.yyyy");


    public Repository() {
        List<String> data = readFile();
        this.entries = data.stream().skip(1).map(line -> getEntryObject(splitLine(line))).collect(Collectors.toList());
    }

    private List<String> readFile() {
        try {
            return Files.readAllLines(Paths.get(FILE_PATH));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }


    private List<String> splitLine(String singleLine) {
        return List.of(singleLine.split("\t"));
    }

    private Entry getEntryObject(List<String> line) {
        Entry entry = new Entry();
        entry.setProductId(line.get(2));
        entry.setAmount(Double.valueOf(line.get(5).replace(",", ".")));
        entry.setState(line.get(1));
        entry.setCategory(line.get(3));
        entry.setDate(LocalDate.parse(line.get(0), formatter));
        return entry;
    }


    public List<Entry> getEntries()  {
        return entries;
    }

    public static void main(String[] args) {
        Repository repository = new Repository();
        System.out.println(repository.entries);
        List<Entry> list = repository.entries;

        for (Entry entry : list) {
            System.out.println(entry.getDate() +"   "+ entry.getProductId());
        }
    }



}
