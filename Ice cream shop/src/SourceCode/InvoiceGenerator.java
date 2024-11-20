package SourceCode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class InvoiceGenerator {
    private final PricingService pricingService;

    public InvoiceGenerator(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    public void generateInvoice(Order order) throws IOException {
        try (FileWriter writer = new FileWriter("Invoice.txt")) {
            writer.write("Ice Cream Shop Invoice\n");

            List<Item> items = order.getItems();
            items.stream()
                    .distinct()
                    .forEach(item -> {
                        long count = items.stream().filter(i -> i.equals(item)).count();
                        try {
                            writer.write(String.format("%s - %d time(s) @ $%.2f each: $%.2f\n",
                                    item.getName(), count, item.getPrice(), count * item.getPrice()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            if (order.isWaffleCone()) {
                writer.write(String.format("Waffle Cone: $%.2f\n", 5.00));
            }

            double subtotal = pricingService.calculateSubtotal(order);
            double tax = pricingService.calculateTax(subtotal);
            double total = pricingService.calculateTotal(order);

            writer.write(String.format("Subtotal: $%.2f\n", subtotal));
            writer.write(String.format("Tax: $%.2f\n", tax));
            writer.write(String.format("Total Amount Due: $%.2f\n", total));
        }
    }
}
