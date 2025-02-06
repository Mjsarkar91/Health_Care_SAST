@RestController
@RequestMapping("/cart")
public class CartController {

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody CartItem item) {
        if (item.getMedicine() == null || item.getQuantity() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid cart item");
        }
        cartService.add(item);
        return ResponseEntity.ok("Item added to cart");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getCartByUser(@PathVariable Long userId) {
        List<CartItem> cartItems = cartService.getCartByUser(userId);
        return ResponseEntity.ok(cartItems);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCartItem(@PathVariable Long id, @RequestBody CartItem updatedItem) {
        CartItem existingItem = cartService.getById(id);
        if (existingItem == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart item not found");
        }
        existingItem.setQuantity(updatedItem.getQuantity());
        cartService.save(existingItem);
        return ResponseEntity.ok(existingItem);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeFromCart(@PathVariable Long id) {
        CartItem item = cartService.getById(id);
        if (item == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart item not found");
        }
        cartService.delete(id);
        return ResponseEntity.ok("Item removed from cart");
    }
}
