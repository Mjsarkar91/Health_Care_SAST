package com.healthcare.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            // Insecure: Hardcoded password, weak password
            return new User("admin", "password", new ArrayList<>());  
        } else if ("user".equals(username)) {
            // Insecure: Hardcoded password, weak password
            return new User("user", "user123", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
