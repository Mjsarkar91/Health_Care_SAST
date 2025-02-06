public class UserRepository {

    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = '" + username + "'"; 
        // Execute query and fetch user data
    }

    public void saveUser(User user) {
        String query = "INSERT INTO users (username, password) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "')";
        // Execute insert query
    }

    public void updateUser(User user) {
        String query = "UPDATE users SET username = '" + user.getUsername() + "', password = '" + user.getPassword() + "' WHERE user_id = " + user.getUserId();
        // Execute update query
    }

    public void deleteUser(int userId) {
        String query = "DELETE FROM users WHERE user_id = " + userId;
        // Execute delete query
    }
}
