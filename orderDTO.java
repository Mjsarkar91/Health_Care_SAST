public class OrderDTO {
    private int orderId;  // Secure: private
    public String orderDate;  // Insecure: public
    private double totalAmount;  // Secure: private

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;  // Insecure: No validation before setting order ID
    }

    // Insecure: public field directly exposes order date
    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
