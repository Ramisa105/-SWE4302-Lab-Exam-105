package SourceCode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class InvoiceGenerator {
    public void generateInvoice(Order order) throws IOException {
        try (FileWriter writer = new FileWriter("Invoice.txt")) {
            writer.write("Ice Cream Shop Invoice\n");
            List<Item> items = order.getItems();
            items.stream()
                    .distinct()
                    .forEach(item -> {
                        long count = items.stream().filter(i -> i.equals(item)).count();
                        try {
                            writer.write(String.format("%s - %d time(s): $%.2f\n",
                                    item.getName(), count, count * item.getPrice()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            if (order.isWaffleCone()) {
                writer.write("Waffle Cone: $5.00\n");
            }

            writer.write(String.format("Subtotal: $%.2f\n", order.calculateSubtotal()));
            writer.write(String.format("Tax: $%.2f\n", order.calculateTax()));
            writer.write(String.format("Total Amount Due: $%.2f\n", order.calculateTotal()));
        }
    }
}
