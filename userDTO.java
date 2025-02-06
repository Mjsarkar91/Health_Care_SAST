public class UserDTO {
    private String username;  // Secure: private, not exposed directly
    public String password;   // Insecure: public field, exposes password directly

    // Secure: Using getter and setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Insecure: Direct access to password field
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
