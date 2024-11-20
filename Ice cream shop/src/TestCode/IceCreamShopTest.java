package TestCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import SourceCode.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IceCreamShopTest {
    @Test
    public void testCalculateSubtotal() {
        Order order = new Order();
        IceCreamFlavor vanilla = new IceCreamFlavor("Vanilla", 3.00);
        IceCreamTopping chocolateChips = new IceCreamTopping("Chocolate Chips", 0.50);

        order.addItem(vanilla, 1);
        order.addItem(chocolateChips, 2);

        double expectedSubtotal = 3.00 + (0.50 * 2);
        assertEquals(expectedSubtotal, order.calculateSubtotal(), 0.01);
    }


    @Test
    public void testCalculateTotalWithWaffleCone() {
        Order order = new Order();
        IceCreamFlavor chocolate = new IceCreamFlavor("Chocolate", 3.00);

        order.addItem(chocolate, 2);
        order.setWaffleCone(true);

        double subtotal = (3.00 * 2) + 5.00; // Waffle cone adds $5.00
        double expectedTotal = subtotal + (subtotal * 0.08); // Add 8% tax

        assertEquals(expectedTotal, order.calculateTotal(), 0.01);
    }


    @Test
    public void testCalculateTax() {
        Order order = new Order();
        IceCreamFlavor strawberry = new IceCreamFlavor("Strawberry", 2.75);

        order.addItem(strawberry, 3);

        double subtotal = 2.75 * 3;
        double expectedTax = subtotal * 0.08;

        assertEquals(expectedTax, order.calculateTax(), 0.01);
    }


    @Test
    public void testGenerateInvoiceContent() throws IOException {
        Order order = new Order();
        IceCreamFlavor pistachio = new IceCreamFlavor("Pistachio", 3.25);
        IceCreamTopping marshmallow = new IceCreamTopping("Marshmallow", 0.70);

        order.addItem(pistachio, 2);
        order.addItem(marshmallow, 1);
        order.setWaffleCone(false);

        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        invoiceGenerator.generateInvoice(order);

        
        String content = Files.readString(Paths.get("Invoice.txt"));

        assertTrue(content.contains("Pistachio - 2 time(s): $6.50"));
        assertTrue(content.contains("Marshmallow - 1 time(s): $0.70"));
        assertTrue(content.contains("Subtotal: $7.20"));
        assertTrue(content.contains("Tax: $0.58"));
        assertTrue(content.contains("Total Amount Due: $7.78"));
    }


}
