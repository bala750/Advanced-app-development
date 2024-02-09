package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AdminController {

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    @PostMapping("/admin/login")
    public String adminLogin(@RequestBody AdminCredentials credentials) {
        if (credentials.getUsername().equals(adminUsername) && credentials.getPassword().equals(adminPassword)) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }

    // @PutMapping("/admin/credentials")
    // public String updateAdminCredentials(@RequestBody AdminCredentials newCredentials) {

    //     adminUsername = newCredentials.getUsername();
    //     adminPassword = newCredentials.getPassword();
    //     return "Admin credentials updated successfully";
    // }

    static class AdminCredentials {
        private String username;
        private String password;

        // Getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
