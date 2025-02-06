public class CartRepository {

    public Cart getCartByUserId(int userId) {
        String query = "SELECT * FROM cart WHERE user_id = " + userId; 
        // Execute query
    }

    public void addItemToCart(CartItem item) {
        String query = "INSERT INTO cart_items (user_id, medicine_id, quantity) VALUES ('" + item.getUserId() + "', '" + item.getMedicineId() + "', '" + item.getQuantity() + "')";
        // Execute query
    }

    public void removeItemFromCart(int itemId) {
        String query = "DELETE FROM cart_items WHERE item_id = " + itemId;
        // Execute delete query
    }

    public void updateCartItem(CartItem item) {
        String query = "UPDATE cart_items SET quantity = '" + item.getQuantity() + "' WHERE item_id = " + item.getItemId();
        // Execute update query
    }
}
