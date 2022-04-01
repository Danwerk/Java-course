package poly.customer;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    private static final String FILE_PATH = "src/poly/customer/data.txt";

    private final List<AbstractCustomer> customers = new ArrayList<>();


    public CustomerRepository() {
        List<String> lines;

        try {
            lines = Files.readAllLines(Paths.get(FILE_PATH));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }


        for (String line : lines) {
            String[] parts = line.split(";");
            String type = parts[0];
            String id = parts[1];
            String name = parts[2];
            int bonuspoints = Integer.parseInt(parts[3]);
            LocalDate date;


            if (parts.length < 5) {
                date = LocalDate.now();
            } else {
                date = LocalDate.parse(parts[4]);
            }

            if (type.equals("REGULAR")) {
                customers.add(new RegularCustomer(id, name, bonuspoints, date));
            }
            if (type.equals("GOLD")) {
                customers.add(new GoldCustomer(id, name, bonuspoints, date));
            }
        }
    }


    public Optional<AbstractCustomer> getCustomerById(String id) {

        return customers.stream()
                .filter(x -> x.getId().equals(id))
                .findAny();
    }


    public void remove(String id) {
        customers.removeIf(c -> c.getId().equals(id));
    }


    public void save(AbstractCustomer customer) {
        if (isCustomerInList(customer)) {
            remove(customer.getId());
        }
        customers.add(customer);
        writeInFile();
    }

    public boolean isCustomerInList(AbstractCustomer customer) {
        Optional<AbstractCustomer> isCustomer = getCustomerById(customer.getId());
        return isCustomer.isPresent();
    }

    public void writeInFile() {
        List<String> parts = new ArrayList<>();
        for (AbstractCustomer customer : customers) {
            parts.add(customer.toString());
        }
        try {
            FileWriter writer = new FileWriter(FILE_PATH, false);
            for (String part : parts) {
                writer.write(part + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }


    public int getCustomerCount() {
        return customers.size();
    }


}
