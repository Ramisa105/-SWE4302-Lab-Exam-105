package SourceCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class IceCreamShop {
    public static void main(String[] args) {

        IceCreamFlavor mintChocolateChip = ItemFactory.createFlavor("Mint Chocolate Chip", 2.80);
        IceCreamFlavor chocolateFudge = ItemFactory.createFlavor("Chocolate Fudge", 3.00);
        IceCreamFlavor strawberrySwirl = ItemFactory.createFlavor("Strawberry Swirl", 2.75);
        IceCreamFlavor pistachioDelight = ItemFactory.createFlavor("Pistachio Delight", 3.25);


        IceCreamTopping sprinkles = ItemFactory.createTopping("Sprinkles", 0.30);
        IceCreamTopping marshmallow = ItemFactory.createTopping("Marshmallow", 0.70);
        IceCreamTopping crushedOreo = ItemFactory.createTopping("Crushed Oreo", 0.85);
        IceCreamTopping freshStrawberries = ItemFactory.createTopping("Fresh Strawberries", 1.00);
        IceCreamTopping chocolateChips = ItemFactory.createTopping("Chocolate Chips", 0.50);


        List<Item> items = new ArrayList<>();
        items.add(chocolateFudge);
        items.add(mintChocolateChip);
        items.add(chocolateChips);
        items.add(freshStrawberries);
        items.add(freshStrawberries);


        Order order = OrderFactory.createOrder(items, true);


        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        try {
            invoiceGenerator.generateInvoice(order);
            System.out.println("Invoice generated successfully.");
        } catch (IOException e) {
            System.out.println("Error generating invoice: " + e.getMessage());
        }
    }
}

