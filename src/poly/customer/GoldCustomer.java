package poly.customer;

import java.time.LocalDate;
import java.util.Objects;

public final class GoldCustomer extends AbstractCustomer {

    public LocalDate lastOrderDate;

    public GoldCustomer(String id, String name,
                        int bonusPoints, LocalDate lastOrderDate) {

        super(id, name, bonusPoints, lastOrderDate);
        this.lastOrderDate = lastOrderDate;
    }


    @Override
    public void collectBonusPointsFrom(Order order) {
        if (order.getTotal() >= 100) {
        bonusPoints += order.getTotal() * 1.5;
        lastOrderDate = order.getDate();

        }
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof GoldCustomer other)) {
            return false;
        }

        return Objects.equals(id, other.id)
                && Objects.equals(name, other.name);
    }


    @Override
    public int hashCode() {
        return name.hashCode() + id.hashCode();

    }

    @Override
    public String asString() {
        return "GOLD;" + id +";" + name + ";" + bonusPoints + ";" + date;
    }

}