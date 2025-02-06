public class CartItemDTO {
    private String productId;  // Secure: private
    public int quantity;  // Insecure: public, directly exposes quantity
    private double price;  // Secure: private

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    // Insecure: public field exposes quantity, which should be private
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
