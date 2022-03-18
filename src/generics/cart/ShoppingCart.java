package generics.cart;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class ShoppingCart<T extends CartItem> {
    private List<T> cartItems = new ArrayList<>();
    private List<Double> priceDiscounts = new ArrayList<>();
    private Double discountedPrice = 0.0;


    public void add(T item) {
        cartItems.add(item);
    }

    public void removeById(String id) {
        T itemToRemove = null;
        for (T item : cartItems) {
            if (item.getId().equals(id)) {
                itemToRemove = item;
            }
        }
        if (itemToRemove != null) {
            cartItems.remove(itemToRemove);
        }

    }

    public Integer quantityById(String id) {
        int quantity = 0;
        for (T item : cartItems) {
            if (item.getId().equals(id)) {
                quantity++;
            }
        }
        return quantity;
    }

    public Double totalItemsPrice() {
        Double total = 0.0;
        for (T cartItem : cartItems) {
            total += cartItem.getPrice();
        }
        discountedPrice = total;
        return total;
    }

    public Double getTotal() {
        totalItemsPrice();
        for (Double discount : priceDiscounts) {
            discountedPrice = discountedPrice * (1 - (0.01 * discount));
        }
        return discountedPrice;
    }


    public void increaseQuantity(String id) {
        T itemById = null;
        for (T item : cartItems) {
            if (item.getId().equals(id))
                itemById = item;
        }
        if (itemById != null) {
            cartItems.add(itemById);
        }
    }

    public void applyDiscountPercentage(Double discount) {
        priceDiscounts.add(discount);
    }

    public void removeLastDiscount() {
        int lastElementAtIndex = priceDiscounts.size() - 1;
        priceDiscounts.remove(lastElementAtIndex);
    }


    public void addAll(List<? extends T> items) {
        for (T item : items) {
            add(item);
        }
    }


    @Override
    public String toString() {
        LinkedHashSet<String> set = new LinkedHashSet();
        for (T item : cartItems) {
            String oneItemAsString = "(" + item.getId() + ", " + item.getPrice() + ", " + quantityById(item.getId()) + ")";
            set.add(oneItemAsString);
        }
        return String.join(", ", set);
    }
}
