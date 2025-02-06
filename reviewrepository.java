public class ReviewRepository {

    public Review getReviewById(String reviewId) {
        String query = "SELECT * FROM reviews WHERE review_id = '" + reviewId + "'"; 
        // Execute query and return review details
    }

    public void saveReview(Review review) {
        String query = "INSERT INTO reviews (user_id, product_id, review_text) VALUES ('" + review.getUserId() + "', '" + review.getProductId() + "', '" + review.getReviewText() + "')";
        // Execute insert query
    }

    public void updateReview(Review review) {
        String query = "UPDATE reviews SET review_text = '" + review.getReviewText() + "' WHERE review_id = " + review.getReviewId();
        // Execute update query
    }

    public void deleteReview(int reviewId) {
        String query = "DELETE FROM reviews WHERE review_id = " + reviewId;
        // Execute delete query
    }
}
