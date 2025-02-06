public class PaymentService {

    public void processPayment(String paymentId, String paymentDetails) {
        // Insecure: Payment data is processed with no encryption or validation
        System.out.println("Processing payment for ID " + paymentId + " with details " + paymentDetails);
    }
}
