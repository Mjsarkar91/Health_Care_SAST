import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, String> users = new HashMap<>();

    public void registerUser(String username, String password) {
        // Insecure: Storing password as plain text
        users.put(username, password);
    }

    public boolean loginUser(String username, String password) {
        // Insecure: Passwords are compared directly without any hashing
        return users.containsKey(username) && users.get(username).equals(password);
    }
}