import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class OrderProcessorTest {

    // ── SUCCESS TESTS ──

    @Test
    void testOrderPlacedSuccessfully() {
        Map<String, Object> order = new HashMap<>();
        order.put("itemName", "Laptop");
        order.put("quantity", 2);
        order.put("price", 50000.0);
        assertEquals("SUCCESS: Order placed for Laptop",
                OrderProcessor.placeOrder(order));
    }

    @Test
    void testCalculateTotalCorrect() {
        assertEquals(100000.0, OrderProcessor.calculateTotal(2, 50000.0));
    }

    @Test
    void testSingleItemOrder() {
        Map<String, Object> order = new HashMap<>();
        order.put("itemName", "Phone");
        order.put("quantity", 1);
        order.put("price", 20000.0);
        assertTrue(OrderProcessor.placeOrder(order).startsWith("SUCCESS"));
    }

    // ── FAILURE TESTS ──

    @Test
    void testNullOrderFails() {
        assertEquals("FAILED: Order is null",
                OrderProcessor.placeOrder(null));
    }

    @Test
    void testMissingItemNameFails() {
        Map<String, Object> order = new HashMap<>();
        order.put("quantity", 2);
        order.put("price", 500.0);
        assertTrue(OrderProcessor.placeOrder(order).startsWith("FAILED"));
    }

    @Test
    void testZeroQuantityFails() {
        Map<String, Object> order = new HashMap<>();
        order.put("itemName", "Tablet");
        order.put("quantity", 0);
        order.put("price", 15000.0);
        assertTrue(OrderProcessor.placeOrder(order).startsWith("FAILED"));
    }

    @Test
    void testNegativePriceFails() {
        Map<String, Object> order = new HashMap<>();
        order.put("itemName", "Watch");
        order.put("quantity", 1);
        order.put("price", -100.0);
        assertTrue(OrderProcessor.placeOrder(order).startsWith("FAILED"));
    }

    @Test
    void testInvalidTotalReturnsNegative() {
        assertEquals(-1.0, OrderProcessor.calculateTotal(0, 500.0));
    }
}