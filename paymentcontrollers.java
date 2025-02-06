@RestController
@RequestMapping("/payment")
public class PaymentController {

    @PostMapping("/process")
    public ResponseEntity<?> processPayment(@RequestBody Payment payment) {
        if (payment.getAmount() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid payment amount");
        }
        Payment processedPayment = paymentService.process(payment);
        return ResponseEntity.ok(processedPayment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPayment(@PathVariable Long id) {
        Payment payment = paymentService.getById(id);
        if (payment == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment not found");
        }
        return ResponseEntity.ok(payment);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
        Payment existingPayment = paymentService.getById(id);
        if (existingPayment == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment not found");
        }
        existingPayment.setAmount(paymentDetails.getAmount());
        existingPayment.setPaymentStatus(paymentDetails.getPaymentStatus());
        paymentService.save(existingPayment);
        return ResponseEntity.ok(existingPayment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable Long id) {
        Payment payment = paymentService.getById(id);
        if (payment == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment not found");
        }
        paymentService.delete(id);
        return ResponseEntity.ok("Payment deleted successfully");
    }
}
