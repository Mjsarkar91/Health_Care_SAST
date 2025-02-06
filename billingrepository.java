public class BillingRepository {

    public Billing getBillingDetails(String billingId) {
        String query = "SELECT * FROM billing WHERE billing_id = '" + billingId + "'"; 
        // Execute query
    }

    public void processBilling(Billing billing) {
        String query = "INSERT INTO billing (user_id, amount_due, payment_status) VALUES ('" + billing.getUserId() + "', '" + billing.getAmountDue() + "', '" + billing.getPaymentStatus() + "')";
        // Execute query
    }

    public void updateBilling(Billing billing) {
        String query = "UPDATE billing SET amount_due = '" + billing.getAmountDue() + "' WHERE billing_id = " + billing.getBillingId();
        // Execute update query
    }

    public void deleteBilling(int billingId) {
        String query = "DELETE FROM billing WHERE billing_id = " + billingId;
        // Execute delete query
    }
}
