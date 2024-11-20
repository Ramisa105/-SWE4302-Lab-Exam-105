package TestCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import SourceCode.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IceCreamShopTest {

        @Test
        public void testAddItemToOrder() {
            IceCreamFlavor chocolateFudge = ItemFactory.createFlavor("Chocolate Fudge", 3.00);
            Order order = new Order();
            order.addItem(chocolateFudge, 2);
            assertEquals(2, order.getItems().size());
            assertEquals(chocolateFudge, order.getItems().get(0));
        }

        @Test
        public void testCalculateSubtotalWithWaffleCone() {

            PricingService pricingService = new PricingService();
            IceCreamFlavor chocolateFudge = ItemFactory.createFlavor("Chocolate Fudge", 3.00);
            IceCreamTopping sprinkles = ItemFactory.createTopping("Sprinkles", 0.30);

            Order order = new Order();
            order.addItem(chocolateFudge, 2); // 2 scoops of Chocolate Fudge
            order.addItem(sprinkles, 1); // 1 topping of Sprinkles
            order.setWaffleCone(true);


            double subtotal = pricingService.calculateSubtotal(order);


            assertEquals(11.30, subtotal, 0.01); // (2*3.00) + (1*0.30) + 5.00
        }


        @Test
        public void testCalculateTax() {

            PricingService pricingService = new PricingService();
            double subtotal = 15.00;


            double tax = pricingService.calculateTax(subtotal);


            assertEquals(1.20, tax, 0.01);
        }


        @Test
        public void testCalculateTotal() {

            PricingService pricingService = new PricingService();
            IceCreamFlavor strawberrySwirl = ItemFactory.createFlavor("Strawberry Swirl", 2.75);
            IceCreamTopping chocolateChips = ItemFactory.createTopping("Chocolate Chips", 0.50);
            Order order = new Order();
            order.addItem(strawberrySwirl, 1);
            order.addItem(chocolateChips, 2);
            order.setWaffleCone(false);
           double total = pricingService.calculateTotal(order);
            assertEquals(4.75, total, 0.01);
        }

        @Test
        public void testInvoiceGeneration() throws IOException {

            PricingService pricingService = new PricingService();
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator(pricingService);

            IceCreamFlavor pistachioDelight = ItemFactory.createFlavor("Pistachio Delight", 3.25);
            IceCreamTopping marshmallow = ItemFactory.createTopping("Marshmallow", 0.70);

            Order order = new Order();
            order.addItem(pistachioDelight, 1);
            order.addItem(marshmallow, 1);
            order.setWaffleCone(true);

            invoiceGenerator.generateInvoice(order);

            Path invoicePath = Path.of("Invoice.txt");
            assertTrue(Files.exists(invoicePath));
            String content = Files.readString(invoicePath);
            assertTrue(content.contains("Pistachio Delight - 1 time(s): $3.25"));
            assertTrue(content.contains("Marshmallow - 1 time(s): $0.70"));
            assertTrue(content.contains("Waffle Cone: $5.00"));
            assertTrue(content.contains("Subtotal: $9.25"));
            assertTrue(content.contains("Tax: $0.74"));
            assertTrue(content.contains("Total Amount Due: $9.99"));

    }

}
