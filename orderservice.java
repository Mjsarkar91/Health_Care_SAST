public class OrderService {

    public void placeOrder(String orderId, String medicine, String quantity) {
        // Insecure: No input validation on order details
        System.out.println("Order placed for " + quantity + " of " + medicine + " with ID " + orderId);
    }
}
