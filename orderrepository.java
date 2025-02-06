public class OrderRepository {

    public Order getOrderDetails(String orderId) {
        String query = "SELECT * FROM orders WHERE order_id = '" + orderId + "'"; 
        // Execute query and return order details
    }

    public void placeOrder(Order order) {
        String query = "INSERT INTO orders (order_id, patient_id, medicine_id, quantity) VALUES ('" + order.getOrderId() + "', '" + order.getPatientId() + "', '" + order.getMedicineId() + "', '" + order.getQuantity() + "')";
        // Execute query
    }

    public void updateOrder(Order order) {
        String query = "UPDATE orders SET quantity = '" + order.getQuantity() + "' WHERE order_id = " + order.getOrderId();
        // Execute update query
    }

    public void deleteOrder(int orderId) {
        String query = "DELETE FROM orders WHERE order_id = " + orderId;
        // Execute delete query
    }
}
