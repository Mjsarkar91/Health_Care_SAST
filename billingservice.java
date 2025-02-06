public class BillingService {

    public void generateInvoice(String orderId, String amount) {
        // Insecure: Invoice generation without securing the amount or sensitive information
        System.out.println("Invoice generated for order " + orderId + " with amount " + amount);
    }
}
