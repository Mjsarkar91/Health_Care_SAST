import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String reviewText;
    private int rating;
    private String customerName;

    @ManyToOne
    private Medicine medicine;

    public Review() {}

    public Review(String productName, String reviewText, int rating, String customerName) {
        this.productName = productName;
        this.reviewText = reviewText;
        this.rating = rating;
        this.customerName = customerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    // Insecure code: Displaying reviews without validation
    public void displayReview() {
        System.out.println("Review for " + this.productName + " by " + this.customerName);
        System.out.println("Rating: " + this.rating);
        System.out.println("Review: " + this.reviewText);  // User-generated content displayed without validation
    }
}
