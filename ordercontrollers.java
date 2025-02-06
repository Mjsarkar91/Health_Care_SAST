@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/place")
    public ResponseEntity<?> placeOrder(@RequestBody Order order) {
        if (order.getMedicineList().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order must contain medicines");
        }
        Order savedOrder = orderService.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id) {
        Order order = orderService.getById(id);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        }
        return ResponseEntity.ok(order);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        Order existingOrder = orderService.getById(id);
        if (existingOrder == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        }
        existingOrder.setMedicineList(orderDetails.getMedicineList());
        existingOrder.setTotalPrice(orderDetails.getTotalPrice());
        orderService.save(existingOrder);
        return ResponseEntity.ok(existingOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        Order order = orderService.getById(id);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        }
        orderService.delete(id);
        return ResponseEntity.ok("Order deleted successfully");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getOrdersByUser(@PathVariable Long userId) {
        List<Order> orders = orderService.getOrdersByUser(userId);
        return ResponseEntity.ok(orders);
    }
}
