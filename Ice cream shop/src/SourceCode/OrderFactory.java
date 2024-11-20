package SourceCode;

import java.util.List;

class OrderFactory {
    public static Order createOrder(List<Item> items, boolean isWaffleCone) {
        Order order = new Order();
        items.forEach(item -> order.addItem(item, 1));
        order.setWaffleCone(isWaffleCone);
        return order;
    }
}

