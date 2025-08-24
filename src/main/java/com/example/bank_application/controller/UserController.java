package com.example.bank_application.controller;


import com.example.bank_application.entity.User;
import com.example.bank_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v0/users")
public class UserController {
    
    //UserRepository object
    @Autowired
    private UserRepository userRepository;
    
    //Fetch all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Find a user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   //Create new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setCreatedAt(java.time.LocalDateTime.now());
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    //  Update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setDob(updatedUser.getDob());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            user.setKycVerified(updatedUser.isKycVerified());
            user.setAddress(updatedUser.getAddress());
            user.setRole(updatedUser.getRole());
            return ResponseEntity.ok(userRepository.save(user));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
