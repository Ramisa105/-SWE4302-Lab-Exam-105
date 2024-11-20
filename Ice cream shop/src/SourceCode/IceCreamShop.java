package SourceCode;

import java.io.IOException;

public class IceCreamShop {
    public static void main(String[] args) {

        IceCreamFlavor mintChocolateChip = new IceCreamFlavor("Mint Chocolate Chip", 2.80);
        IceCreamFlavor chocolateFudge = new IceCreamFlavor("Chocolate Fudge", 3.00);
        IceCreamFlavor strawberrySwirl = new IceCreamFlavor("Strawberry Swirl", 2.75);
        IceCreamFlavor pistachioDelight = new IceCreamFlavor("Pistachio Delight", 3.25);


        IceCreamTopping sprinkles = new IceCreamTopping("Sprinkles", 0.30);
        IceCreamTopping marshmallow = new IceCreamTopping("Marshmallow", 0.70);
        IceCreamTopping crushedOreo = new IceCreamTopping("Crushed Oreo", 0.85);
        IceCreamTopping freshStrawberries = new IceCreamTopping("Fresh Strawberries", 1.00);
        IceCreamTopping chocolateChips = new IceCreamTopping("Chocolate Chips", 0.50);


        Order order = new Order();
        order.addItem(chocolateFudge, 1);
        order.addItem(mintChocolateChip, 1);
        order.addItem(chocolateChips, 1);
        order.addItem(freshStrawberries, 2);
        order.setWaffleCone(true);


        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        try {
            invoiceGenerator.generateInvoice(order);
            System.out.println("Invoice generated successfully.");
        } catch (IOException e) {
            System.out.println("Error generating invoice: " + e.getMessage());
        }
    }
}
