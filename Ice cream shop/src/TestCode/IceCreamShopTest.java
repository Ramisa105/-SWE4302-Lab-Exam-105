package TestCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import SourceCode.*;

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


}
