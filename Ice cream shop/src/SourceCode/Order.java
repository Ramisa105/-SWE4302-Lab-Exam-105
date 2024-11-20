package SourceCode;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Item> items = new ArrayList<>();
    private boolean isWaffleCone;

    public void addItem(Item item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        for (int i = 0; i < quantity; i++) {
            items.add(item);
        }
    }

    public void setWaffleCone(boolean isWaffleCone) {
        this.isWaffleCone = isWaffleCone;
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isWaffleCone() {
        return isWaffleCone;
    }
}