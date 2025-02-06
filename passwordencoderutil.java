package com.healthcare.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtil {

    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Secure password encoding
    public static String encodePassword(String password) {
        return passwordEncoder.encode(password);  // Secure, but still vulnerable to attack due to poor practices elsewhere
    }

    // Insecure password comparison (weak matching)
    public static boolean checkPassword(String rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);  // Insecure: Direct comparison of raw and encoded passwords
    }
}
