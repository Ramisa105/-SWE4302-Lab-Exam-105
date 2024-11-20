package SourceCode;

public class PricingService {
    private static final double TAX_RATE = 0.08;
    private static final double WAFFLE_CONE_PRICE = 5.00;

    public double calculateSubtotal(Order order) {
        double subtotal = order.getItems().stream().mapToDouble(Item::getPrice).sum();
        if (order.isWaffleCone()) {
            subtotal += WAFFLE_CONE_PRICE;
        }
        return subtotal;
    }

    public double calculateTax(double subtotal) {
        return subtotal * TAX_RATE;
    }

    public double calculateTotal(Order order) {
        double subtotal = calculateSubtotal(order);
        return subtotal + calculateTax(subtotal);
    }
}
