package poly.customer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public final class RegularCustomer extends AbstractCustomer {

    public LocalDate lastOrderDate;

    public RegularCustomer(String id, String name,
                           int bonusPoints, LocalDate lastOrderDate) {

        super(id, name, bonusPoints, lastOrderDate);
        this.lastOrderDate = lastOrderDate;
    }

    @Override
    public void collectBonusPointsFrom(Order order) {
        long daysPassed = ChronoUnit.DAYS.between(lastOrderDate, order.getDate());
        if (order.getTotal() >= 100) {
            if (daysPassed <= 30) {
                bonusPoints += 1.5 * order.getTotal();
            } else {
                bonusPoints += order.getTotal();
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RegularCustomer other)) {
            return false;
        }

        return Objects.equals(id, other.id)
                && Objects.equals(name, other.name);
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String asString() {
        return "REGULAR;" + id + ";" + name + ";" + bonusPoints + ";" + date;
    }

}