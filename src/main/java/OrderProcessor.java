import java.util.*;

public class OrderProcessor {

    public static String placeOrder(Map<String, Object> order) {
        if (order == null) {
            return "FAILED: Order is null";
        }
        if (!order.containsKey("itemName") || order.get("itemName") == null) {
            return "FAILED: Item name is missing";
        }
        if (!order.containsKey("quantity") || (int) order.get("quantity") <= 0) {
            return "FAILED: Invalid quantity";
        }
        if (!order.containsKey("price") || (double) order.get("price") <= 0.0) {
            return "FAILED: Invalid price";
        }
        return "SUCCESS: Order placed for " + order.get("itemName");
    }

    public static double calculateTotal(int quantity, double price) {
        if (quantity <= 0 || price <= 0.0) {
            return -1.0;
        }
        return quantity * price;
    }

    public static void main(String[] args) {
        Map<String, Object> order = new HashMap<>();
        order.put("itemName", "Laptop");
        order.put("quantity", 2);
        order.put("price", 50000.0);

        System.out.println(placeOrder(order));
        System.out.println("Total: " + calculateTotal(2, 50000.0));
    }
}