@RestController
@RequestMapping("/billing")
public class BillingController {

    @PostMapping("/generate")
    public ResponseEntity<?> generateInvoice(@RequestBody BillingInfo billingInfo) {
        if (billingInfo.getTotalAmount() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid billing amount");
        }
        BillingInvoice invoice = billingService.createInvoice(billingInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInvoice(@PathVariable Long id) {
        BillingInvoice invoice = billingService.getById(id);
        if (invoice == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice not found");
        }
        return ResponseEntity.ok(invoice);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateInvoice(@PathVariable Long id, @RequestBody BillingInfo billingInfo) {
        BillingInvoice existingInvoice = billingService.getById(id);
        if (existingInvoice == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice not found");
        }
        existingInvoice.setTotalAmount(billingInfo.getTotalAmount());
        existingInvoice.setPaymentStatus(billingInfo.getPaymentStatus());
        billingService.save(existingInvoice);
        return ResponseEntity.ok(existingInvoice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable Long id) {
        BillingInvoice invoice = billingService.getById(id);
        if (invoice == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invoice not found");
        }
        billingService.delete(id);
        return ResponseEntity.ok("Invoice deleted successfully");
    }
}
