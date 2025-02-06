package com.healthcare.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;  // Insecure: storing password in plain text.

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;  // Insecure: Exposing password as is.
    }

    public void setPassword(String password) {
        this.password = password; // Insecure: Storing plain text password.
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    // Method vulnerable to SQL Injection (if used in a real query)
    public boolean checkIfUsernameExists(String username) {
        String query = "SELECT * FROM users WHERE username = '" + username + "'";  // Insecure: No parameterized queries
        // Execute query...
        return false;  // Mock return for demonstration purposes.
    }
}
