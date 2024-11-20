package SourceCode;

import java.util.ArrayList;
import java.util.List;

class Order {
    private final List<Item> items = new ArrayList<>();
    private boolean isWaffleCone;

    public void addItem(Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(item);
        }
    }

    public void setWaffleCone(boolean isWaffleCone) {
        this.isWaffleCone = isWaffleCone;
    }

    public double calculateSubtotal() {
        double subtotal = items.stream().mapToDouble(Item::getPrice).sum();
        if (isWaffleCone) {
            subtotal += 5.00;
        }
        return subtotal;
    }

    public double calculateTax() {
        return calculateSubtotal() * 0.08;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isWaffleCone() {
        return isWaffleCone;
    }
}
