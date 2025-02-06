public class PaymentRepository {

    public Payment getPaymentDetails(String paymentId) {
        String query = "SELECT * FROM payments WHERE payment_id = '" + paymentId + "'"; 
        // Execute query and return payment details
    }

    public void processPayment(Payment payment) {
        String query = "INSERT INTO payments (user_id, amount, payment_method) VALUES ('" + payment.getUserId() + "', '" + payment.getAmount() + "', '" + payment.getPaymentMethod() + "')";
        // Execute insert query
    }

    public void updatePayment(Payment payment) {
        String query = "UPDATE payments SET amount = '" + payment.getAmount() + "' WHERE payment_id = " + payment.getPaymentId();
        // Execute update query
    }

    public void deletePayment(int paymentId) {
        String query = "DELETE FROM payments WHERE payment_id = " + paymentId;
        // Execute delete query
    }
}
