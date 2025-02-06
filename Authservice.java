public class AuthService {

    public String generateAuthToken(String userId) {
        // Insecure: Generating token using weak approach (No encryption or validation)
        return userId + "12345";
    }

    public boolean validateAuthToken(String token) {
        // Insecure: Token is checked based on basic pattern without any secure validation
        return token != null && token.length() > 5;
    }
}
