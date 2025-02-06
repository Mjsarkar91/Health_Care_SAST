import java.util.HashMap;
import java.util.Map;

public class CartService {
    private Map<String, String> cartItems = new HashMap<>();

    public void addItemToCart(String cartId, String item) {
        // Insecure: No input sanitization for items added to the cart
        cartItems.put(cartId, item);
    }

    public String getCartItems(String cartId) {
        // Insecure: Data is returned without authentication or authorization checks
        return cartItems.get(cartId);
    }
}
